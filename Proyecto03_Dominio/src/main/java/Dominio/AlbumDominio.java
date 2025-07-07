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
public class AlbumDominio {
    private ObjectId _id;
    private String nombre, genero;
    private Icon portada;
    private ArrayList<CancionDominio> trackList;

    public AlbumDominio() {
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Icon getPortada() {
        return portada;
    }

    public void setPortada(Icon portada) {
        this.portada = portada;
    }

    public ArrayList<CancionDominio> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<CancionDominio> trackList) {
        this.trackList = trackList;
    }

    @Override
    public String toString() {
        return "AlbumDominio{" + "_id=" + _id + ", nombre=" + nombre + ", genero=" + genero + ", portada=" + portada + ", trackList=" + trackList + '}';
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
        final AlbumDominio other = (AlbumDominio) obj;
        return Objects.equals(this._id, other._id);
    }
    
}
