/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import Articulo.ArticuloFactory;
import Constantes.ConstantesTipoPersonal;
import Controladores.ControlGerente;

/**
 *
 * @author san_t
 */
public class Gerente extends Persona{
    private String usuario;
    private String contraseña;
    public Gerente(String identificacion, String nombres, String apellidos,String usuario, String contraseña) {
        super(identificacion, nombres, apellidos);
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.tipoPersonal = ConstantesTipoPersonal.GERENTE;
        control = new ControlGerente(this);
    }
    
    public void consultaVenta() {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultaCliente() {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultaCotizacion() {
        // TODO implement here
    }

    /**
     * @param Vendedor
     */
    public void generarReporteVendedor(Vendedor Vendedor) {
        // TODO implement here
    }

    /**
     * @param Articulo
     */
    public void generarReporteArticulo(ArticuloFactory Articulo) {
        // TODO implement here
    }

    /**
     * 
     */
    public void generarReporteClientes() {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultarReporte() {
        // TODO implement here
    }
    
}
