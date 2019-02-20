/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import sop_rmi.ClsGestorHamburguesasImpl;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//import sop_rmi.ClsGestorHamburguesasImpl;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {
                 
        
      	String direccionIpRMIRegistry =  args[0]; 
        int numPuertoRMIRegistry = Integer.parseInt(args[1]); 
     
        ClsGestorHamburguesasImpl objRemoto = new ClsGestorHamburguesasImpl();        
        
        try
        {
                    
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto,direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoUsuarios");           
      
	    } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
        
        
    }
}
