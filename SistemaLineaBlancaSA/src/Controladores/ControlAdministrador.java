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
import static Vistas.VistaAdministrador.TablaUsuario1;
import static Vistas.VistaAdministrador.jComboBox1;
import static Vistas.VistaAdministrador.jComboBox2;
import static Vistas.VistaAdministrador.jTextField5;
import static Vistas.VistaAdministrador.jTextField6;
import static Vistas.VistaAdministrador.txtId;
import static Vistas.VistaAdministrador.txtNombre;
import static Vistas.VistaAdministrador.txtNombre1;
import static Vistas.VistaAdministrador.txtPrecio;
import static Vistas.VistaAdministrador.txtPrecio1;
import Vistas.VistaSuperadministrador;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
    private DefaultTableModel modeloDefault1 = new DefaultTableModel();
    private LinkedList<String[]> datos1 = new LinkedList();
    
    public ControlAdministrador(Administrador administrador)  {
        ventana = new VistaAdministrador();
        this.administrador = administrador;
        this.administrador.setControl(this);
        this.ventana.BotonGuardar.addActionListener(this);
        this.ventana.BotonEliminar.addActionListener(this);
        this.ventana.botonBuscar.addActionListener(this);
        this.ventana.botonBuscar2.addActionListener(this);
        this.ventana.Editar.addActionListener(this);
     
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
            ventana.TablaUsuario1.setModel(modeloBusqueda);
        }
        if(ventana.BotonEliminar==e.getSource()){
            
            int id = Integer.parseInt(txtId.getText());
            if(estaVacio(txtId)){
                JOptionPane.showMessageDialog(null, "No ha ingresado el id. Introduzca el dato");
            }
            else{
                String query1 = "SELECT idArticulo FROM Articulos a WHERE a.idArticulo="+id+";";
                try{
                    Statement stm = IniciarSesion.getConection().getConnection().createStatement();
                    ResultSet rs = stm.executeQuery(query1);
                    String idusuario;
                    while(rs.next()){
                        int idart = rs.getInt("idArticulo");
                        String query2 = "UPDATE Articulos SET eliminado = true WHERE idArticulo="+idart+";";
                        PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query2);
                        int n = ps.executeUpdate();
                        if(n > 0){
                            VistaAdministrador vs = new VistaAdministrador();
                            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                            ventana.setVisible(false);
                            vs.setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Ocurrió un error, vuelva a intentarlo");
                        }
                    }

                }catch (SQLException ex) {
                    Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(ventana.Editar==e.getSource()){
           String nombre = txtNombre.getText();
           float precio = Float.parseFloat(txtPrecio.getText());
           int id = Integer.parseInt(txtId.getText());
           int tipo = jComboBox1.getSelectedIndex()+1;
           int marca = jComboBox2.getSelectedIndex()+1;
           if(estaVacio(txtNombre) || estaVacio(txtPrecio) || estaVacio(txtId)){
               JOptionPane.showMessageDialog(null, "Existen campos vacios, por favor llenar todos los campos");
           }else {
               String query1 = "SELECT idArticulo FROM Articulos a WHERE a.idArticulo="+id+";";
               try{
                   Statement stm = IniciarSesion.getConection().getConnection().createStatement();
                   ResultSet rs = stm.executeQuery(query1);
                   String idusuario;
                   while(rs.next()){
                       int idart = rs.getInt("idArticulo");
                       String query2 = "UPDATE Articulos SET NombreModelo = ? , idTipoArticulo = ? , idMarca = ? , Precio = ? WHERE idArticulo="+idart+";";
                       PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query2);
                       ps.setString(1,nombre);
                       ps.setInt(2,tipo);
                       ps.setInt(3,marca);
                       ps.setFloat(4,precio);
                       int n = ps.executeUpdate();
                       if(n > 0){
                           VistaSuperadministrador vs = new VistaSuperadministrador();
                           JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                           ventana.setVisible(false);
                           vs.setVisible(true);
                       }
                       else{
                           JOptionPane.showMessageDialog(null, "Ocurrió un error, vuelva a intentarlo");
                       }
                   }

               }catch (SQLException ex) {
                   Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }
        if(ventana.BotonGuardar==e.getSource()){
            if(estaVacio(txtNombre1) || estaVacio(txtPrecio1)){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos. Ingrese todos los datos");
            }else{
                String nombre = txtNombre1.getText();
                int tipo = jComboBox1.getSelectedIndex()+1;
                int marca = jComboBox2.getSelectedIndex()+1;
                float precio = Float.parseFloat(txtPrecio1.getText());
                String query = "INSERT INTO Articulos(Nombremodelo,idTipoArticulo,idMarca,Precio) VALUES ('"+nombre+"',"+tipo+","+marca+","+precio+");";
                try{
                    PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query);
                    int n = ps.executeUpdate();
                    VistaAdministrador ap = new VistaAdministrador();
                    if(n>0){
                        JOptionPane.showMessageDialog(null,"Producto ingresado correctamente");
                        ventana.setVisible(false);
                        ap.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Ocurrió un error, ingrese nuevamente los datos");
                    }
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Ocurrió un error, ingrese nuevamente los datos");
                }
            }
        }
    }
      public boolean estaVacio(JTextField campo){
        if(campo.getText().equals("")) 
            return true;
        return false;
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
        
        modeloDefault1.addColumn("idProducto");
        modeloDefault1.addColumn("Nombre");
        modeloDefault1.addColumn("Tipo");
        modeloDefault1.addColumn("Marca");
        modeloDefault1.addColumn("Precio");
        try {
            Statement stm = IniciarSesion.getConection().getConnection().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Articulos WHERE eliminado = false");
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
                datos1.add(dato);
                modeloDefault1.addRow(dato);
            }
            TablaUsuario1.setModel(modeloDefault1);
        } catch (SQLException ex) {
            Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
