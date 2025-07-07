/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class ArtistaBandaDominio {
    private ObjectId _id;
    private String nombreArtista, rolEnBanda;
    private Date fechaIngreso, fechaSalida = null;
    private Boolean estado = true;

    public ArtistaBandaDominio() {
    }

    public ObjectId getId() {
        return _id;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
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
        return "ArtistaBandaDominio{" + "_id=" + _id + ", nombreArtista=" + nombreArtista + ", rolEnBanda=" + rolEnBanda + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", estado=" + estado + '}';
    }
    
}
