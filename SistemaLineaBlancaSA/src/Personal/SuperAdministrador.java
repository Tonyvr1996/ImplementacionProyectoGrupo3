/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import Constantes.ConstantesTipoPersonal;
import Controladores.ControlSuperAdministrador;

/**
 *
 * @author san_t
 */
public class SuperAdministrador extends Personal{

    public SuperAdministrador(String identificacion, String nombres, String apellidos, int Edad, String usuario) {
        super(identificacion, nombres, apellidos, Edad, usuario);
        this.tipoPersonal = ConstantesTipoPersonal.SUPERADMIN;
        control = new ControlSuperAdministrador(this);
    }
    
    
    
}
