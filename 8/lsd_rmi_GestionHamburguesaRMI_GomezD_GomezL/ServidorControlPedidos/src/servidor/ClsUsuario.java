/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import sop_rmi.DTO.ClsFacturaDTO;
import sop_rmi.DTO.ClsPreciosDTO;
import sop_rmi.DTO.ClsHamburguesaDTO;
import java.util.ArrayList;
import sop_rmi.DAO.empresaDAO;

/**
 *
 * @author daniel
 */
public class ClsUsuario {
    private int id;
    private ArrayList<ClsHamburguesaDTO> colHamburguesas; 
    
    public ClsUsuario(int pId) {
        this.id=pId;
        this.colHamburguesas=new ArrayList<ClsHamburguesaDTO>();
    }

    public boolean comprarHamburguesa(ClsHamburguesaDTO newHamburguesa) {
        boolean varResultado=false;
        if(this.buscarHamburguesa(newHamburguesa.getId())==null)
        {
            this.colHamburguesas.add(this.calcularPrecioHamburguesa(newHamburguesa));
            varResultado=true;
        }
        return varResultado;
    }

    public ClsHamburguesaDTO buscarHamburguesa(String idHamburguesa) {
        ClsHamburguesaDTO varResultado=null;
        int posHamburguesaBuscada=this.buscarPosHamburguesa(idHamburguesa);
        if(posHamburguesaBuscada!=-1) varResultado=this.colHamburguesas.get(posHamburguesaBuscada);
        return varResultado;
    }
    public int buscarPosHamburguesa(String idHamburguesa)    {
        int pos=-1;
        for(int i=0;i<this.colHamburguesas.size();i++)
        {
            if(this.colHamburguesas.get(i).getId().equals(idHamburguesa)) {pos=i;break;}
        }
        return pos;
    }

    public boolean modificarHamburguesa(String idHamburguesaModificar, ClsHamburguesaDTO newHamburguesa) {
        boolean varResultado=false;
        int posHamburguesa=this.buscarPosHamburguesa(idHamburguesaModificar);
        if(posHamburguesa!=-1)
        {
			    int posNewHamburguesa=this.buscarPosHamburguesa(newHamburguesa.getId());
				
				if(posNewHamburguesa==-1||idHamburguesaModificar.equals(newHamburguesa.getId()))
				{
					this.colHamburguesas.set(posHamburguesa,this.calcularPrecioHamburguesa(newHamburguesa));
					varResultado=true;	
				}	
		}
        return varResultado;
    }

    public boolean eliminarHamburguesa(String idHamburguesa) {
        boolean varResultado=false;
        int posHamburguesa=this.buscarPosHamburguesa(idHamburguesa);
        if(posHamburguesa!=-1)
        {
            this.colHamburguesas.remove(posHamburguesa);
            varResultado=true;
        }
        return varResultado;
    }

    public ArrayList<ClsHamburguesaDTO> listarHamburguesas() {
        return this.colHamburguesas;
    }

    public ClsFacturaDTO getFactura() {
		double costoSinIva=0;
		double costoIva;
		double costoTotal;
		int cantHamburguesas=this.colHamburguesas.size();
		int cantHamPequenia=0;
		int cantHamMediana=0;
		int cantHamGrande=0;
	
		for(ClsHamburguesaDTO hamActual :this.colHamburguesas)
		{
			costoSinIva+=hamActual.getPrecio();
			if(hamActual.getTipo().equals("Pequena")){cantHamPequenia+=1;}
			else if(hamActual.getTipo().equals("Mediana")){cantHamMediana+=1;}
			else{cantHamGrande+=1;}
		}
		if(cantHamburguesas>=1 && cantHamburguesas <=3){costoIva=costoSinIva*0.05;}
		else if(cantHamburguesas>=4 && cantHamburguesas <=7){costoIva=costoSinIva*0.08;}
		else if(cantHamburguesas>=8 && costoSinIva>=120000 ){costoIva=costoSinIva*0.18;}
		else {costoIva=costoSinIva*0.15;}
		costoTotal=costoIva+costoSinIva;
		ClsFacturaDTO factura=new ClsFacturaDTO(costoSinIva,costoIva,costoTotal,cantHamburguesas,cantHamPequenia,cantHamMediana,cantHamGrande);
		return factura;
	}
	
	public ClsHamburguesaDTO calcularPrecioHamburguesa(ClsHamburguesaDTO newHamburguesa)
	{
			empresaDAO datosEmpresa=new empresaDAO();
			ClsPreciosDTO precios = datosEmpresa.getPreciosHamburguesas();
			double precio;
			if(newHamburguesa.getTipo().equals("Pequena")){precio=precios.getPrecioHamPequenia();}
			else if(newHamburguesa.getTipo().equals("Mediana")){precio=precios.getPrecioHamMediana();}
			else{precio=precios.getPrecioHamGrandes();}
			newHamburguesa.setPrecio(precio+(newHamburguesa.getCantidadIngredientesExtra()*precios.getPrecioIngredienteExtra()));
			return newHamburguesa;
	}
    
}
