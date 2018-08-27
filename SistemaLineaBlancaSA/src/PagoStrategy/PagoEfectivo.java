/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PagoStrategy;

import Persona.Cliente;
import Persona.Vendedor;


/**
 *
 * @author Usuario
 */
public class PagoEfectivo implements EstrategiaDePago{

    public PagoEfectivo() {
    }

    @Override
    public void pagar(String cliente, int desc) {
        Vendedor.Facturar(cliente, desc, 1);
    }

    
    
}
