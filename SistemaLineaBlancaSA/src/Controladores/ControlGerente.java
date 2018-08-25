/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Persona.Gerente;
import Vistas.IniciarSesion;
import Vistas.VistaGerente;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
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
    
    
    public ControlGerente(Gerente gerente)  {
        ventana = new VistaGerente();
        this.gerente = gerente;
        this.gerente.setControl(this);
        this.ventana.buscarNombre.addActionListener(this);
        this.ventana.buscarCategori.addActionListener(this);
        this.ventana.jButton3.addActionListener(this);
    }
    
    @Override
    public void presentarVista() {
        this.ventana.setVisible(true);
        initelements();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.ventana.buscarNombre==e.getSource()){
            DefaultTableModel modeloBusqueda = new DefaultTableModel();
            modeloBusqueda.addColumn("idProducto");
            modeloBusqueda.addColumn("Nombre");
            modeloBusqueda.addColumn("Tipo");
            modeloBusqueda.addColumn("Marca");
            modeloBusqueda.addColumn("Precio");
            for(String[] ob: datos){
                boolean validacion = false;
                for(String str: ob){
                    if(str.toLowerCase().contains(this.ventana.jTextField1.getText().toLowerCase())) validacion = true;
                }
                if(validacion) modeloBusqueda.addRow(ob);
            }
            this.ventana.__resultadoTabla.setModel(modeloBusqueda);
        }if(this.ventana.buscarCategori==e.getSource()){
            DefaultTableModel modeloBusqueda = new DefaultTableModel();
        modeloBusqueda.addColumn("idProducto");
        modeloBusqueda.addColumn("Nombre");
        modeloBusqueda.addColumn("Tipo");
        modeloBusqueda.addColumn("Marca");
        modeloBusqueda.addColumn("Precio");
        for(String[] ob: datos){
            boolean validacion = false;
            for(String str: ob){
                if(str.toLowerCase().contains(this.ventana.jTextField2.getText().toLowerCase())) validacion = true;
            }
            if(validacion) modeloBusqueda.addRow(ob);
        }
        this.ventana.__resultadoTabla.setModel(modeloBusqueda);
        }if(this.ventana.jButton3==e.getSource()){
            ventana.hide();
            IniciarSesion s=IniciarSesion.getInstancia();
            ventana.setVisible(false);
            s.setVisible(true);   
        }
    }
    
    void initelements(){
        modeloDefault.addColumn("idUsuario");
        modeloDefault.addColumn("Nombres");
        modeloDefault.addColumn("Apellidos");
        modeloDefault.addColumn("Cédula");
        modeloDefault.addColumn("Usuario");
        modeloDefault.addColumn("Tipo");
        try {
            Statement stm = IniciarSesion.getConection().getConnection().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Usuarios");
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
                datos.add(dato);
                modeloDefault.addRow(dato);
            }
            this.ventana.__resultadoTabla.setModel(modeloDefault);
        } catch (SQLException ex) {
//            Logger.getLogger(ConsultarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
