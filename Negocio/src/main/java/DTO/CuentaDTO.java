/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTO;

import Dominio.AlbumDominio;
import java.util.ArrayList;
import javax.swing.Icon;
import org.bson.types.ObjectId;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CuentaDTO {
    private ObjectId _id;
    private String nombreU, correoE, contrasenha;
    private Icon imagenPerfil;
    private ArrayList<AlbumDominio> albumesFav;

    public CuentaDTO() {
    }

    public CuentaDTO(String nombreU, String correoE, String contrasenha, Icon imagenPerfil, ArrayList<AlbumDominio> albumesFav) {
        this.nombreU = nombreU;
        this.correoE = correoE;
        this.contrasenha = contrasenha;
        this.imagenPerfil = imagenPerfil;
        this.albumesFav = albumesFav;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }
    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public Icon getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(Icon imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public ArrayList<AlbumDominio> getAlbumesFav() {
        return albumesFav;
    }

    public void setAlbumesFav(ArrayList<AlbumDominio> albumesFav) {
        this.albumesFav = albumesFav;
    }

    @Override
    public String toString() {
        return "CuentaDTO{" + "_id=" + _id + ", nombreU=" + nombreU + ", correoE=" + correoE + ", contrasenha=" + contrasenha + ", imagenPerfil=" + imagenPerfil + ", albumesFav=" + albumesFav + '}';
    }
    
}
