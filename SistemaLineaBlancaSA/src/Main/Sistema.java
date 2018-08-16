/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Vistas.IniciarSesion;

/**
 *
 * @author Yoselin
 */
public class Sistema {
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new IniciarSesion().setVisible(true);
                IniciarSesion login=new IniciarSesion();
                login.setVisible(true);
            }
        });
    }
}
