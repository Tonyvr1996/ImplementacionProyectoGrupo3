/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import Controladores.Controlador;

/**
 *
 * @author Usuario
 */
public abstract class Persona {
    protected String identificacion;
    protected String nombres;
    protected String apellidos;

    protected String usuario;
    protected int tipoPersonal;
    protected Controlador control;
    
    public Persona() {
    } 

    public Persona(String identificacion, String nombres, String apellidos) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        
    }
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    

    public Controlador getControl() {
        return control;
    }

    public void setControl(Controlador control) {
        this.control = control;
    }
    
}
