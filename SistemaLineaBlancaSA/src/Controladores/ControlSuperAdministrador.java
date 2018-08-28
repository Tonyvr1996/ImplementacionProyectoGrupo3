/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Persona.SuperAdministrador;
import Vistas.singleton.IniciarSesion;

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
import static Vistas.VistaSuperadministrador.TablaUsuario;
import static Vistas.VistaSuperadministrador.TablaUsuario1;
import java.util.Date;

/**
 *
 * @author san_t
 */
public class ControlSuperAdministrador implements Controlador {
    
    private VistaSuperadministrador ventana;
    private SuperAdministrador SuperAdministrador;
    private DefaultTableModel modeloDefault = new DefaultTableModel();
    private LinkedList<String[]> datos = new LinkedList();
    private DefaultTableModel modeloDefault1 = new DefaultTableModel();
    private LinkedList<String[]> datos1 = new LinkedList();
     private DefaultTableModel modeloDefault2 = new DefaultTableModel();
    private LinkedList<String[]> datos2 = new LinkedList();
    private DefaultTableModel modeloDefault3 = new DefaultTableModel();
    private LinkedList<String[]> datos3 = new LinkedList();
    
    
    public ControlSuperAdministrador(SuperAdministrador SuperAdministrador)  {
        ventana = new VistaSuperadministrador();
        this.SuperAdministrador = SuperAdministrador;
        this.SuperAdministrador.setControl(this);
        this.ventana.Editar.addActionListener(this);
        this.ventana.jButton2.addActionListener(this);
        this.ventana.BotonEliminar.addActionListener(this);
        this.ventana.botonBuscar.addActionListener(this);
        this.ventana.jButton6.addActionListener(this);
        this.ventana.BotonGuardar.addActionListener(this);
        this.ventana.BotonGuardar1.addActionListener(this);
        this.ventana.botonBuscar1.addActionListener(this);
        this.ventana.Editar1.addActionListener(this);
        this.ventana.BotonEliminar1.addActionListener(this);
        this.ventana.botonBuscar2.addActionListener(this);
        this.ventana.AgregarProducto.addActionListener(this);
        this.ventana.EliminarProducto.addActionListener(this);
        //ventana.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ventana.Editar==e.getSource()){
            String cedula = this.ventana.TextoCedula.getText();
        String nombres = this.ventana.TextoNombre.getText();
        String apellidos = this.ventana.TextoApellido.getText();
        String usuario = this.ventana.TextoCedula.getText();
        String contrasenia = this.ventana.TextoContraseña.getText();
        String id = this.ventana.TextoId.getText();
        int tipo = this.ventana.Funciones_o_Cargos.getSelectedIndex()+1;
        if(estaVacio(this.ventana.TextoApellido) || estaVacio(this.ventana.TextoCedula) || estaVacio(this.ventana.TextoContraseña) ||estaVacio(this.ventana.TextoNombre) || estaVacio(this.ventana.TextoUsuario)){
            JOptionPane.showMessageDialog(null, "Existen campos vacios, por favor llenar todos los campos");
        } else if(cedula.length()!=10){
            JOptionPane.showMessageDialog(null, "La cédula ingresada es incorrecta");
        }else {
            String query1 = "SELECT idUsuario FROM Usuarios u WHERE u.idUsuario="+id+";";
            try{
                Statement stm = IniciarSesion.getConection().getConnection().createStatement();
                ResultSet rs = stm.executeQuery(query1);
                String idusuario;
                while(rs.next()){
                    int idus = rs.getInt("idUsuario");
                    String query2 = "UPDATE Usuarios SET Nombres = ? , Apellidos = ? , Cedula = ? , Usuario = ? , Contraseña = ? , idTipo = ? WHERE idUsuario="+idus+";";
                    PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query2);
                    ps.setString(1,nombres);
                    ps.setString(2,apellidos);
                    ps.setString(3,cedula);
                    ps.setString(4,usuario);
                    ps.setString(5,contrasenia);
                    ps.setInt(6,tipo);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Usuario editado correctamente");                    
                }

            }catch (SQLException ex) {
                Logger.getLogger(VistaSuperadministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }if(ventana.jButton2==e.getSource()){
            ventana.hide();
            IniciarSesion s=IniciarSesion.getInstancia();
            ventana.setVisible(false);
            s.setVisible(true);   
        }if(ventana.BotonEliminar==e.getSource()){
            String id = this.ventana.TextoId.getText();
            if(estaVacio(this.ventana.TextoId)){
                JOptionPane.showMessageDialog(null, "No ha ingresado el id. Introduzca el dato");
            }else {
                String query1 = "SELECT idUsuario FROM Usuarios u WHERE u.idUsuario="+id+";";
                try{
                    Statement stm = IniciarSesion.getConection().getConnection().createStatement();
                    ResultSet rs = stm.executeQuery(query1);
                    while(rs.next()){
                        int idus = rs.getInt("idUsuario");
                        String query2 = "UPDATE Usuarios SET eliminado = true WHERE idUsuario="+idus+";";
                        PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query2);
                        int n = ps.executeUpdate();
    //                    VistaSuperadministrador vs = new VistaSuperadministrador();
                        if(n>0){
                            modeloDefault1.setRowCount(0);
                            modeloDefault1.setColumnCount(0);
                            modeloDefault.setRowCount(0);
                            modeloDefault.setColumnCount(0); 
                            datos.clear();
                            datos1.clear();
                            //actualizarTablaUsuario();
                            actualizarTablaUsuario1();
                            
                            JOptionPane.showMessageDialog(null, "Usuario eliminado de la base de datos");
                            
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Ocurrió un error");
                        }
    //                    this.setVisible(false);
    //                    vs.setVisible(true);
                    }

                }catch (SQLException ex) {
                    Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }if(this.ventana.botonBuscar==e.getSource()){
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
                    if(str.toLowerCase().contains(this.ventana.jTextField6.getText().toLowerCase())) validacion = true;
                }
                if(validacion) modeloBusqueda.addRow(ob);
            }
            this.ventana.TablaUsuario.setModel(modeloBusqueda);
     
        }if(this.ventana.BotonGuardar==e.getSource()){
            String cedula = this.ventana.TextoCedula.getText();
            String nombres = this.ventana.TextoNombre.getText();
            String apellidos = this.ventana.TextoApellido.getText();
            String usuario = this.ventana.TextoUsuario.getText();
            String contrasenia = this.ventana.TextoContraseña.getText();
            int tipo = this.ventana.Funciones_o_Cargos.getSelectedIndex()+1;
            if(estaVacio(this.ventana.TextoApellido) || estaVacio(this.ventana.TextoCedula) || estaVacio(this.ventana.TextoContraseña) ||estaVacio(this.ventana.TextoNombre) || estaVacio(this.ventana.TextoUsuario)){
                JOptionPane.showMessageDialog(null, "Existen campos vacios, por favor llenar todos los campos");
            } else if(cedula.length()!=10){
                JOptionPane.showMessageDialog(null, "La cédula ingresada es incorrecta");
            }else {
                String query = "INSERT INTO Usuarios(Nombres,Apellidos,Cedula,Usuario,Contraseña,idTipo) VALUES (?,?,?,?,?,?)";
                try{
                    PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query);
                    ps.setString(1,nombres);
                    ps.setString(2,apellidos);
                    ps.setString(3,cedula);
                    ps.setString(4,usuario);
                    ps.setString(5,contrasenia);
                    ps.setInt(6,tipo);
                    ps.executeUpdate();
                    //VistaSuperadministrador vs = new VistaSuperadministrador();
                    JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente");
                    //this.setVisible(false);
                    //vs.setVisible(true);
                }catch (SQLException ex) {
                    Logger.getLogger(VistaSuperadministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }if(this.ventana.jButton6==e.getSource()){
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
            
        }if(this.ventana.BotonGuardar==e.getSource()){
            String cedula = this.ventana.TextoCedula.getText();
            String nombres = this.ventana.TextoNombre.getText();
            String apellidos = this.ventana.TextoApellido.getText();
            String usuario = this.ventana.TextoUsuario.getText();
            String contrasenia = this.ventana.TextoContraseña.getText();
            int tipo = this.ventana.Funciones_o_Cargos.getSelectedIndex()+1;
            if(estaVacio(this.ventana.TextoApellido) || estaVacio(this.ventana.TextoCedula) || estaVacio(this.ventana.TextoContraseña) ||estaVacio(this.ventana.TextoNombre) || estaVacio(this.ventana.TextoUsuario)){
                JOptionPane.showMessageDialog(null, "Existen campos vacios, por favor llenar todos los campos");
            } else if(cedula.length()!=10){
                JOptionPane.showMessageDialog(null, "La cédula ingresada es incorrecta");
            }else {
                String query = "INSERT INTO Usuarios(Nombres,Apellidos,Cedula,Usuario,Contraseña,idTipo) VALUES (?,?,?,?,?,?)";
                try{
                    PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query);
                    ps.setString(1,nombres);
                    ps.setString(2,apellidos);
                    ps.setString(3,cedula);
                    ps.setString(4,usuario);
                    ps.setString(5,contrasenia);
                    ps.setInt(6,tipo);
                    ps.executeUpdate();
                    //VistaSuperadministrador vs = new VistaSuperadministrador();
                    JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente");
                    //this.setVisible(false);
                    //vs.setVisible(true);
                }catch (SQLException ex) {
                    Logger.getLogger(VistaSuperadministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }if(this.ventana.BotonGuardar1==e.getSource()){
            if(estaVacio(this.ventana.txtNombre1) || estaVacio(this.ventana.txtPrecio1)){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos. Ingrese todos los datos");
            }else{
                String nombre = this.ventana.txtNombre1.getText();
                int tipo = this.ventana.jComboBox1.getSelectedIndex()+1;
                int marca = this.ventana.jComboBox2.getSelectedIndex()+1;
                float precio = Float.parseFloat(this.ventana.txtPrecio1.getText());
                String query = "INSERT INTO Articulos(Nombremodelo,idTipoArticulo,idMarca,Precio) VALUES ('"+nombre+"',"+tipo+","+marca+","+precio+");";
                try{
                    PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query);
                    int n = ps.executeUpdate();
                    VistaSuperadministrador ap = new VistaSuperadministrador();
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
        }if(this.ventana.Editar1==e.getSource()){
            String nombre = this.ventana.txtNombre.getText();
           float precio = Float.parseFloat(this.ventana.txtPrecio.getText());
           int id = Integer.parseInt(this.ventana.txtId.getText());
           int tipo = this.ventana.jComboBox1.getSelectedIndex()+1;
           int marca = this.ventana.jComboBox2.getSelectedIndex()+1;
           if(estaVacio(this.ventana.txtNombre) || estaVacio(this.ventana.txtPrecio) || estaVacio(this.ventana.txtId)){
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
                   Logger.getLogger(VistaSuperadministrador.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }if(this.ventana.BotonEliminar1==e.getSource()){
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
                          modeloDefault2.setRowCount(0);  
                          modeloDefault2.setColumnCount(0);
                          modeloDefault3.setRowCount(0);
                          modeloDefault3.setColumnCount(0);
                          datos2.clear();
                          datos3.clear();
                          actualizarTablaUsuario2();
                          actualizarTablaUsuario3();                        
                            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                            //ventana.setVisible(false);
                            //vs.setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Ocurrió un error, vuelva a intentarlo");
                        }
                    }

                }catch (SQLException ex) {
                    Logger.getLogger(ControlSuperAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }if(this.ventana.botonBuscar2==e.getSource()){
            DefaultTableModel modeloBusqueda = new DefaultTableModel();
            modeloBusqueda.addColumn("idProducto");
            modeloBusqueda.addColumn("Nombre");
            modeloBusqueda.addColumn("Tipo");
            modeloBusqueda.addColumn("Marca");
            modeloBusqueda.addColumn("Precio");
            for(String[] ob: datos2){
                boolean validacion = false;
                for(String str: ob){
                    if(str.toLowerCase().contains(ventana.jTextField8.getText().toLowerCase())) validacion = true;
                }
                if(validacion) modeloBusqueda.addRow(ob);
            }
            ventana.TablaUsuario3.setModel(modeloBusqueda);
        }
        if(this.ventana.AgregarProducto==e.getSource()){
            if(estaVacio(this.ventana.jTextField1) || estaVacio(this.ventana.jTextField3) || estaVacio(this.ventana.jTextField4)){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos. Ingrese todos los datos");
            }else{
                VistaSuperadministrador ap = new VistaSuperadministrador();
                int idVenta = 0;
                String nombre = this.ventana.jTextField1.getText() + " " + this.ventana.jTextField2.getText();
                String identificacion = this.ventana.jTextField3.getText();
                String direccion = this.ventana.jTextField4.getText();
                int cantidad = this.ventana.jComboBox9.getSelectedIndex() + 1;
                int idCliente = 0;
                int articulo = this.ventana.jComboBox8.getSelectedIndex() + 1;
                int tipoPago = this.ventana.jComboBox5.getSelectedIndex() + 1;
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
    
    
    public boolean estaVacio(JTextField campo){
        if(campo.getText().equals("")) 
            return true;
        return false;
    }
    
    @Override
    public void presentarVista() {
        this.ventana.setVisible(true);
        initelements();
    }

//    void actualizarTablaUsuario(){
//        modeloDefault.addColumn("idUsuario");
//        modeloDefault.addColumn("Nombres");
//        modeloDefault.addColumn("Apellidos");
//        modeloDefault.addColumn("Cédula");
//        modeloDefault.addColumn("Usuario");
//        modeloDefault.addColumn("Tipo");
//        try {
//            Statement stm = IniciarSesion.getConection().getConnection().createStatement();
//            ResultSet rs = stm.executeQuery("SELECT * FROM Usuarios");
//            //ResultSet rs2 = stm.executeQuery("SELECT * FROM Usuarios where eliminado = false");
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
//            //TablaUsuario1.setModel(modeloDefault);
//        } catch (SQLException ex) {
////            Logger.getLogger(ConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
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
            this.ventana.TablaUsuario.setModel(modeloDefault1);
        } catch (SQLException ex) {
            Logger.getLogger(VistaSuperadministrador.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void actualizarTablaUsuario3(){
        modeloDefault3.addColumn("idProducto");
        modeloDefault3.addColumn("Nombre");
        modeloDefault3.addColumn("Tipo");
        modeloDefault3.addColumn("Marca");
        modeloDefault3.addColumn("Precio");
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
                datos3.add(dato);
                modeloDefault3.addRow(dato);
                
            }
            this.ventana.TablaUsuario3.setModel(modeloDefault3);
        } catch (SQLException ex) {
            Logger.getLogger(VistaSuperadministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void initelements(){ 
        //actualizarTablaUsuario();
        actualizarTablaUsuario1();
        actualizarTablaUsuario2();
        actualizarTablaUsuario3();
//        modeloDefault.addColumn("idUsuario");
//        modeloDefault.addColumn("Nombres");
//        modeloDefault.addColumn("Apellidos");
//        modeloDefault.addColumn("Cédula");
//        modeloDefault.addColumn("Usuario");
//        modeloDefault.addColumn("Tipo");
//        try {
//            Statement stm = IniciarSesion.getConection().getConnection().createStatement();
//            ResultSet rs = stm.executeQuery("SELECT * FROM Usuarios");
//            //ResultSet rs2 = stm.executeQuery("SELECT * FROM Usuarios where eliminado = false");
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
//            TablaUsuario.setModel(modeloDefault);
//            //TablaUsuario1.setModel(modeloDefault);
//        } catch (SQLException ex) {
////            Logger.getLogger(ConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
//        JOptionPane.showMessageDialog(null, "Para eliminar un usuario tiene que ingresar sólo el id");
//        modeloDefault1.addColumn("idUsuario");
//        modeloDefault1.addColumn("Nombres");
//        modeloDefault1.addColumn("Apellidos");
//        modeloDefault1.addColumn("Cédula");
//        modeloDefault1.addColumn("Usuario");
//        modeloDefault1.addColumn("Tipo");
//        try {
//            Statement stm = IniciarSesion.getConection().getConnection().createStatement();
//            ResultSet rs = stm.executeQuery("SELECT * FROM Usuarios where eliminado = false");
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
//                datos1.add(dato);
//                modeloDefault1.addRow(dato);
//            }
//            TablaUsuario1.setModel(modeloDefault1);
//        } catch (SQLException ex) {
//            Logger.getLogger(VistaSuperadministrador.class.getName()).log(Level.SEVERE, null, ex);
//        }

    
    
}
}
