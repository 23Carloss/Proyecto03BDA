/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import DAO.CuentaDAO;
import DTO.CuentaDTO;
import Dominio.CuentaDominio;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CuentaBO {
    private CuentaDAO cuentaDAO;
    
    public CuentaBO(CuentaDAO cuenta){
        this.cuentaDAO = cuenta;
    }
    
    public CuentaDominio registrarse(CuentaDTO cuenta){
        CuentaDominio cuentaRegistrar = new CuentaDominio();
        cuentaRegistrar.setContrasenha(cuenta.getContrasenha());
        cuentaRegistrar.setCorreoE(cuenta.getCorreoE());
        cuentaRegistrar.setNombreU(cuenta.getNombreU());
        cuentaRegistrar.setListaAlbumenFav(cuenta.getAlbumesFav());
        cuentaRegistrar.setImagenPerfil(cuenta.getImagenPerfil());
        cuentaDAO.registrarse(cuentaRegistrar);
        return cuentaRegistrar;
    }
}
