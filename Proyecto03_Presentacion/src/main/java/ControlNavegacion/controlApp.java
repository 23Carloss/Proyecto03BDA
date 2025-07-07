/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ControlNavegacion;

import BO.CuentaBO;
import Paneles.Login;
import Paneles.Registrarse;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */

public class controlApp {
    private Login login;
    private Registrarse panelRegistro;
    private JFrame framePrincipal;
    
    //Objetos BO se ocupa la fabrica
    
    private CuentaBO cuentaBO;
    
    
    public controlApp(){
        
    }
    public void valoresDefault(){
//        cuentaBO = new CuentaBO(cuenta); ya q tengamos la fabrica
        framePrincipal = new JFrame();
        cambiarPanel(login);
        
    }
            
            
    public void mostrarRegistro(){
        panelRegistro = new Registrarse(this);
        cambiarPanel(panelRegistro);
    }
    public void mostrarMenuPrincipal(){
        
    }
    
    public void cambiarPanel(JPanel jpanel) {
        framePrincipal.getContentPane().removeAll();
        framePrincipal.setContentPane(jpanel);
        framePrincipal.repaint();
        framePrincipal.revalidate();
    }
    
    
    
}
