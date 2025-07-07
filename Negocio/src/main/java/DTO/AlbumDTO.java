/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTO;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AlbumDTO {
    private String nombre, genero;
    private Date fechaLanzamiento;
    private ArrayList<CancionDTO> trackList;

    public AlbumDTO() {
    }

    public AlbumDTO(String nombre, String genero, Date fechaLanzamiento, ArrayList<CancionDTO> trackList) {
        this.nombre = nombre;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.trackList = trackList;
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

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public ArrayList<CancionDTO> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<CancionDTO> trackList) {
        this.trackList = trackList;
    }

    @Override
    public String toString() {
        return "AlbumDTO{" + "nombre=" + nombre + ", genero=" + genero + ", fechaLanzamiento=" + fechaLanzamiento + ", trackList=" + trackList + '}';
    }
    
    
}
