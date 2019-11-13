package sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import sop_rmi.DTO.ClsHamburguesaDTO;
import java.util.ArrayList;

public  interface CallBackInt extends Remote{
	public void notificarCompra(ArrayList<ClsHamburguesaDTO> hamburguesas)throws RemoteException;
}