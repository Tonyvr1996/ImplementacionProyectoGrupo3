/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import Constantes.ConstantesTipoPersonal;
import Controladores.ControlGerente;

/**
 *
 * @author san_t
 */
public class Gerente extends Personal{

    public Gerente(String identificacion, String nombres, String apellidos, int Edad, String usuario) {
        super(identificacion, nombres, apellidos, Edad, usuario);
        this.tipoPersonal = ConstantesTipoPersonal.GERENTE;
        control = new ControlGerente(this);
    }
    
    
    
}
