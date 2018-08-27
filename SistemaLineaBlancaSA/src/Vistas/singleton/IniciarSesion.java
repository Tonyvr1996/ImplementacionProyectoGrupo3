
package Vistas.singleton;

import Conexion.Conexion;
import Persona.Administrador;
import Persona.Gerente;
import Persona.Persona;
import Persona.SuperAdministrador;
import Persona.Vendedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class IniciarSesion extends javax.swing.JFrame {
    
    private static IniciarSesion instancia=null;
    public static Conexion conection;
    public Statement stm;
    
    private IniciarSesion() {
        this.conection = new Conexion();
        this.stm = conection.getStm();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public IniciarSesion(Conexion conection) {
        this.conection = conection;
        this.stm = conection.getStm();
    }
 
    private synchronized static void crearInstancia(){
        if(instancia==null){
            instancia=new IniciarSesion();
        }
    }
    
    public static IniciarSesion getInstancia(){
        if (instancia==null){
            crearInstancia();
        }
        return instancia;

    }
    
    @Override
    public Object clone(){
        return IniciarSesion.getInstancia();
    }
    
     public int tipoUsuarioExiste(String usuario,String contraseña){
        Persona A=null;
        String query = "SELECT * FROM Usuarios u where u.usuario='"+usuario+"' AND u.contraseña='"+contraseña+"' AND eliminado = false;";
        int tipo=0;
        try {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                //System.out.println(rs.getString(1));
                tipo = rs.getInt("idtipo");

        if(tipo == 1){
            return tipo;
        }else if(tipo ==2){
            return tipo;
        }else if(tipo == 3){
            return tipo;
        }else if(tipo == 4){
            return tipo;
        }else{
            return tipo;
        }}
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return tipo;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jColorChooser1 = new javax.swing.JColorChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPasword = new javax.swing.JPasswordField();
        btIngresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        btIngresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btIngresar.setText("Ingresar");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/color.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Limpiar Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPasword, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createSequentialGroup()
                    .addGap(383, 383, 383)
                    .addComponent(jLabel4)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPasword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btIngresar)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
    Bienvenida acceso= new Bienvenida();
            acceso.setVisible(true);
            this.setVisible(false);
    */
    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        String user,pwd;
        user=txtUsuario.getText();
        pwd = txtPasword.getText();
        int tipo = 0;
        String query = "SELECT * FROM Usuarios u where u.usuario='"+user+"' AND u.contraseña='"+pwd+"' AND eliminado = false;";
        
        try {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                //System.out.println(rs.getString(1));
                tipo = rs.getInt("idtipo");
            
         
        if(tipo == 1){
            Persona A=new SuperAdministrador(rs.getString("Cedula"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Usuario"),rs.getString("Contraseña"));
            A.getControl().presentarVista();
            this.setVisible(false);
//            VistaSuperadministrador VS = new VistaSuperadministrador();
//            VS.setVisible(true);
//            this.setVisible(false);
//              SuperAdministrador a=new SuperAdministrador();
//              this.setVisible(false);
        }else if(tipo ==2){
            Persona A = new Administrador(rs.getString("Cedula"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Usuario"),rs.getString("Contraseña"));
            A.getControl().presentarVista();
            this.setVisible(false);
        }else if(tipo == 3){
            Persona A = new Gerente(rs.getString("Cedula"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Usuario"),rs.getString("Contraseña"));
            A.getControl().presentarVista();
            this.setVisible(false);
//            VG.setVisible(true);
//            this.setVisible(false);
        }else if(tipo == 4){
            Persona A = new Vendedor(rs.getString("Cedula"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Usuario"),rs.getString("Contraseña"));
            A.getControl().presentarVista();
            this.setVisible(false);
            
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrió un error. Ingrese nuevamente los datos");
        }}
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }//GEN-LAST:event_btIngresarActionPerformed

    public static Conexion getConection() {
        return conection;
    }

    public static void setConection(Conexion conection) {
        IniciarSesion.conection = conection;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public JButton getBtIngresar() {
        return btIngresar;
    }

    public void setBtIngresar(JButton btIngresar) {
        this.btIngresar = btIngresar;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JColorChooser getjColorChooser1() {
        return jColorChooser1;
    }

    public void setjColorChooser1(JColorChooser jColorChooser1) {
        this.jColorChooser1 = jColorChooser1;
    }

    public JEditorPane getjEditorPane1() {
        return jEditorPane1;
    }

    public void setjEditorPane1(JEditorPane jEditorPane1) {
        this.jEditorPane1 = jEditorPane1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public Persona buscarPersona(String usuario,String contraseña ){       
        Persona A=null;
        String query = "SELECT * FROM Usuarios u where u.usuario='"+usuario+"' AND u.contraseña='"+contraseña+"' AND eliminado = false;";
        int tipo=0;
        try {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                //System.out.println(rs.getString(1));
                tipo = rs.getInt("idtipo");        
        if(tipo == 1){
             A=new SuperAdministrador(rs.getString("Cedula"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Usuario"),rs.getString("Contraseña"));
        }else if(tipo ==2){
             A = new Administrador(rs.getString("Cedula"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Usuario"),rs.getString("Contraseña"));
        }else if(tipo == 3){
             A = new Gerente(rs.getString("Cedula"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Usuario"),rs.getString("Contraseña"));
        }else if(tipo == 4){
             A = new Vendedor(rs.getString("Cedula"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Usuario"),rs.getString("Contraseña"));
        }else{
            return A;
        }}
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return A;
    }
    
    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void borrarCampos(){
        txtUsuario.setText("");
        txtPasword.setText("");
    }
    
    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public String getTxtPasword() {
        return txtPasword.getText();
    }

    public void setTxtPasword(JPasswordField txtPasword) {
        this.txtPasword = txtPasword;
    }

    public String getTxtUsuario() {
        return txtUsuario.getText();
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtUsuario.setText("");
        txtPasword.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    /*
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }
    */

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField txtPasword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public void setTxtPasword(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
