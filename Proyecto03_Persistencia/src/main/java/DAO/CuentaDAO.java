/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import Conexion.ConexionBaseDatos;
import Dominio.CuentaDominio;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CuentaDAO {
    
    private MongoDatabase bd;
    private MongoCollection<CuentaDominio> coleccionCuentas;
    
    public CuentaDAO(){
        bd = new ConexionBaseDatos().conexion();
        this.coleccionCuentas = bd.getCollection("Cuenta", CuentaDominio.class);
    }
    public void registrarse(CuentaDominio cuenta){
        System.out.println("Cuenta que llega a la DAO:  " + cuenta.toString());
        coleccionCuentas.insertOne(cuenta);
//        ArrayList<CuentaDominio> cuentas = coleccionCuentas.find();
        
    }
}
