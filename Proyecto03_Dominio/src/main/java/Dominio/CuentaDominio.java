/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

import java.util.ArrayList;
import java.util.Objects;
import javax.swing.Icon;
import org.bson.types.ObjectId;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CuentaDominio {
    private ObjectId _id;
    private String nombreUsuario, correoE, contrasenha;
    private Icon imagenPerfil;
    private ArrayList<AlbumDominio> listaAlbumenFav;

    public CuentaDominio() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }
    
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

    public ArrayList<AlbumDominio> getListaAlbumenFav() {
        return listaAlbumenFav;
    }

    public void setListaAlbumenFav(ArrayList<AlbumDominio> listaAlbumenFav) {
        this.listaAlbumenFav = listaAlbumenFav;
    }

    public Icon getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(Icon imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }
    
    @Override
    public String toString() {
        return "CuentaDominio{" + "_id=" + _id + ", nombreU=" + nombreUsuario + ", correoE=" + correoE + ", contrasenha=" + contrasenha + ", listaAlbumenFav=" + listaAlbumenFav + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.contrasenha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaDominio other = (CuentaDominio) obj;
        return Objects.equals(this._id, other._id);
    }
    
    
  
}
