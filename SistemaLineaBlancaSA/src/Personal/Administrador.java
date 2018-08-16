/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import Constantes.ConstantesTipoPersonal;
import Controladores.ControlAdministrador;

/**
 *
 * @author Usuario
 */
public class Administrador extends Personal{
    
    public Administrador(String identificacion, String nombres, String apellidos, int Edad, String usuario) {
        super(identificacion, nombres, apellidos, Edad, usuario);
        this.tipoPersonal = ConstantesTipoPersonal.ADMINISTRADOR;
        control = new ControlAdministrador(this);
    }
    
}
