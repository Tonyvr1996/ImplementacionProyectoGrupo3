/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Persona.Administrador;
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
public class ControlAdministradorTest {
    
    public ControlAdministradorTest() {
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
    public void testGuardarArtículo() {
        System.out.println("guardarArt\u00edculo");
        ControlAdministrador instance = new ControlAdministrador(new Administrador("","","","",""));
        boolean result = instance.guardarArtículo();
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testEstaLlena() {
        System.out.println("estaLlena");
        ControlAdministrador instance = new ControlAdministrador(new Administrador("","","","",""));
        int expResult = 0;
        int result = instance.estaLlena();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testBuscarArticulo() {
        System.out.println("buscarArticulo");
        ControlAdministrador instance = new ControlAdministrador(new Administrador("","","","",""));        boolean expResult = false;
        boolean result = instance.buscarArticulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
