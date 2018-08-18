/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import Constantes.ConstantesTipoPersonal;
import Controladores.ControlVendedor;

/**
 *
 * @author san_t
 */
public class Vendedor extends Personal{
    
    
    
    public Vendedor() {
    }

//    public Vendedor(String identificacion, String nombres, String apellido, String usuario) {
//        super(identificacion, nombres, apellidos, usuario);
//        this.tipoPersonal = ConstantesTipoPersonal.VENDEDOR;
//        control = new ControlVendedor(this);
//    }
    public Vendedor(String identificacion, String nombres, String apellidos, String usuario) {
        super(identificacion, nombres, apellidos, usuario);
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
