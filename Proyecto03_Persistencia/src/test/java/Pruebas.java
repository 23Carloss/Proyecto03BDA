
import DAO.CuentaDAO;
import Dominio.CuentaDominio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author HP
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CuentaDominio cuenta= new CuentaDominio();
        CuentaDAO dao = new CuentaDAO();
        
        cuenta.setContrasenha("1234567890");
        cuenta.setCorreoE("luis12@gmail.com");
        cuenta.setNombreU("Luis12");
        
        dao.registrarse(cuenta);
        
    }
    
}
