/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTO;

import Dominio.AlbumDominio;
import java.util.ArrayList;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class ArtistaSolitarioDTO {
    private String nombre, genero;
    private ArrayList<AlbumDominio> listaAlbumes;

    public ArtistaSolitarioDTO() {
    }

    public ArtistaSolitarioDTO(String nombre, String genero, ArrayList<AlbumDominio> listaAlbumes) {
        this.nombre = nombre;
        this.genero = genero;
        this.listaAlbumes = listaAlbumes;
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

    public ArrayList<AlbumDominio> getListaAlbumes() {
        return listaAlbumes;
    }

    public void setListaAlbumes(ArrayList<AlbumDominio> listaAlbumes) {
        this.listaAlbumes = listaAlbumes;
    }

    @Override
    public String toString() {
        return "ArtistaDTO{" + "nombre=" + nombre + ", genero=" + genero + ", listaAlbumes=" + listaAlbumes + '}';
    }
    
}
