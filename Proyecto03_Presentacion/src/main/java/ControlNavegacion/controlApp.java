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
    private CuentaDTO cuentaTemporalEditar;
    
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
            
            
    public void mostrarLogin(){
        login = new Login(this);
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
    }
    
    public void confirmarCambios(CuentaDTO cuentaEditada){
        cuentaEditada.setNombreU(cuentaTemporalEditar.getNombreU());
        cuentaEditada.setCorreoE(cuentaTemporalEditar.getCorreoE());
        cuentaEditada.setContrasenha(cuentaTemporalEditar.getContrasenha());
        cuentaEditada.setId(cuentaTemporalEditar.getId());
//        System.out.println("Control>confirmarCambios> cuentaEditada(Parametro)> "+ cuentaEditada.toString());
//        System.out.println("Control>confirmarCambios> obtenerCuentaEditada(Metodo regeresa cuentaDTO)> "+  obtenerCuentaEditada().toString());
        cuentaBO.editarPerfil(cuentaTemporal,cuentaEditada);
        cuentaTemporal = cuentaTemporalEditar;
        mostrarMenuPerfil();
    }
    
    public void cambiarPanel(JPanel jpanel) {
        framePrincipal.getContentPane().removeAll();
        framePrincipal.setContentPane(jpanel);
        framePrincipal.repaint();
        framePrincipal.revalidate();
    }
    
    public void validarCredenciales(){
        CuentaDTO continuar = cuentaBO.IniciarSesion(cuentaTemporal.getCorreoE(), cuentaTemporal.getContrasenha());
        System.out.println("Cuenta q llega a presentacion>InicioSesion  " + continuar.toString());
        if(continuar != null){
            cuentaTemporal= continuar;
            cuentaTemporal.setContrasenha(cuentaTemporal.getContrasenha());//dto sin ecnriptaar
            cuentaTemporal.setCorreoE(continuar.getCorreoE());
            cuentaTemporal.setNombreU(continuar.getNombreU());
            cuentaTemporal.setId(continuar.getId());
            setCuenta(continuar);
            mostrarMenuPrincipal();
        }    
    }
    public void setCuentaRegistro(CuentaDTO cuenta){
        this.cuentaTemporal = cuenta;
        cuentaBO.registrarse(cuenta);
    }
    public CuentaDTO obtenerCuenta(){
        return cuentaTemporal; 
    }
    public CuentaDTO obtenerCuentaEditada(){
        if(cuentaTemporalEditar!=null){
            return cuentaTemporalEditar;
        }
        return cuentaTemporalEditar = new CuentaDTO();
         //nueva cuenta para ver si quiere guardar los cambios
    }
    public void setCuenta(CuentaDTO cuenta){
       this.cuentaTemporal = cuenta; 
    }
    public void setCuentaAEditar(CuentaDTO cuenta){
       this.cuentaTemporalEditar = cuenta; 
    }
    
    
    
}
