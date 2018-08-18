/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import Constantes.ConstantesTipoPersonal;
import Controladores.ControlSuperAdministrador;

/**
 *
 * @author san_t
 */
public class SuperAdministrador extends Personal{

    public SuperAdministrador(String identificacion, String nombres, String apellidos,  String usuario) {
        super(identificacion, nombres, apellidos,  usuario);
        this.tipoPersonal = ConstantesTipoPersonal.SUPERADMIN;
        control = new ControlSuperAdministrador(this);
    }
    
    public void consultaCliente() {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultaVenta() {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultarCotizacion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void agregarCliente() {
        // TODO implement here
    }

    /**
     * 
     */
    public void agregarVenta() {
        // TODO implement here
    }

    /**
     * 
     */
    public void eliminarCliente() {
        // TODO implement here
    }

    /**
     * 
     */
    public void agregarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void eliminarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void agregarCotizacion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void otorgarPermisoEdicionVenta() {
        // TODO implement here
    }

    /**
     * 
     */
    public void otorgarPersimoEdicionFactura() {
        // TODO implement here
    }
    
}
