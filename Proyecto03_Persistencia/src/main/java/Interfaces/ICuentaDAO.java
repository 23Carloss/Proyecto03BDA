/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Dominio.AlbumDominio;
import Dominio.CuentaDominio;
import org.bson.Document;

/**
 *
 * @author HP
 */
public interface ICuentaDAO {
    public CuentaDominio iniciarSesion(String nombreU, String contra);
    public CuentaDominio registrarse(CuentaDominio cuenta);
    public void editarCuenta(CuentaDominio cambios,CuentaDominio cuentaAEditar);
    public void agregarAlbumFavoritos(CuentaDominio cuenta, AlbumDominio album);
    public CuentaDominio obtenerCuenta(String correoE);
}
