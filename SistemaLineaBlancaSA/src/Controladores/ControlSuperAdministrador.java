/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Persona.SuperAdministrador;
import Vistas.IniciarSesion;

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
    
    
    void initelements(){ 
        //actualizarTablaUsuario();
        actualizarTablaUsuario1();
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
