/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CancionDominio {
    private String nombre, duracion;

    public CancionDominio() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "CancionDominio{" + "nombre=" + nombre + ", duracion=" + duracion + '}';
    }
    
    
    
}
