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
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CuentaDAO implements ICuentaDAO {
    
    private MongoDatabase bd;
    private MongoCollection<Document> coleccionCuentas;
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
        this.coleccionCuentas = bd.getCollection("Cuenta");
        this.encriptador = new Encriptador();
    }
    @Override
    public boolean iniciarSesion(String corrreoE, String contra){
        for(Document cuenta : coleccionCuentas.find()){
            if(cuenta.getString("correoE").equals(corrreoE)){
                System.out.println("Cuenta encontrada:  " + cuenta.getString("nombreUsuario"));
                //validar contrasenha
                // la variable "contra" es la q ingresa el usuario y la encriptamos
                if(encriptador.encriptarContrasenha(contra).equals(cuenta.getString("contrasenha"))){//verificamos con la contra que tenemos guardada en la bd (ya encriptada)
                    System.out.println("Inicio de sesion correcto!");
                    return true;
                }else{
                    //control.mostrarErrorCredencialesIncorrectas();
                    System.out.println("Credenciales Incorrectas!");
                    return false;
                }
            }
        }
        System.out.println("No se encontro una cuenta con el nombre:  " + corrreoE);
        return false;
    }
    @Override
    public Document registrarse(CuentaDominio cuenta){
//        System.out.println("Cuenta que llega a la DAO:  " + cuenta.toString());
        Document cuentaDocumento = new Document();
        cuentaDocumento.append("nombreUsuario", cuenta.getNombreU());
        cuentaDocumento.append("correoE", cuenta.getCorreoE());
        cuentaDocumento.append("contrasenha", encriptador.encriptarContrasenha(cuenta.getContrasenha()));
        coleccionCuentas.insertOne(cuentaDocumento);
//        System.out.println("Cuenta que sale de la DAO:  " + cuentaDocumento.toString());
        return cuentaDocumento;
//        ArrayList<CuentaDominio> cuentas = coleccionCuentas.find();
        
    }
    @Override
    public void editarCuenta(CuentaDominio cambios){
        //cuentaAEditar traera los nuevos atributos y estos seran seteados al documento que se encuentre en la coleccion
        Document cuentaEncontrada = new Document("nombreUsuario", cambios.getNombreU());//tengo que buscar una manera mas facil de tener la cuenta desde el inicio
        if(cuentaEncontrada == null){
            System.out.println("Cuenta no encontrada");
            return; //nunca sera null pq se supone que se inicia sesion al iniciar la app
        }
        System.out.println("Cuenta antes de ser editada :  " + cuentaEncontrada.toString());
        Document cuentaActualizada = new Document(); // documento para setear los nuevos datos
        cuentaActualizada.append("nombreUsuario", cambios.getNombreU());
        cuentaActualizada.append("contrasenha", encriptador.encriptarContrasenha(cambios.getContrasenha()));
        cuentaActualizada.append("correoE", cambios.getCorreoE());
        //falta el icono del perfil
        
        Document actualizar = new Document("$set", cuentaActualizada); //seteamos los valores al documento con "$set"
        
        coleccionCuentas.updateOne(cuentaEncontrada, actualizar);
        System.out.println("Cuenta Editada :  " + coleccionCuentas.updateOne(cuentaEncontrada, actualizar).toString());
        
   
    }
    @Override
    public void agregarAlbumFavoritos(CuentaDominio cuenta, AlbumDominio album){
        cuenta.getListaAlbumenFav().add(album);
        
    }
    public ArrayList<CuentaDominio> consultarCuentas(){
        return coleccionCuentas.find().into( new ArrayList());
    }
}

