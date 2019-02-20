package sop_rmi;

import java.rmi.RemoteException;
import cliente.ClienteDeObjetosGUI;
import java.rmi.server.UnicastRemoteObject;
import sop_rmi.DTO.ClsHamburguesaDTO;
import java.util.ArrayList;

public class CallBackImpl extends UnicastRemoteObject implements CallBackInt
{
	private ClienteDeObjetosGUI GUI;
	public CallBackImpl(ClienteDeObjetosGUI GUI) throws RemoteException{
		super();
		this.GUI=GUI;
	}
	@Override
    public void notificarCompra(ArrayList<ClsHamburguesaDTO> hamburguesas) throws RemoteException {  	

        GUI.mostrarCompra(hamburguesas);
    }
}