/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Personal.Administrador;
import Vistas.VistaAdministrador;
import java.awt.event.ActionEvent;

/**
 *
 * @author san_t
 */
public class ControlAdministrador implements Controlador{
    
    private VistaAdministrador ventana;
    private Administrador administrador;
    
    
    public ControlAdministrador(Administrador administrador)  {
        ventana = new VistaAdministrador();
        this.administrador = administrador;
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
