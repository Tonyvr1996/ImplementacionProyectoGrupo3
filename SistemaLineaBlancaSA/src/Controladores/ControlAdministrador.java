/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Persona.Administrador;
import Vistas.IniciarSesion;
import Vistas.VistaAdministrador;
import static Vistas.VistaAdministrador.TablaUsuario;
import static Vistas.VistaAdministrador.jTextField5;
import static Vistas.VistaAdministrador.jTextField6;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author san_t
 */
public class ControlAdministrador implements Controlador{
    
    private VistaAdministrador ventana;
    private Administrador administrador;
    private DefaultTableModel modeloDefault = new DefaultTableModel();
    private LinkedList<String[]> datos = new LinkedList();
    
    public ControlAdministrador(Administrador administrador)  {
        ventana = new VistaAdministrador();
        this.administrador = administrador;
        this.administrador.setControl(this);
        this.ventana.BotonGuardar.addActionListener(this);
        this.ventana.BotonEliminar.addActionListener(this);
        this.ventana.botonBuscar.addActionListener(this);
        this.ventana.botonBuscar2.addActionListener(this);
     
    }
    
    @Override
    public void presentarVista() {
        this.ventana.setVisible(true);
        initelements();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(ventana.botonBuscar==e.getSource()){
            DefaultTableModel modeloBusqueda = new DefaultTableModel();
            modeloBusqueda.addColumn("idProducto");
            modeloBusqueda.addColumn("Nombre");
            modeloBusqueda.addColumn("Tipo");
            modeloBusqueda.addColumn("Marca");
            modeloBusqueda.addColumn("Precio");
            for(String[] ob: datos){
                boolean validacion = false;
                for(String str: ob){
                    if(str.toLowerCase().contains(jTextField5.getText().toLowerCase())) validacion = true;
                }
                if(validacion) modeloBusqueda.addRow(ob);
            }
            ventana.TablaUsuario.setModel(modeloBusqueda);
        }
        if(ventana.botonBuscar2==e.getSource()){
           
            DefaultTableModel modeloBusqueda = new DefaultTableModel();
            modeloBusqueda.addColumn("idProducto");
            modeloBusqueda.addColumn("Nombre");
            modeloBusqueda.addColumn("Tipo");
            modeloBusqueda.addColumn("Marca");
            modeloBusqueda.addColumn("Precio");
            for(String[] ob: datos){
                boolean validacion = false;
                for(String str: ob){
                    if(str.toLowerCase().contains(jTextField6.getText().toLowerCase())) validacion = true;
                }
                if(validacion) modeloBusqueda.addRow(ob);
            }
            ventana.TablaUsuario.setModel(modeloBusqueda);
        }
    }
    
    void initelements(){
        
       
        
        modeloDefault.addColumn("idProducto");
        modeloDefault.addColumn("Nombre");
        modeloDefault.addColumn("Tipo");
        modeloDefault.addColumn("Marca");
        modeloDefault.addColumn("Precio");
        try {
            Statement stm = IniciarSesion.getConection().getConnection().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Articulos a WHERE eliminado = false");
            while (rs.next()) {
                int tipo;
                int marca;
                String[] dato = new String[5];
                dato[0] = rs.getString("idArticulo");
                dato[1] = rs.getString("NombreModelo");
                dato[4] = String.valueOf(rs.getFloat("Precio"));
                tipo = rs.getInt("idTipoArticulo");
                marca = rs.getInt("idMarca");
                Statement stm1 = IniciarSesion.getConection().getConnection().createStatement();
                ResultSet rs1 = stm1.executeQuery("SELECT nombre FROM TipoArticulo u WHERE u.idTipoArt="+tipo+";");
                while(rs1.next()){
                    String nombre = rs1.getString("Nombre");
                    dato[2] = nombre;
                }
                Statement stm2 = IniciarSesion.getConection().getConnection().createStatement();
                ResultSet rs2 = stm2.executeQuery("SELECT nombre FROM Marcas u WHERE u.idMarca="+marca+";");
                while(rs2.next()){
                    String nombre = rs2.getString("Nombre");
                    dato[3] = nombre;
                }
                datos.add(dato);
                modeloDefault.addRow(dato);
            }
            TablaUsuario.setModel(modeloDefault);
        } catch (SQLException ex) {
            Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
