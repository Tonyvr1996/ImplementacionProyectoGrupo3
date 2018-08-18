/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Andrea Naranjo Lima
 */
public class Conexion {
    
    private static Connection c = null;
    private Statement stm;
    
    public Conexion(){
        //Connection c = null;
        try {
           c = DriverManager
              .getConnection("jdbc:postgresql://127.0.0.1:5432/proyectods",
              "postgres", "12345678");
           stm = c.createStatement();
           c.setAutoCommit(false);
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
        System.out.println("Conexión exitosa");
    }
    
    public Statement getStm() {
        return stm;
    }

    public static Connection getConection() {
        return c;
    }
    
    public Connection getConnection(){
        return c;
    }
}
