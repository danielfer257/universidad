
package sop_rmi;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ClsGestorFacturasInt extends Remote 
{
    public int facturasRegistradas() throws RemoteException;
    public double costoTotalCompras() throws RemoteException;
}
