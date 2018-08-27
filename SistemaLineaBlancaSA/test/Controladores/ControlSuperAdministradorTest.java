/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.VistaSuperadministrador;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yoselin
 */
public class ControlSuperAdministradorTest {
    
    public ControlSuperAdministradorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testEstaVacio() {
        System.out.println("estaVacio");
        VistaSuperadministrador instance=new VistaSuperadministrador();
        JTextField campo = new JTextField();
        campo.setText("");
        //String campo=JtextField.getText();
        //ControlSuperAdministrador instance = null;
        boolean expResult = true;
        boolean result = instance.estaVacio(campo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
