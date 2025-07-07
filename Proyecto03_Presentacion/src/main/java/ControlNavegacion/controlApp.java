/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ControlNavegacion;

import FrabicaBO.FabricaBO;
import Interfacez.ICuentaBO;
import Paneles.Login;
import Paneles.MenuPrincipal;
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
    private MenuPrincipal menuPrincipal;
    private JFrame framePrincipal;
    
    //Objetos BO se ocupa la fabrica
    private FabricaBO fabrica;
    private ICuentaBO cuentaBO;
    
    
    public controlApp(){
        
    }
    public void valoresDefault(){
//        cuentaBO = new CuentaBO(cuenta); ya q tengamos la fabrica
        framePrincipal = new JFrame("Biblioteca Musical#4");
        cuentaBO = fabrica.CrearCuentaBO();
        
        if(login == null){
            login = new Login(this);
            cambiarPanel(login);
            return;
        }
        cambiarPanel(login);
        
    }
            
            
    public void mostrarRegistro(){
        panelRegistro = new Registrarse(this);
        cambiarPanel(panelRegistro);
    }
    public void mostrarMenuPrincipal(){
        menuPrincipal = new MenuPrincipal(this);
        cambiarPanel(menuPrincipal);
    }
    
    public void cambiarPanel(JPanel jpanel) {
        framePrincipal.getContentPane().removeAll();
        framePrincipal.setContentPane(jpanel);
        framePrincipal.repaint();
        framePrincipal.revalidate();
    }
    
    public void validarCredenciales(String nombreU, String contra){
        Boolean continuar = cuentaBO.IniciarSesion(nombreU, contra);
        if(continuar){
            mostrarMenuPrincipal();
        }
        
        
    }
    
    
    
}
