/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Vistas.singleton.IniciarSesion;
import Conexion.Conexion;
import Persona.Persona;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
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
public class IniciarSesionTest {
    
    public IniciarSesionTest() {
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
    public void testGetInstancia() {
        System.out.println("getInstancia");
        IniciarSesion result = IniciarSesion.getInstancia();
        IniciarSesion expResult=IniciarSesion.getInstancia();
        assertSame(expResult, result);
        
    }
    
    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        IniciarSesion expResult = IniciarSesion.getInstancia();
        
        Object result = expResult.clone();
        assertSame(expResult, result);
       }
 
    @Test
    public void testBuscarPersona() {
        System.out.println("buscarPersona");
        String usuario = "luis";
        String contraseña = "123";
        IniciarSesion instance = IniciarSesion.getInstancia();
        Persona result = instance.buscarPersona(usuario, contraseña);
//        assertEquals(expResult, result);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testTipoUsuarioExiste() {
        System.out.println("tipoUsuarioExiste");
        String usuario = "maria";
        String contraseña = "123";
        IniciarSesion instance = IniciarSesion.getInstancia();
        int expResult = 4;
        int result = instance.tipoUsuarioExiste(usuario, contraseña);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
    @Test
    public void testBorrarCampos() {
        System.out.println("borrarCampos");
        IniciarSesion instance = IniciarSesion.getInstancia();
        instance.borrarCampos();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("",instance.getTxtPasword());
    }
    
}
