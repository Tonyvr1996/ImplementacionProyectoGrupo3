/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulo;

/**
 *
 * @author san_t
 */
public class Lavadora extends ArticuloFactory{
    
    public Lavadora(String tipo, String modelo, String marca, boolean disponible) {
        super(tipo, modelo, marca, disponible);
    }
    
}
