package sop_rmi.DAO;

import java.io.*;
import sop_rmi.DTO.ClsFacturaDTO;

public class facturaDAO{
	
	public boolean generarFactura(int idCliente,ClsFacturaDTO factura)	{
		boolean varResultado=false;
		try
        {
			BufferedWriter bw = new BufferedWriter(new FileWriter("./facturas/Factura"+Integer.toString(idCliente)+".txt"));
			bw.write("Cantidad de hamburguesas compradas:"+String.valueOf(factura.getCantHamburguesas())+"\r\n");
			bw.write("Cantidad de hamburguesas pequenas:"+String.valueOf(factura.getCantHamPequenia())+"\r\n");
			bw.write("Cantidad de hamburguesas medianas:"+String.valueOf(factura.getCantHamMediana())+"\r\n");
			bw.write("Cantidad de hamburguesas grandes:"+String.valueOf(factura.getCantHamGrande())+"\r\n");
			bw.write("Medio de pago:"+factura.getMedioDePago()+"\r\n");
            bw.write("Costo sin iva:"+String.valueOf(factura.getCostoSinIva())+"\r\n");
			bw.write("Costo del iva:"+String.valueOf(factura.getCostoIva())+"\r\n");
			bw.write("Costo total:"+String.valueOf(factura.getCostoTotal())+"\r\n");
			
			bw.close();
			varResultado=true;
		}
		catch(Exception e){
         e.printStackTrace();
		}
		finally {
		  return varResultado;
		}
	}
}