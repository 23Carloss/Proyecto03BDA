/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package FrabicaBO;

import BO.CuentaBO;
import DAO.CuentaDAO;
import static DAO.CuentaDAO.getInstanciaDAO;
import Interfaces.ICuentaDAO;
import Interfacez.ICuentaBO;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class FabricaBO {
    public static ICuentaBO CrearCuentaBO(){
        ICuentaDAO cuentaDAO = CuentaDAO.getInstanciaDAO();
        ICuentaBO cuentaBO = new CuentaBO(cuentaDAO);
        return cuentaBO;
        }
}
