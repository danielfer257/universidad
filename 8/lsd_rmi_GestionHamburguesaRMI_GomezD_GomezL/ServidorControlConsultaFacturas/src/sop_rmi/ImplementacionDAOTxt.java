package sop_rmi;

import java.util.ArrayList;

import java.io.*;
import java.io.File;

public class ImplementacionDAOTxt
{
	public int cantArchivos(){
	return this.getArchivos().length;
	}
	public double costoTotalCompras()
	{
		File[] archivos=this.getArchivos();
		double costoTotalCompras=0;
		String linea,ultima="";	
			for(int i=0; i<archivos.length; i++) 
			{
					if(archivos[i].getName().startsWith("Factura"))
					{
							try
							{
								BufferedReader br = new BufferedReader(new FileReader("../../ServidorControlPedidos/bin/facturas/"+archivos[i].getName())); 			
								while ((linea = br.readLine()) != null){ultima = linea;}	   
							   String [] palabra=ultima.split(":");              
							   costoTotalCompras+=Double.parseDouble(palabra[1]);
							    br.close();
							}
							catch(Exception e){ e.printStackTrace();}	
					}
			}
		return costoTotalCompras;		
	}     
	public File[] getArchivos()
	{
		File carpeta = new File("../../ServidorControlPedidos/bin/facturas");
		File[] archivos=null;
		if(carpeta.exists()) 
		{
			if(carpeta.isDirectory()) {archivos = carpeta.listFiles();}
		}
		return archivos;
	}	
}