/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sop_rmi.DTO;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
public class ClsHamburguesaDTO implements Serializable{
    
    private String id;
    private String tipo;
    private int cantidadIngredientesExtra;
    private double precio;

    public ClsHamburguesaDTO(String id, String tipo, int cantidadIngredientesExtra) {
        this.id = id;
        this.tipo = tipo;
        this.cantidadIngredientesExtra = cantidadIngredientesExtra;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidadIngredientesExtra() {
        return cantidadIngredientesExtra;
    }

    public double getPrecio() {
        return precio;
    }
	public void setPrecio(double precio){
		this.precio=precio;
	}
    
    
}
