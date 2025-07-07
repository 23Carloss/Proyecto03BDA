/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTO;

import java.util.ArrayList;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class BandaDTO {
    private String nombreBanda, genero;
    private ArrayList<ArtistaBandaDTO> listaIntegrantes;
    private ArrayList<AlbumDTO> trackList;

    public BandaDTO() {
    }

    public BandaDTO(String nombreBanda, String genero, ArrayList<ArtistaBandaDTO> listaIntegrantes, ArrayList<AlbumDTO> trackList) {
        this.nombreBanda = nombreBanda;
        this.genero = genero;
        this.listaIntegrantes = listaIntegrantes;
        this.trackList = trackList;
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

    public ArrayList<ArtistaBandaDTO> getListaIntegrantes() {
        return listaIntegrantes;
    }

    public void setListaIntegrantes(ArrayList<ArtistaBandaDTO> listaIntegrantes) {
        this.listaIntegrantes = listaIntegrantes;
    }

    public ArrayList<AlbumDTO> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<AlbumDTO> trackList) {
        this.trackList = trackList;
    }

    @Override
    public String toString() {
        return "BandaDTO{" + "nombreBanda=" + nombreBanda + ", genero=" + genero + ", listaIntegrantes=" + listaIntegrantes + ", trackList=" + trackList + '}';
    }
    
}
