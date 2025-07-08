/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ControlNavegacion;

import DTO.CuentaDTO;
import Dominio.CuentaDominio;
import FrabicaBO.FabricaBO;
import Interfacez.ICuentaBO;
import Paneles.EditarPerfil;
import Paneles.Login;
import Paneles.MenuPrincipal;
import Paneles.Perfil;
import Paneles.Registrarse;
import Paneles.ResumenCambios;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */

public class controlApp {
    private Login login;
    private Registrarse panelRegistro;
    private MenuPrincipal menuPrincipal;
    private Perfil perfil;
    private EditarPerfil editarPerfil;
    private ResumenCambios resumenCambios;
    private JFrame framePrincipal;
    
    //Objetos BO se ocupa la fabrica
    private FabricaBO fabrica;
    private ICuentaBO cuentaBO;
    
    //DTO temporales
    private CuentaDTO cuentaTemporal;
    
    public controlApp(){
        
    }
    public void iniciar(){
        valoresDefault();
    }
    public void valoresDefault(){
//        cuentaBO = new CuentaBO(cuenta); ya q tengamos la fabrica
        framePrincipal = new JFrame("Biblioteca Musical#4");
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setSize(1050, 700);
        framePrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
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
    public void mostrarMenuPerfil(){
        perfil = new Perfil(this);
        cambiarPanel(perfil);
    }
    public void mostrarEditarPerfil(){
        editarPerfil = new EditarPerfil(this);
        cambiarPanel(editarPerfil);
    }
    public void mostrarConfirmarCambios(){
        resumenCambios = new ResumenCambios(this);
        cambiarPanel(resumenCambios);
        confirmarCambios();
    }
    
    public void confirmarCambios(){
        CuentaDominio cuentaEditada = new CuentaDominio();
        cuentaEditada.setNombreU(cuentaTemporal.getNombreU());
        cuentaEditada.setCorreoE(cuentaTemporal.getCorreoE());
        cuentaEditada.setContrasenha(cuentaTemporal.getContrasenha());
        cuentaBO.editarPerfil(cuentaEditada);
    }
    
    public void cambiarPanel(JPanel jpanel) {
        framePrincipal.getContentPane().removeAll();
        framePrincipal.setContentPane(jpanel);
        framePrincipal.repaint();
        framePrincipal.revalidate();
    }
    
    public void validarCredenciales(String correoE, String contra){
        CuentaDominio continuar = cuentaBO.IniciarSesion(correoE, contra);
        if(continuar != null){
            cuentaTemporal= new CuentaDTO();
            cuentaTemporal.setContrasenha(contra);
            cuentaTemporal.setCorreoE(continuar.getCorreoE());
            cuentaTemporal.setNombreU(continuar.getNombreU());
            mostrarMenuPrincipal();
        }    
    }
    public void obtenerCuentaRegistro(CuentaDTO cuenta){
        this.cuentaTemporal = cuenta;
        cuentaBO.registrarse(cuenta);
    }
    public CuentaDTO obtenerCuenta(){
        return cuentaTemporal;
        
    }
    
    
    
}
