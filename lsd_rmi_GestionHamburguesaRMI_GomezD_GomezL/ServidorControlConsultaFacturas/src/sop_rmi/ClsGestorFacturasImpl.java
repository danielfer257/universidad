
package sop_rmi;

import sop_rmi.ImplementacionDAOTxt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.File;


public class ClsGestorFacturasImpl extends UnicastRemoteObject implements ClsGestorFacturasInt {

  
	private ImplementacionDAOTxt dbFichero;
	
	public ClsGestorFacturasImpl() throws RemoteException
	{
		super();
		dbFichero=new ImplementacionDAOTxt();
	}

    @Override
    public int facturasRegistradas() throws RemoteException {
		 System.out.println("FACTURAS REGISTRADAS");
         int cantArchivos=dbFichero.cantArchivos();
		 if(cantArchivos!=0){System.out.println("Se ha realizado el procedimiento con exito");}
		 else{System.out.println("No existen facturas Registradas");}
		 return cantArchivos;
    }

    @Override
    public double costoTotalCompras() throws RemoteException {
		System.out.println("COSTO TOTAL DE COMPRAS");
        double costoTotalCompras=dbFichero.costoTotalCompras();
		if(costoTotalCompras!=0){System.out.println("Se ha realizado el procedimiento con exito");}
		else{System.out.println("No existen facturas Registradas");}
		return costoTotalCompras;   
    }
	
  
}
