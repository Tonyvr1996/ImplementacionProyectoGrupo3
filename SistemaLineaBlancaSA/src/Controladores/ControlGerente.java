/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Personal.Gerente;
import Vistas.VistaGerente;
import java.awt.event.ActionEvent;

/**
 *
 * @author san_t
 */
public class ControlGerente implements Controlador{

    private VistaGerente ventana;
    private Gerente gerente;
    
    
    public ControlGerente(Gerente gerente)  {
        ventana = new VistaGerente();
        this.gerente = gerente;
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
