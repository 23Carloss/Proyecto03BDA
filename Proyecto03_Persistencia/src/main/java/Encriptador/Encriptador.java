/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Encriptador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class Encriptador {

    public Encriptador(){
        
    }
    public String encriptarContrasenha(String contra){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(contra.getBytes("UTF-8"));
            StringBuilder contraEncriptada = new StringBuilder();
            for(byte b :hashBytes){
                String caracter = Integer.toHexString(0xff & b);
                if(caracter.length() == 1) contraEncriptada.append(0);
                contraEncriptada.append(caracter);
            }
            return contraEncriptada.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error al encriptar contrasenha");
        }
        
    }
}
