/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Conexion.Conexion;
import Vistas.singleton.IniciarSesion;

/** 
 *
 * @author Yoselin
 */
public class Sistema {
    
    private static Conexion contonyexion;
    private static IniciarSesion login;
    
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new IniciarSesion().setVisible(true);
                login = IniciarSesion.getInstancia();
                login.setVisible(true);
            }
        });
        
    }
}
