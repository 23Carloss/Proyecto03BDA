/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfacez;

import DTO.CuentaDTO;
import Dominio.CuentaDominio;

/**
 *
 * @author HP
 */
public interface ICuentaBO {
    public CuentaDTO registrarse(CuentaDTO cuenta);
    public CuentaDTO IniciarSesion(String nombreU, String contra);
    public void editarPerfil(CuentaDTO cuentaCambios, CuentaDTO cuentaAEditar);
    
}
