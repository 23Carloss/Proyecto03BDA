/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

import javax.swing.Icon;
import org.bson.types.ObjectId;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class ArtistaSolitarioDominio {
    private ObjectId _id;
    private String nombre, genero;
    private Icon portada;

    public ArtistaSolitarioDominio() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
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

    @Override
    public String toString() {
        return "ArtistaSolitarioDominio{" + "_id=" + _id + ", nombre=" + nombre + ", genero=" + genero + ", portada=" + portada + '}';
    }
    
}
