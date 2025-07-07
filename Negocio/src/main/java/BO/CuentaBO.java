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
    public CuentaDominio registrarse(CuentaDTO cuenta){
        CuentaDominio cuentaRegistrar = new CuentaDominio();
        cuentaRegistrar.setContrasenha(cuenta.getContrasenha());
        
        cuentaRegistrar.setCorreoE(cuenta.getCorreoE());
        cuentaRegistrar.setNombreU(cuenta.getNombreU());
        cuentaRegistrar.setListaAlbumenFav(cuenta.getAlbumesFav());
        cuentaRegistrar.setImagenPerfil(cuenta.getImagenPerfil());
        Document cuentaAgregada = cuentaDAO.registrarse(cuentaRegistrar);
        System.out.println("Cuenta agregada que manda la dao:   "+ cuentaAgregada.toString());
        return cuentaRegistrar;
    }
    @Override
    public Boolean IniciarSesion(String correoE, String contra){
        return cuentaDAO.iniciarSesion(correoE, contra);
    }
    @Override
    public void editarPerfil(CuentaDominio cuenta){
        cuentaDAO.editarCuenta(cuenta);
    }
//    public ArrayList<CuentaDominio> consultarCuentas(){
//        return cuentaDAO.consultarCuentas();
//    }
}
