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
public abstract class Articulo {
    
    private String id,nombre,tipo,modelo,marca;
    private boolean disponible;
    private double precio;

    public Articulo(String id,String nombre,String tipo, String marca,double precio, boolean disponible) {
        this.tipo = tipo;
        this.marca = marca;
        this.precio=precio;
        this.nombre=nombre;
        this.id=id;
        this.disponible = disponible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
}
