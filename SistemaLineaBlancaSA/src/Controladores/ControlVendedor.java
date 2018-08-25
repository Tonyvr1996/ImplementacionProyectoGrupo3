/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Persona.Vendedor;
import Vistas.IniciarSesion;
import Vistas.VistaVendedor;
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
public class ControlVendedor implements Controlador{
    
    
    private VistaVendedor ventana;
    private Vendedor vendedor;
    private DefaultTableModel modeloDefault = new DefaultTableModel();
    private LinkedList<String[]> datos = new LinkedList();
    private DefaultTableModel modeloDefault1 = new DefaultTableModel();
    private LinkedList<String[]> datos1 = new LinkedList();
    
    public ControlVendedor(Vendedor vendedor)  {
        ventana = new VistaVendedor();
        this.vendedor = vendedor;
        this.vendedor.setControl(this);
        this.ventana.Editar.addActionListener(this);
        this.ventana.BotonEliminar.addActionListener(this);
        this.ventana.botonBuscar2.addActionListener(this);
        this.ventana.BotonGuardar.addActionListener(this);
        this.ventana.botonBuscar.addActionListener(this);
        this.ventana.jButton2.addActionListener(this);
    }

    @Override
    public void presentarVista() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.ventana.setVisible(true);
        initComponents();
        
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
                    if(str.toLowerCase().contains(ventana.jTextField5.getText().toLowerCase())) validacion = true;
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
                    if(str.toLowerCase().contains(ventana.jTextField6.getText().toLowerCase())) validacion = true;
                }
                if(validacion) modeloBusqueda.addRow(ob);
            }
            ventana.TablaUsuario1.setModel(modeloBusqueda);
        }
        if(ventana.BotonEliminar==e.getSource()){
            
            int id = Integer.parseInt(ventana.txtId.getText());
            if(estaVacio(ventana.txtId)){
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
                            //VistaAdministrador vs = new VistaAdministrador();
                          //actualizarTabla();
                          modeloDefault1.setRowCount(0);  
                          modeloDefault1.setColumnCount(0);
                          modeloDefault.setRowCount(0);
                          modeloDefault.setColumnCount(0);
                          datos.clear();
                          datos1.clear();
                          actualizarTablaDos();
                          actualizarTabla();                        
                            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                            //ventana.setVisible(false);
                            //vs.setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Ocurrió un error, vuelva a intentarlo");
                        }
                    }

                }catch (SQLException ex) {
                    Logger.getLogger(ControlVendedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(ventana.Editar==e.getSource()){
           String nombre = ventana.txtNombre.getText();
           float precio = Float.parseFloat(ventana.txtPrecio.getText());
           int id = Integer.parseInt(ventana.txtId.getText());
           int tipo = ventana.jComboBox1.getSelectedIndex()+1;
           int marca = ventana.jComboBox2.getSelectedIndex()+1;
           if(estaVacio(ventana.txtNombre) || estaVacio(ventana.txtPrecio) || estaVacio(ventana.txtId)){
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
                           VistaVendedor vs = new VistaVendedor();
                           JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                           ventana.setVisible(false);
                           vs.setVisible(true);
                       }
                       else{
                           JOptionPane.showMessageDialog(null, "Ocurrió un error, vuelva a intentarlo");
                       }
                   }

               }catch (SQLException ex) {
                   Logger.getLogger(ControlVendedor.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }
        if(ventana.BotonGuardar==e.getSource()){
            if(estaVacio(ventana.txtNombre1) || estaVacio(ventana.txtPrecio1)){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos. Ingrese todos los datos");
            }else{
                String nombre = ventana.txtNombre1.getText();
                int tipo = ventana.jComboBox1.getSelectedIndex()+1;
                int marca = ventana.jComboBox2.getSelectedIndex()+1;
                float precio = Float.parseFloat(ventana.txtPrecio1.getText());
                String query = "INSERT INTO Articulos(Nombremodelo,idTipoArticulo,idMarca,Precio) VALUES ('"+nombre+"',"+tipo+","+marca+","+precio+");";
                try{
                    PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query);
                    int n = ps.executeUpdate();
                    VistaVendedor ap = new VistaVendedor();
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
        if(ventana.jButton2==e.getSource()){
            ventana.hide();
            IniciarSesion s=IniciarSesion.getInstancia();
            ventana.setVisible(false);
            s.setVisible(true);
            
        }
    }
    
     public boolean estaVacio(JTextField campo){
        if(campo.getText().equals("")) 
            return true;
        return false;
    }
     
    public void actualizarTabla(){
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
            ventana.TablaUsuario.setModel(modeloDefault);
        } catch (SQLException ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
     
    public void actualizarTablaDos(){
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
            ventana.TablaUsuario1.setModel(modeloDefault1);
        } catch (SQLException ex) {
            Logger.getLogger(ControlVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void initComponents(){
        actualizarTablaDos();
        actualizarTabla();
//        modeloDefault.addColumn("idUsuario");
//        modeloDefault.addColumn("Nombres");
//        modeloDefault.addColumn("Apellidos");
//        modeloDefault.addColumn("Cédula");
//        modeloDefault.addColumn("Usuario");
//        modeloDefault.addColumn("Tipo");
//        try {
//            Statement stm = IniciarSesion.getConection().getConnection().createStatement();
//            ResultSet rs = stm.executeQuery("SELECT * FROM Usuarios");
//            while (rs.next()) {
//                int tipo = 0;
//                String[] dato = new String[6];
//                dato[0] = rs.getString("idUsuario");
//                dato[1] = rs.getString("Nombres");
//                dato[2] = rs.getString("Apellidos");
//                dato[3] = rs.getString("Cedula");
//                dato[4] = rs.getString("Usuario");
//                tipo = rs.getInt("idTipo");
//                Statement stm1 = IniciarSesion.getConection().getConnection().createStatement();
//                ResultSet rs1 = stm1.executeQuery("SELECT nombre FROM TipoUsuario u WHERE u.idTipo="+tipo+";");
//                while(rs1.next()){
//                    String nombre = rs1.getString("Nombre");
//                    dato[5] = nombre;
//                }
//                datos.add(dato);
//                modeloDefault.addRow(dato);
//            }
//            this.ventana.TablaUsuario.setModel(modeloDefault);
//        } catch (SQLException ex) {
////            Logger.getLogger(ConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
