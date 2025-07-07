/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTO;

import java.util.Date;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class ArtistaBandaDTO {
    private String nombre, rolEnBanda;
    private Date fechaIngreso, fechaSalida = null;
    private Boolean estado = true;

    public ArtistaBandaDTO(String nombre, String rolEnBanda, Date fechaIngreso) {
        this.nombre = nombre;
        this.rolEnBanda = rolEnBanda;
        this.fechaIngreso = fechaIngreso;
    }

    public ArtistaBandaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRolEnBanda() {
        return rolEnBanda;
    }

    public void setRolEnBanda(String rolEnBanda) {
        this.rolEnBanda = rolEnBanda;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ArtistaBandaDTO{" + "nombre=" + nombre + ", rolEnBanda=" + rolEnBanda + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", estado=" + estado + '}';
    }
    
}
