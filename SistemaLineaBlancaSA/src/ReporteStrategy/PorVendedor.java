/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteStrategy;

import PagoStrategy.*;
import Persona.Cliente;
import Persona.Gerente;
import Persona.Vendedor;


/**
 *
 * @author Usuario
 */
public class PorVendedor implements EstrategiaDeReporte{

    public PorVendedor() {
    }

    @Override
    public void generar() {
        Gerente.generar();
    }

    
    
}
