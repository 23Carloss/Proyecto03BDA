/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import Conexion.ConexionBaseDatos;
import Dominio.AlbumDominio;
import Dominio.CuentaDominio;
import Encriptador.Encriptador;
import Interfaces.ICuentaDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CuentaDAO implements ICuentaDAO {
    
    private MongoDatabase bd;
    private MongoCollection<CuentaDominio> coleccionCuentas;
    private Encriptador encriptador;
    
    private static CuentaDAO instanciaCuentaDAO;
    
    public static CuentaDAO getInstanciaDAO() {
        if (instanciaCuentaDAO == null) {
            instanciaCuentaDAO = new CuentaDAO();
        }
        return instanciaCuentaDAO;
    }
    public CuentaDAO(){
        bd = new ConexionBaseDatos().conexion();
        this.coleccionCuentas = bd.getCollection("Cuenta", CuentaDominio.class);
        this.encriptador = new Encriptador();
    }
    @Override
    public CuentaDominio iniciarSesion(String corrreoE, String contra){
        for(CuentaDominio cuenta : coleccionCuentas.find()){
            System.out.println("Cuentas>DAO>IniciarSesion>  " +  cuenta.toString());
            if(cuenta.getCorreoE().equals(corrreoE)){
                System.out.println("Cuenta encontrada:  " + cuenta.toString());
                //validar contrasenha
                // la variable "contra" es la q ingresa el usuario y la encriptamos
                if(encriptador.encriptarContrasenha(contra).equals(cuenta.getContrasenha())){//verificamos con la contra que tenemos guardada en la bd (ya encriptada)
                    System.out.println("Inicio de sesion correcto!");
                    return cuenta; // obtenerCuenta(cuenta.getCorreoE()); // obtenemos la cuenta una vez iniciada la sesion
                }else{
                    //control.mostrarErrorCredencialesIncorrectas();
                    System.out.println("Credenciales Incorrectas!");
                    return null;
                }
            }
        }
        System.out.println("No se encontro una cuenta con el nombre:  " + corrreoE);
        return null;
    }
    @Override
    public CuentaDominio registrarse(CuentaDominio cuenta){
//        System.out.println("Cuenta que llega a la DAO:  " + cuenta.toString());
        cuenta.setContrasenha(encriptador.encriptarContrasenha(cuenta.getContrasenha()));
        coleccionCuentas.insertOne(cuenta);
//        System.out.println("Cuenta que sale de la DAO:  " + cuentaDocumento.toString());
        return cuenta;
//        ArrayList<CuentaDominio> cuentas = coleccionCuentas.find();
        
    }
    @Override
    public void editarCuenta(CuentaDominio cambios, CuentaDominio cuentaAEditar){
        //cuentaAEditar traera los nuevos atributos y estos seran seteados al documento que se encuentre en la coleccion
        Document cuentaEncontrada = new Document("_id", cuentaAEditar.getId());//filtro del coumento
        
        Document cuentaActualizada = new Document(); // documento para setear los nuevos datos
        
        cuentaActualizada.append("nombreUsuario", cambios.getNombreUsuario());
        cuentaActualizada.append("contrasenha", encriptador.encriptarContrasenha(cambios.getContrasenha()));
        cuentaActualizada.append("correoE", cambios.getCorreoE());
        
        //falta el icono del perfil
        
        Document actualizar = new Document("$set", cuentaActualizada);
        UpdateResult resultado = coleccionCuentas.updateOne(cuentaEncontrada, actualizar);
        System.out.println("Cuenta Editada :  " +resultado.toString());
        
   
    }
    @Override
    public void agregarAlbumFavoritos(CuentaDominio cuenta, AlbumDominio album){
        cuenta.getListaAlbumenFav().add(album);
        
    }
    
    @Override
    public CuentaDominio obtenerCuenta(String correoE){
        for (CuentaDominio cuenta : coleccionCuentas.find()) {
            if(cuenta.getCorreoE().equals(correoE)){
                return cuenta;
            }
        }
        return null;
        
    }
    public ArrayList<CuentaDominio> consultarCuentas(){
        return coleccionCuentas.find().into( new ArrayList());
    }
}

