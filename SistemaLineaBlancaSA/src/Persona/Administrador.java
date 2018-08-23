/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import Constantes.ConstantesTipoPersonal;
import Controladores.ControlAdministrador;

/**
 *
 * @author Usuario
 */
public class Administrador extends Persona{
    private String usuario;
    private String contraseña;
    
    public Administrador(String identificacion, String nombres, String apellidos,  String usuario,String contraseña) {
        super(identificacion, nombres, apellidos);
        this.usuario =usuario;
        this.contraseña = contraseña;
        this.tipoPersonal = ConstantesTipoPersonal.ADMINISTRADOR;
        control = new ControlAdministrador(this);
    }
    
    public void consultaCliente() {
        // TODO implement here
    }

    public void consultaVenta() {
        // TODO implement here
    }

    public void consultarCotizacion() {
        // TODO implement here
    }

    public void agregarCliente() {
        // TODO implement here
    }

    public void AgregarVenta() {
        // TODO implement here
    }

    public void eliminarCliente() {
        // TODO implement here
    }

    public void eliminarVenta() {
        // TODO implement here
    }

    public void agregarCotizacion() {
        // TODO implement here
    }
    
}
