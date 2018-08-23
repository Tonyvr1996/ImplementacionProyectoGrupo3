/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import Constantes.ConstantesTipoPersonal;
import Controladores.ControlVendedor;

/**
 *
 * @author san_t
 */
public class Vendedor extends Persona{
    
     private String usuario;
    private String contraseña;
    
    public Vendedor() {
    }


    public Vendedor(String identificacion, String nombres, String apellidos, String usuario,String contraseña) {
        super(identificacion, nombres, apellidos);
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.tipoPersonal = ConstantesTipoPersonal.VENDEDOR;
        control = new ControlVendedor(this);
    }

    public void agregarCliente() {
        // TODO implement here
    }

    /**
     * 
     */
    public void realizarVenta() {
        // TODO implement here
    }

    /**
     * 
     */
    public void realizarCotizacion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void solicitarPermisoEdicionVenta() {
        // TODO implement here
    }

    /**
     * 
     */
    public void solicitarPermisoEdicionFactura() {
        // TODO implement here
    }

    
}
