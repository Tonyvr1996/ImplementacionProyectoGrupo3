/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Conexion.Conexion;
//import Vistas.AdministrarUsuarios;
//import Vistas.ConsultarUsuario;
//import static Vistas.ConsultarUsuario.TablaUsuario;
//import Vistas.CrearUsuario;
import Vistas.IniciarSesion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yoselin
 */
public class VistaSuperadministrador extends javax.swing.JFrame {

    /**
     * Creates new form VistaSuperadministrador
     */
    
//    private DefaultTableModel modeloDefault = new DefaultTableModel();
//    private LinkedList<String[]> datos = new LinkedList();
//    
//    private DefaultTableModel modeloDefault1 = new DefaultTableModel();
//    private LinkedList<String[]> datos1 = new LinkedList();
    public VistaSuperadministrador() {
        initComponents();
        this.setLocationRelativeTo(null);
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
//        
//        
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaUsuario = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TextoCedula1 = new javax.swing.JTextField();
        TextoNombre1 = new javax.swing.JTextField();
        TextoApellido1 = new javax.swing.JTextField();
        TextoUsuario1 = new javax.swing.JTextField();
        TextoContraseña1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Funciones_o_Cargos1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        TextoId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        RadioBotonNombre1 = new javax.swing.JRadioButton();
        RadioBotonApellido1 = new javax.swing.JRadioButton();
        RadioBotonEdad1 = new javax.swing.JRadioButton();
        RadioBotonFuncion1 = new javax.swing.JRadioButton();
        jTextField6 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        BotonEliminar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextoCedula = new javax.swing.JTextField();
        TextoNombre = new javax.swing.JTextField();
        TextoApellido = new javax.swing.JTextField();
        TextoUsuario = new javax.swing.JTextField();
        TextoContraseña = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Funciones_o_Cargos = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        BotonGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaUsuario1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        RadioBotonNombre = new javax.swing.JRadioButton();
        RadioBotonApellido = new javax.swing.JRadioButton();
        RadioBotonEdad = new javax.swing.JRadioButton();
        RadioBotonFuncion = new javax.swing.JRadioButton();
        jTextField5 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(TablaUsuario);

        jLabel5.setText("Nombre");

        jLabel9.setText("Apellido");

        jLabel12.setText("Identificacion");

        jLabel13.setText("Funcion");

        jLabel14.setText("Usuario");

        jLabel15.setText("Contraseña");

        TextoCedula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoCedula1ActionPerformed(evt);
            }
        });

        TextoApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoApellido1ActionPerformed(evt);
            }
        });

        TextoUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoUsuario1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Datos del Usuario:");

        Funciones_o_Cargos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUPERADMINISTRADOR", "ADMINISTRADOR", "GERENTE", "VENDEDOR" }));
        Funciones_o_Cargos1.setName(""); // NOI18N
        Funciones_o_Cargos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Funciones_o_Cargos1ActionPerformed(evt);
            }
        });

        jLabel17.setText("idUsuario");

        TextoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoIdActionPerformed(evt);
            }
        });

        jLabel1.setText("Lista de Personal");

        jLabel18.setText("Buscar Usuario Por:");

        RadioBotonNombre1.setText("Nombre");
        RadioBotonNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBotonNombre1ActionPerformed(evt);
            }
        });

        RadioBotonApellido1.setText("Apellido");

        RadioBotonEdad1.setText("Edad");
        RadioBotonEdad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBotonEdad1ActionPerformed(evt);
            }
        });

        RadioBotonFuncion1.setText("Funcion");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextoCedula1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(TextoNombre1)
                            .addComponent(TextoApellido1)
                            .addComponent(TextoId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextoUsuario1))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Funciones_o_Cargos1, 0, 148, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextoContraseña1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadioBotonNombre1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadioBotonApellido1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadioBotonEdad1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadioBotonFuncion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextoCedula1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Funciones_o_Cargos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoContraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(TextoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(RadioBotonNombre1)
                    .addComponent(RadioBotonApellido1)
                    .addComponent(RadioBotonEdad1)
                    .addComponent(RadioBotonFuncion1)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        BotonEliminar.setText("Eliminar");
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(Editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonBuscar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 954, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Editar/Eliminar", jPanel6);

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Identificacion");

        jLabel6.setText("Funcion");

        jLabel7.setText("Usuario");

        jLabel8.setText("Contraseña");

        TextoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoCedulaActionPerformed(evt);
            }
        });

        TextoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoApellidoActionPerformed(evt);
            }
        });

        TextoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoUsuarioActionPerformed(evt);
            }
        });

        jLabel10.setText("Datos del Usuario:");

        Funciones_o_Cargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUPERADMINISTRADOR", "ADMINISTRADOR", "GERENTE", "VENDEDOR" }));
        Funciones_o_Cargos.setName(""); // NOI18N
        Funciones_o_Cargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Funciones_o_CargosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextoCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(TextoNombre)
                            .addComponent(TextoApellido))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Funciones_o_Cargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Funciones_o_Cargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );

        BotonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        BotonGuardar.setText("Guardar");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(BotonGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 954, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Crear Usuario", jPanel1);

        TablaUsuario1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaUsuario1);

        jLabel11.setText("Buscar Usuario Por:");

        RadioBotonNombre.setText("Nombre");
        RadioBotonNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBotonNombreActionPerformed(evt);
            }
        });

        RadioBotonApellido.setText("Apellido");

        RadioBotonEdad.setText("Edad");
        RadioBotonEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBotonEdadActionPerformed(evt);
            }
        });

        RadioBotonFuncion.setText("Funcion");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/find.png"))); // NOI18N
        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadioBotonNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioBotonApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioBotonEdad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadioBotonFuncion)
                .addGap(18, 18, 18)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(RadioBotonNombre)
                    .addComponent(RadioBotonApellido)
                    .addComponent(RadioBotonEdad)
                    .addComponent(RadioBotonFuncion)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 954, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 99, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 99, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Consultar Usuario", jPanel3);

        jButton1.setText("jButton1");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_sign-out_49560.png"))); // NOI18N
        jButton2.setText("Cerrar Sesión");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
//        DefaultTableModel modeloBusqueda = new DefaultTableModel();
//        modeloBusqueda.addColumn("idUusario");
//        modeloBusqueda.addColumn("Nombres");
//        modeloBusqueda.addColumn("Apellidos");
//        modeloBusqueda.addColumn("Cédula");
//        modeloBusqueda.addColumn("Usuario");
//        modeloBusqueda.addColumn("Tipo");
//        for(String[] ob: datos){
//            boolean validacion = false;
//            for(String str: ob){
//                if(str.toLowerCase().contains(jTextField5.getText().toLowerCase())) validacion = true;
//            }
//            if(validacion) modeloBusqueda.addRow(ob);
//        }
//        this.TablaUsuario.setModel(modeloBusqueda);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void RadioBotonEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBotonEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioBotonEdadActionPerformed

    private void RadioBotonNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBotonNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioBotonNombreActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        // TODO add your handling code here:
//        String cedula = TextoCedula.getText();
//        String nombres = TextoNombre.getText();
//        String apellidos = TextoApellido.getText();
//        String usuario = TextoUsuario.getText();
//        String contrasenia = TextoContraseña.getText();
//        int tipo = Funciones_o_Cargos.getSelectedIndex()+1;
//        if(estaVacio(TextoApellido) || estaVacio(TextoCedula) || estaVacio(TextoContraseña) ||estaVacio(TextoNombre) || estaVacio(TextoUsuario)){
//            JOptionPane.showMessageDialog(null, "Existen campos vacios, por favor llenar todos los campos");
//        } else if(cedula.length()!=10){
//            JOptionPane.showMessageDialog(null, "La cédula ingresada es incorrecta");
//        }else {
//            String query = "INSERT INTO Usuarios(Nombres,Apellidos,Cedula,Usuario,Contraseña,idTipo) VALUES (?,?,?,?,?,?)";
//            try{
//                PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query);
//                ps.setString(1,nombres);
//                ps.setString(2,apellidos);
//                ps.setString(3,cedula);
//                ps.setString(4,usuario);
//                ps.setString(5,contrasenia);
//                ps.setInt(6,tipo);
//                ps.executeUpdate();
//                VistaSuperadministrador vs = new VistaSuperadministrador();
//                JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente");
//                this.setVisible(false);
//                vs.setVisible(true);
//            }catch (SQLException ex) {
//                Logger.getLogger(VistaSuperadministrador.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void Funciones_o_CargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Funciones_o_CargosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Funciones_o_CargosActionPerformed

    private void TextoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoUsuarioActionPerformed

    private void TextoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoApellidoActionPerformed

    private void TextoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoCedulaActionPerformed

    private void TextoCedula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoCedula1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoCedula1ActionPerformed

    private void TextoApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoApellido1ActionPerformed

    private void TextoUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoUsuario1ActionPerformed

    private void Funciones_o_Cargos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Funciones_o_Cargos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Funciones_o_Cargos1ActionPerformed

    private void TextoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoIdActionPerformed

    private void RadioBotonNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBotonNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioBotonNombre1ActionPerformed

    private void RadioBotonEdad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBotonEdad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioBotonEdad1ActionPerformed

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        // TODO add your handling code here:
//        String id = TextoId.getText();
//        if(estaVacio(TextoId)){
//            JOptionPane.showMessageDialog(null, "No ha ingresado el id. Introduzca el dato");
//        }else {
//            String query1 = "SELECT idUsuario FROM Usuarios u WHERE u.idUsuario="+id+";";
//            try{
//                Statement stm = IniciarSesion.getConection().getConnection().createStatement();
//                ResultSet rs = stm.executeQuery(query1);
//                while(rs.next()){
//                    int idus = rs.getInt("idUsuario");
//                    String query2 = "UPDATE Usuarios SET eliminado = true WHERE idUsuario="+idus+";";
//                    PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query2);
//                    int n = ps.executeUpdate();
//                    VistaSuperadministrador vs = new VistaSuperadministrador();
//                    if(n>0){
//                        JOptionPane.showMessageDialog(null, "Usuario eliminado de la base de datos");
//                    }
//                    else{
//                        JOptionPane.showMessageDialog(null, "Ocurrió un error");
//                    }
//                    this.setVisible(false);
//                    vs.setVisible(true);
//                }
//                
//            }catch (SQLException ex) {
//                Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO add your handling code here:
//        String cedula = TextoCedula.getText();
//        String nombres = TextoNombre.getText();
//        String apellidos = TextoApellido.getText();
//        String usuario = TextoCedula.getText();
//        String contrasenia = TextoContraseña.getText();
//        String id = TextoId.getText();
//        int tipo = Funciones_o_Cargos.getSelectedIndex()+1;
//        if(estaVacio(TextoApellido) || estaVacio(TextoCedula) || estaVacio(TextoContraseña) ||estaVacio(TextoNombre) || estaVacio(TextoUsuario)){
//            JOptionPane.showMessageDialog(null, "Existen campos vacios, por favor llenar todos los campos");
//        } else if(cedula.length()!=10){
//            JOptionPane.showMessageDialog(null, "La cédula ingresada es incorrecta");
//        }else {
//            String query1 = "SELECT idUsuario FROM Usuarios u WHERE u.idUsuario="+id+";";
//            try{
//                Statement stm = IniciarSesion.getConection().getConnection().createStatement();
//                ResultSet rs = stm.executeQuery(query1);
//                String idusuario;
//                while(rs.next()){
//                    int idus = rs.getInt("idUsuario");
//                    String query2 = "UPDATE Usuarios SET Nombres = ? , Apellidos = ? , Cedula = ? , Usuario = ? , Contraseña = ? , idTipo = ? WHERE idUsuario="+idus+";";
//                    PreparedStatement ps = IniciarSesion.getConection().getConnection().prepareStatement(query2);
//                    ps.setString(1,nombres);
//                    ps.setString(2,apellidos);
//                    ps.setString(3,cedula);
//                    ps.setString(4,usuario);
//                    ps.setString(5,contrasenia);
//                    ps.setInt(6,tipo);
//                    ps.executeUpdate();
//                    VistaSuperadministrador vs = new VistaSuperadministrador();
//                    JOptionPane.showMessageDialog(null, "Usuario editado correctamente");
//                    this.setVisible(false);
//                    vs.setVisible(true);
//                }
//
//            }catch (SQLException ex) {
////                Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_EditarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
//        DefaultTableModel modeloBusqueda = new DefaultTableModel();
//        modeloBusqueda.addColumn("idUusario");
//        modeloBusqueda.addColumn("Nombres");
//        modeloBusqueda.addColumn("Apellidos");
//        modeloBusqueda.addColumn("Cédula");
//        modeloBusqueda.addColumn("Usuario");
//        modeloBusqueda.addColumn("Tipo");
//        for(String[] ob: datos){
//            boolean validacion = false;
//            for(String str: ob){
//                if(str.toLowerCase().contains(jTextField5.getText().toLowerCase())) validacion = true;
//            }
//            if(validacion) modeloBusqueda.addRow(ob);
//        }
//        this.TablaUsuario1.setModel(modeloBusqueda);
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        this.hide();
//        IniciarSesion s=IniciarSesion.getInstancia();
//        this.setVisible(false);
//        s.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    public boolean estaVacio(JTextField campo){
        if(campo.getText().equals("")) return true;
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaSuperadministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaSuperadministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaSuperadministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaSuperadministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaSuperadministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BotonEliminar;
    public static javax.swing.JButton BotonGuardar;
    public static javax.swing.JButton Editar;
    public static javax.swing.JComboBox<String> Funciones_o_Cargos;
    public static javax.swing.JComboBox<String> Funciones_o_Cargos1;
    public static javax.swing.JRadioButton RadioBotonApellido;
    public static javax.swing.JRadioButton RadioBotonApellido1;
    public static javax.swing.JRadioButton RadioBotonEdad;
    public static javax.swing.JRadioButton RadioBotonEdad1;
    public static javax.swing.JRadioButton RadioBotonFuncion;
    public static javax.swing.JRadioButton RadioBotonFuncion1;
    public static javax.swing.JRadioButton RadioBotonNombre;
    public static javax.swing.JRadioButton RadioBotonNombre1;
    public static javax.swing.JTable TablaUsuario;
    public static javax.swing.JTable TablaUsuario1;
    public static javax.swing.JTextField TextoApellido;
    public static javax.swing.JTextField TextoApellido1;
    public static javax.swing.JTextField TextoCedula;
    public static javax.swing.JTextField TextoCedula1;
    public static javax.swing.JTextField TextoContraseña;
    public static javax.swing.JTextField TextoContraseña1;
    public static javax.swing.JTextField TextoId;
    public static javax.swing.JTextField TextoNombre;
    public static javax.swing.JTextField TextoNombre1;
    public static javax.swing.JTextField TextoUsuario;
    public static javax.swing.JTextField TextoUsuario1;
    public static javax.swing.JButton botonBuscar;
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
