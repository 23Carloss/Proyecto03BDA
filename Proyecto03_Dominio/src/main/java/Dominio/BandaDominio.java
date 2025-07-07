/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

import java.util.ArrayList;
import javax.swing.Icon;
import org.bson.types.ObjectId;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class BandaDominio {
    private ObjectId _id;
    private String nombreBanda, genero;
    private Icon portada;
    private ArrayList<ArtistaBandaDominio> listaIntegrantes;
    private ArrayList<AlbumDominio> listaAlbumes;

    public BandaDominio() {
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
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

    public ArrayList<ArtistaBandaDominio> getListaIntegrantes() {
        return listaIntegrantes;
    }

    public void setListaIntegrantes(ArrayList<ArtistaBandaDominio> listaIntegrantes) {
        this.listaIntegrantes = listaIntegrantes;
    }

    public ArrayList<AlbumDominio> getListaAlbumes() {
        return listaAlbumes;
    }

    public void setListaAlbumes(ArrayList<AlbumDominio> listaAlbumes) {
        this.listaAlbumes = listaAlbumes;
    }

    @Override
    public String toString() {
        return "BandaDominio{" + "_id=" + _id + ", nombreBanda=" + nombreBanda + ", genero=" + genero + ", portada=" + portada + ", listaIntegrantes=" + listaIntegrantes + ", listaAlbumes=" + listaAlbumes + '}';
    }
}
