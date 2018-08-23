/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Persona.Vendedor;
import Vistas.VistaVendedor;
import java.awt.event.ActionEvent;

/**
 *
 * @author san_t
 */
public class ControlVendedor implements Controlador{
    
    
    private VistaVendedor ventana;
    private Vendedor vendedor;
    
    
    public ControlVendedor(Vendedor vendedor)  {
        ventana = new VistaVendedor();
        this.vendedor = vendedor;
    }

    @Override
    public void presentarVista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
