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
public class ClsFacturaDTO implements Serializable{
    
    private double costoSinIva;
    private double costoIva;
    private double costoTotal;
	private int cantHamburguesas;
    private int cantHamPequenia;
    private int cantHamMediana;
    private int cantHamGrande;
	private String medioDePago;

    public ClsFacturaDTO(double costoSinIva, double costoIva, double costoTotal,int cantHamburguesas,int cantHamPequenia, int cantHamMediana, int cantHamGrande) {
        this.costoSinIva = costoSinIva;
        this.costoIva = costoIva;
        this.costoTotal = costoTotal;
		this.cantHamburguesas=cantHamburguesas;
        this.cantHamPequenia = cantHamPequenia;
        this.cantHamMediana = cantHamMediana;
        this.cantHamGrande = cantHamGrande;
    }

    public double getCostoSinIva() {
        return costoSinIva;
    }

    public double getCostoIva() {
        return costoIva;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public int getCantHamPequenia() {
        return cantHamPequenia;
    }

    public int getCantHamMediana() {
        return cantHamMediana;
    }

    public int getCantHamGrande() {
        return cantHamGrande;
    }
    
	public int getCantHamburguesas(){
		return cantHamburguesas;
	}
	public String getMedioDePago()
	{
		return medioDePago;
	}
	public void setMedioDePago(String medioPago)
	{
		this.medioDePago=medioPago;
	}

}
