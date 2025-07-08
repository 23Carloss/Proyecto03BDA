/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import DTO.CuentaDTO;
import Dominio.CuentaDominio;
import Interfaces.ICuentaDAO;
import Interfacez.ICuentaBO;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CuentaBO implements ICuentaBO{
    
    private ICuentaDAO cuentaDAO;
    
    public CuentaBO(ICuentaDAO cuenta){
        this.cuentaDAO = cuenta;
    }
    
    @Override
    public CuentaDTO registrarse(CuentaDTO cuenta){
        String contrasenhaSinEncriptar = cuenta.getContrasenha();
        System.out.println("Cuenta que llega a la BO desde Presentacion:  " + cuenta.toString());
        CuentaDominio cuentaRegistrar = new CuentaDominio();
        
        cuentaRegistrar.setContrasenha(contrasenhaSinEncriptar); // para mostrar la contrasenha sin encriptar
        cuentaRegistrar.setCorreoE(cuenta.getCorreoE());
        cuentaRegistrar.setNombreUsuario(cuenta.getNombreU());
        cuentaRegistrar.setListaAlbumenFav(cuenta.getAlbumesFav());
        cuentaRegistrar.setImagenPerfil(cuenta.getImagenPerfil());
        
        CuentaDominio cuentaAgregada = cuentaDAO.registrarse(cuentaRegistrar);
        cuenta.setContrasenha(cuenta.getContrasenha());//sin encriptar
        cuenta.setCorreoE(cuentaAgregada.getCorreoE());
        cuenta.setNombreU(cuentaAgregada.getNombreUsuario());
        
        System.out.println("Cuenta agregada que manda la dao>BO>Registrarse:   "+ cuentaAgregada.toString());
        System.out.println("Cuenta que regresa a presentacion>BO>Registrarse:   "+ cuenta.toString());
        return cuenta;
    }
    @Override
    public CuentaDTO IniciarSesion(String correoE, String contra){
        CuentaDTO cuentaEncontrada = new CuentaDTO();
        CuentaDominio cuentaEncontradaDominio = cuentaDAO.iniciarSesion(correoE, contra);
        cuentaEncontrada.setContrasenha(contra);//para mostrar la contra sin encriptacion      
        cuentaEncontrada.setCorreoE(cuentaEncontradaDominio.getCorreoE());
        cuentaEncontrada.setNombreU(cuentaEncontradaDominio.getNombreUsuario());
        cuentaEncontrada.setId(cuentaEncontradaDominio.getId());
        System.out.println("Cuenta que regresa a presentacion>BO>IniciarSesion:   "+ cuentaEncontrada.toString());
        return cuentaEncontrada;
        
    }
    @Override
    public void editarPerfil(CuentaDTO cuenta, CuentaDTO cuentaAEditar){
        CuentaDominio cuentaAEditadaDominio = new CuentaDominio();
        CuentaDominio cuentaActualDominio = new CuentaDominio();
        
        cuentaAEditadaDominio.setContrasenha(cuentaAEditar.getContrasenha());
        cuentaAEditadaDominio.setCorreoE(cuentaAEditar.getCorreoE());
        cuentaAEditadaDominio.setNombreUsuario(cuentaAEditar.getNombreU());
        cuentaAEditadaDominio.setId(cuentaAEditar.getId());
        
        cuentaActualDominio.setContrasenha(cuenta.getContrasenha());
        cuentaActualDominio.setCorreoE(cuenta.getCorreoE());
        cuentaActualDominio.setNombreUsuario(cuenta.getNombreU());
        cuentaActualDominio.setId(cuenta.getId());
        
        System.out.println("Cuenta editada Dominio> BO >edtiar  " + cuentaAEditadaDominio.toString());
        System.out.println("Cuenta a editar Dominio> BO >editar>(cuentaActual)  " + cuentaActualDominio.toString());
        
        cuentaDAO.editarCuenta(cuentaAEditadaDominio, cuentaActualDominio);
    }
    
    

  
//    public ArrayList<CuentaDominio> consultarCuentas(){
//        return cuentaDAO.consultarCuentas();
//    }
}
