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
public class ClsPreciosDTO implements Serializable {
    
    private double precioHamPequenia;
    private double precioHamMediana;
    private double precioHamGrandes;
    private double precioIngredienteExtra;

    public ClsPreciosDTO(double precioHamPequenia,double precioHamMediana,double precioHamGrandes,double precioIngredienteExtra) {
        this.precioHamPequenia = precioHamPequenia;
        this.precioHamMediana = precioHamMediana;
        this.precioHamGrandes = precioHamGrandes;
        this.precioIngredienteExtra = precioIngredienteExtra;
    }

    
    public double getPrecioHamPequenia() {
        return precioHamPequenia;
    }

    public double getPrecioHamMediana() {
        return precioHamMediana;
    }

    public double getPrecioHamGrandes() {
        return precioHamGrandes;
    }

    public double getPrecioIngredienteExtra() {
        return precioIngredienteExtra;
    }
    
    
}
