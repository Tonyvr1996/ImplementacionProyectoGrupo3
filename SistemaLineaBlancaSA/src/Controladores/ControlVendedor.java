/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Persona.Vendedor;
import Vistas.singleton.IniciarSesion;
import Vistas.VistaVendedor;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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
//        this.ventana.Editar.addActionListener(this);
        this.ventana.BotonEliminar.addActionListener(this);
//        this.ventana.botonBuscar2.addActionListener(this);
        this.ventana.BotonGuardar.addActionListener(this);
        this.ventana.BotonModificar.addActionListener(this);
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
        if(ventana.jButton6 == e.getSource()){
            DefaultTableModel modeloBusqueda = new DefaultTableModel();
            modeloBusqueda.addColumn("idCliente");
            modeloBusqueda.addColumn("Nombre");
            modeloBusqueda.addColumn("Direccion");
            modeloBusqueda.addColumn("Tipo");
            modeloBusqueda.addColumn("Identificacion");
            for(String[] ob: datos1){
                boolean validacion = false;
                for(String str: ob){
                    if(str.toLowerCase().contains(ventana.jTextField7.getText().toLowerCase())) validacion = true;
                }
                if(validacion) modeloBusqueda.addRow(ob);
            }
            ventana.TablaUsuario1.setModel(modeloBusqueda);
        }
        if(ventana.jButton2==e.getSource()){
            ventana.hide();
            IniciarSesion s=IniciarSesion.getInstancia();
            ventana.setVisible(false);
            s.setVisible(true);  
        }
        if(ventana.BotonGuardar == e.getSource()){
            if(estaVacio(this.ventana.TextoNombre) || estaVacio(this.ventana.TextoApellido) || estaVacio(this.ventana.TextoDireccion) || estaVacio(this.ventana.TextoCedula)){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos. Ingrese todos los datos");
            }else{
                String nombre = this.ventana.TextoNombre.getText() + " " + this.ventana.TextoApellido.getText();
                String id = this.ventana.TextoCedula.getText();
                int idCliente = 0 ;
                String direccion = this.ventana.TextoDireccion.getText();
                int tipo = this.ventana.jComboBox6.getSelectedIndex()+1;
                String query = "INSERT INTO Clientes(Nombre,direccion) VALUES ('"+nombre+"','"+direccion+"');";
                try{
                    PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query);
                    int n = ps.executeUpdate();
                    VistaVendedor vv = new VistaVendedor();
                    if(n>0){
                        String query2 = "SELECT * FROM Clientes c WHERE nombre='"+nombre+"';";
                            try{
                                Statement stm = IniciarSesion.getConection().getConnection().createStatement();
                                ResultSet rs = stm.executeQuery(query2);
                                while(rs.next()){
                                    idCliente = rs.getInt("idCliente");
                                }
                            }catch(SQLException ex){
                                JOptionPane.showMessageDialog(null,"Ocurrió un error, ingrese nuevamente los datos");
                            }
                        if(tipo == 1){
                            String query1 = "INSERT INTO ClientePersona(idClientePersona,idCliente) VALUES ('"+id+"',"+idCliente+");";
                            try{
                                PreparedStatement ps1 = IniciarSesion.getConection().getConnection().prepareStatement(query);
                                ps1.executeUpdate();
                            }catch(SQLException ex){
                                JOptionPane.showMessageDialog(null,"Ocurrió un error, ingrese nuevamente los datos");
                            }
                        }
                        else if (tipo == 2){
                            String query1 = "INSERT INTO ClienteEmpresa(idClienteEmpresa,idCliente) VALUES ('"+id+"',"+idCliente+");";
                            try{
                                PreparedStatement ps1 = IniciarSesion.getConection().getConnection().prepareStatement(query);
                                ps1.executeUpdate();
                            }catch(SQLException ex){
                                JOptionPane.showMessageDialog(null,"Ocurrió un error, ingrese nuevamente los datos");
                            }
                        }
                        JOptionPane.showMessageDialog(null,"Cliente ingresado correctamente");
                        Date date = new Date();
                        String q = "INSERT INTO LogCliente(idCliente,fecha,hora) VALUES("+idCliente+",'"+date.getYear()+"-"+date.getMonth()+"-"+date.getDay()+"','"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+"');";
                        try{
                            PreparedStatement ps5 = IniciarSesion.getConection().getConnection().prepareStatement(q);
                            ps5.executeUpdate();
                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(null,"Ocurrió un error, ingrese nuevamente los datos");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Ocurrió un error, ingrese nuevamente los datos");
                    }
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Ocurrió un error, ingrese nuevamente los datos");
                }
        }
        
        if(ventana.BotonModificar == e.getSource()){
            String id = this.ventana.TextoCedula.getText();
            String nombre = this.ventana.TextoNombre.getText();
            String apellido = this.ventana.TextoApellido.getText();
            String direccion = this.ventana.TextoDireccion.getText();
            int tipo = this.ventana.jComboBox6.getSelectedIndex() + 1;
            int idCliente = 0;
            if(estaVacio(this.ventana.TextoCedula)){
                JOptionPane.showMessageDialog(null, "No ha ingresado el id. Introduzca el dato");
            }else {
                if(tipo == 1){
                    String query1 = "SELECT * FROM ClientePersona cp WHERE cp.idClientePersona='"+id+"';";
                    try{
                        Statement stm = IniciarSesion.getConection().getConnection().createStatement();
                        ResultSet rs = stm.executeQuery(query1);
                        while(rs.next()){
                            idCliente = rs.getInt("idCliente");
                        }
                    }catch (SQLException ex) {
                    Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    String query1 = "SELECT * FROM ClienteEmpresa ce WHERE ce.idClienteEmpresa='"+id+"';";
                    try{
                        Statement stm = IniciarSesion.getConection().getConnection().createStatement();
                        ResultSet rs = stm.executeQuery(query1);
                        while(rs.next()){
                            idCliente = rs.getInt("idCliente");
                        }
                    }catch (SQLException ex) {
                    Logger.getLogger(ControlVendedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(idCliente == 0){
                    JOptionPane.showMessageDialog(null, "El cliente no existe en la base de datos");
                }
                else{
                    String query2 = "UPDATE Clientes SET nombre='"+nombre+" "+apellido+"' AND direccion='"+direccion+"' WHERE idCliente="+idCliente+";";
                    try{
                       PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query2);
                        int n = ps.executeUpdate(); 
                        JOptionPane.showMessageDialog(null, "El cliente se ha editado correctamente");
                    }catch (SQLException ex) {
                    Logger.getLogger(ControlVendedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        if(ventana.BotonEliminar == e.getSource()){
            String id = this.ventana.TextoCedula.getText();
            int tipo = this.ventana.jComboBox6.getSelectedIndex() + 1;
            int idCliente = 0;
            if(estaVacio(this.ventana.TextoCedula)){
                JOptionPane.showMessageDialog(null, "No ha ingresado el id. Introduzca el dato");
            }else {
                if(tipo == 1){
                    String query1 = "SELECT * FROM ClientePersona cp WHERE cp.idClientePersona='"+id+"';";
                    try{
                        Statement stm = IniciarSesion.getConection().getConnection().createStatement();
                        ResultSet rs = stm.executeQuery(query1);
                        while(rs.next()){
                            idCliente = rs.getInt("idCliente");
                        }
                    }catch (SQLException ex) {
                    Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    String query1 = "SELECT * FROM ClienteEmpresa ce WHERE ce.idClienteEmpresa='"+id+"';";
                    try{
                        Statement stm = IniciarSesion.getConection().getConnection().createStatement();
                        ResultSet rs = stm.executeQuery(query1);
                        while(rs.next()){
                            idCliente = rs.getInt("idCliente");
                        }
                    }catch (SQLException ex) {
                    Logger.getLogger(ControlVendedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(idCliente == 0){
                    JOptionPane.showMessageDialog(null, "El cliente no existe en la base de datos");
                }
                else{
                    String query2 = "UPDATE Clientes SET eliminado = true WHERE idCliente="+idCliente+";";
                    try{
                       PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query2);
                        int n = ps.executeUpdate(); 
                        JOptionPane.showMessageDialog(null, "El cliente se ha eliminado correctamente");
                    }catch (SQLException ex) {
                    Logger.getLogger(ControlVendedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        if(ventana.AgregarProducto == e.getSource()){
            if(estaVacio(this.ventana.jTextField1) || estaVacio(this.ventana.jTextField3) || estaVacio(this.ventana.jTextField4) || estaVacio(this.ventana.jTextField9) || estaVacio(this.ventana.jTextField2)){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos. Ingrese todos los datos");
            }else{
                VistaVendedor ap = new VistaVendedor();
                int idVenta = 0;
                String nombre = this.ventana.jTextField1.getText() + " " + this.ventana.jTextField2.getText();
                String identificacion = this.ventana.jTextField3.getText();
                String direccion = this.ventana.jTextField4.getText();
                int cantidad = this.ventana.jComboBox5.getSelectedIndex() + 1;
                int idCliente = 0;
                int articulo = this.ventana.jComboBox4.getSelectedIndex() + 1;
                int tipoPago = this.ventana.jComboBox1.getSelectedIndex() + 1;
                int tipoCliente = this.ventana.jComboBox7.getSelectedIndex() + 1; 
                System.out.println(tipoCliente);
                if(tipoCliente == 1){
                    String query1 = "SELECT * FROM ClientePersona cp WHERE cp.idClientePersona='"+identificacion+"';";
                    try{
                        Statement stm1 = IniciarSesion.getConection().getConnection().createStatement();
                        ResultSet rs1 = stm1.executeQuery(query1);
                        System.out.println(tipoCliente);
                        while(rs1.next()){
                            idCliente = rs1.getInt("idCliente");
                            System.out.println(idCliente);
                        }
                    }catch (SQLException ex) {
                    Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    String query1 = "SELECT * FROM ClienteEmpresa ce WHERE ce.idClienteEmpresa='"+identificacion+"';";
                    try{
                        Statement stm1 = IniciarSesion.getConection().getConnection().createStatement();
                        ResultSet rs1 = stm1.executeQuery(query1);
                        while(rs1.next()){
                            idCliente = rs1.getInt("idCliente");
                        }
                    }catch (SQLException ex) {
                    Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(idCliente == 0){
                    JOptionPane.showMessageDialog(null, "El cliente que ha ingresado no existe"); 
                }
                else{
                    Date fecha = new Date();
                    int dia = fecha.getDay();
                    int mes = fecha.getMonth();
                    int anio = fecha.getYear();
                   String query = "INSERT INTO Ventas(idCliente,idTipoPago,fecha) VALUES ("+idCliente+",'"+tipoPago+","+anio+"-"+mes+"-"+dia+"');";
                    try{
                        PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query);
                        int n = ps.executeUpdate();
                    }catch (SQLException ex) {
                    Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    String query4 = "SELECT * FROM Ventas v WHERE v.idCliente="+idCliente+" AND idTipoPago="+tipoPago+" AND fecha='"+anio+"-"+mes+"-"+dia+"';";
                    try{
                        Statement stm1 = IniciarSesion.getConection().getConnection().createStatement();
                        ResultSet rs1 = stm1.executeQuery(query4);
                        while(rs1.next()){
                            idVenta = rs1.getInt("idVenta");
                        }
                    }catch (SQLException ex) {
                        Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    float precio = 0;
                    String query3 = "SELECT * FROM Articulos a WHERE a.idArticulo="+articulo+";";
                    try{
                        Statement stm4 = IniciarSesion.getConection().getConnection().createStatement();
                        ResultSet rs4 = stm4.executeQuery(query3);
                        while(rs4.next()){
                            precio = rs4.getFloat("precio");
                        }
                    }catch (SQLException ex) {
                        Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String query2 = "INSERT INTO DescripcionVenta(idVenta,idArticulo,Cantidad,Total) VALUES ("+idVenta+","+articulo+","+cantidad+","+cantidad*precio+");";
                    try{
                        PreparedStatement ps3 = IniciarSesion.getConection().getConnection().prepareStatement(query2);
                        int m = ps3.executeUpdate();
                        if(m>0){
                            JOptionPane.showMessageDialog(null,"Venta ingresada correctamente");
                        }
                        Date date = new Date();
                        String q = "INSERT INTO LogVenta(idVenta,fecha,hora) VALUES("+idVenta+",'"+date.getYear()+"-"+date.getMonth()+"-"+date.getDay()+"','"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+"');";
                        try{
                            PreparedStatement ps5 = IniciarSesion.getConection().getConnection().prepareStatement(q);
                            ps5.executeUpdate();
                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(null,"Ocurrió un error, ingrese nuevamente los datos");
                        }
                   }catch (SQLException ex) {
                        Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            
                    ventana.setVisible(false);
                    ap.setVisible(true); 
                }
            }
        }
    }
    }
    
     public boolean estaVacio(JTextField campo){
        if(campo.getText().equals("")) 
            return true;
        return false;
    }
     
    public void actualizarTablaCliente(){
        modeloDefault1.addColumn("idCliente");
        modeloDefault1.addColumn("Nombre");
        modeloDefault1.addColumn("Direccion");
        modeloDefault1.addColumn("Tipo");
        modeloDefault1.addColumn("Identificacion");
        try {
            Statement stm = IniciarSesion.getConection().getConnection().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Clientes c WHERE eliminado = false");
            while (rs.next()) {
                int tipo;
                int marca;
                String[] dato = new String[5];
                dato[0] = rs.getString("idCliente");
                dato[1] = rs.getString("Nombre");
                dato[2] = rs.getString("Direccion");
                Statement stm1 = IniciarSesion.getConection().getConnection().createStatement();
                ResultSet rs1 = stm1.executeQuery("SELECT idClientePersona FROM ClientePersona cp WHERE cp.idCliente="+dato[0]+";");
                while(rs1.next()){
                    dato[3] = "Persona";
                    dato[4] = rs1.getString("idClientePersona");
                }
                Statement stm2 = IniciarSesion.getConection().getConnection().createStatement();
                ResultSet rs2 = stm2.executeQuery("SELECT idClienteEmpresa FROM ClienteEmpresa cp WHERE cp.idCliente="+dato[0]+";");
                while(rs2.next()){
                    dato[3] = "Empresa";
                    dato[4] = rs1.getString("idClienteEmpresa");
                }
                datos1.add(dato);
                modeloDefault1.addRow(dato);
            }
            ventana.TablaUsuario1.setModel(modeloDefault1);
        } catch (SQLException ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     
//    public void actualizarTablaDos(){
//    
//    }
    
    void initComponents(){
//        actualizarTablaDos();
        actualizarTabla();
        actualizarTablaCliente();
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
