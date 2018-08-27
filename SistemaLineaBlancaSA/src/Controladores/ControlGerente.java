/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Persona.Gerente;
import Vistas.singleton.IniciarSesion;
import Vistas.VistaGerente;
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
public class ControlGerente implements Controlador{

    private VistaGerente ventana;
    private Gerente gerente;
    private DefaultTableModel modeloDefault = new DefaultTableModel();
    private LinkedList<String[]> datos = new LinkedList();
    private DefaultTableModel modeloDefault1 = new DefaultTableModel();
    private LinkedList<String[]> datos1 = new LinkedList();
     private DefaultTableModel modeloDefault2 = new DefaultTableModel();
    private LinkedList<String[]> datos2 = new LinkedList();
    private DefaultTableModel modeloDefault3 = new DefaultTableModel();
    private LinkedList<String[]> datos3 = new LinkedList();
    
    
    public ControlGerente(Gerente gerente)  {
        ventana = new VistaGerente();
        this.gerente = gerente;
        this.gerente.setControl(this);
        this.ventana.jButton6.addActionListener(this);
        this.ventana.botonBuscar1.addActionListener(this);
        this.ventana.jButton3.addActionListener(this);
    }
    
    @Override
    public void presentarVista() {
        this.ventana.setVisible(true);
        initelements();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.ventana.jButton6==e.getSource()){
          DefaultTableModel modeloBusqueda = new DefaultTableModel();
            modeloBusqueda.addColumn("idUusario");
            modeloBusqueda.addColumn("Nombres");
            modeloBusqueda.addColumn("Apellidos");
            modeloBusqueda.addColumn("Cédula");
            modeloBusqueda.addColumn("Usuario");
            modeloBusqueda.addColumn("Tipo");
            for(String[] ob: datos1){
                boolean validacion = false;
                for(String str: ob){
                    if(str.toLowerCase().contains(this.ventana.jTextField5.getText().toLowerCase())) validacion = true;
                }
                if(validacion) modeloBusqueda.addRow(ob);
            }
            this.ventana.TablaUsuario1.setModel(modeloBusqueda);
        }if(this.ventana.botonBuscar1==e.getSource()){
            DefaultTableModel modeloBusqueda = new DefaultTableModel();
            modeloBusqueda.addColumn("idProducto");
            modeloBusqueda.addColumn("Nombre");
            modeloBusqueda.addColumn("Tipo");
            modeloBusqueda.addColumn("Marca");
            modeloBusqueda.addColumn("Precio");
            for(String[] ob: datos2){
                boolean validacion = false;
                for(String str: ob){
                    if(str.toLowerCase().contains(this.ventana.jTextField7.getText().toLowerCase())) validacion = true;
                }
                if(validacion) modeloBusqueda.addRow(ob);
            }
            ventana.TablaUsuario2.setModel(modeloBusqueda);
        }if(this.ventana.jButton3==e.getSource()){
            ventana.hide();
            IniciarSesion s=IniciarSesion.getInstancia();
            ventana.setVisible(false);
            s.setVisible(true);   
        }
    }
    
    void actualizarTablaUsuario1(){
        //JOptionPane.showMessageDialog(null, "Para eliminar un usuario tiene que ingresar sólo el id");
        modeloDefault1.addColumn("idUsuario");
        modeloDefault1.addColumn("Nombres");
        modeloDefault1.addColumn("Apellidos");
        modeloDefault1.addColumn("Cédula");
        modeloDefault1.addColumn("Usuario");
        modeloDefault1.addColumn("Tipo");
        try {
            Statement stm = IniciarSesion.getConection().getConnection().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Usuarios where eliminado = false");
            while (rs.next()) {
                int tipo = 0;
                String[] dato = new String[6];
                dato[0] = rs.getString("idUsuario");
                dato[1] = rs.getString("Nombres");
                dato[2] = rs.getString("Apellidos");
                dato[3] = rs.getString("Cedula");
                dato[4] = rs.getString("Usuario");
                tipo = rs.getInt("idTipo");
                Statement stm1 = IniciarSesion.getConection().getConnection().createStatement();
                ResultSet rs1 = stm1.executeQuery("SELECT nombre FROM TipoUsuario u WHERE u.idTipo="+tipo+";");
                while(rs1.next()){
                    String nombre = rs1.getString("Nombre");
                    dato[5] = nombre;
                }
                datos1.add(dato);
                modeloDefault1.addRow(dato);
            }
            this.ventana.TablaUsuario1.setModel(modeloDefault1);
        } catch (SQLException ex) {
            Logger.getLogger(VistaGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarTablaUsuario2(){
        modeloDefault2.addColumn("idProducto");
        modeloDefault2.addColumn("Nombre");
        modeloDefault2.addColumn("Tipo");
        modeloDefault2.addColumn("Marca");
        modeloDefault2.addColumn("Precio");
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
                datos2.add(dato);
                modeloDefault2.addRow(dato);
            }
            this.ventana.TablaUsuario2.setModel(modeloDefault2);
        } catch (SQLException ex) {
            Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void initelements(){
        actualizarTablaUsuario1();
        actualizarTablaUsuario2();
    }
}
