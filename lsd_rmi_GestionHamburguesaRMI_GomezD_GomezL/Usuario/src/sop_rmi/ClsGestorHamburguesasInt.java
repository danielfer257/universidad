package sop_rmi;

import sop_rmi.DTO.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ClsGestorHamburguesasInt extends Remote 
{
    public int registrarUsuario() throws RemoteException;
    public ClsEmpresaDTO mostrarDatosEmpresa() throws RemoteException;
    public ClsPreciosDTO mostrarPrecios() throws RemoteException;
    public boolean comprarHamburguesa(int idUsuario, ClsHamburguesaDTO newHamburguesa) throws RemoteException;
    public ClsHamburguesaDTO buscarHamburguesa(int idUsuario,String idHamburguesa) throws RemoteException;
    public boolean modificarHamburguesa(int idUsuario,String idHamburguesaModificar,ClsHamburguesaDTO newHamburguesa) throws RemoteException;
    public boolean EliminarHamburguesa(int idUsuario,String idHamburguesa) throws RemoteException;
    public ArrayList<ClsHamburguesaDTO> listarHamburguesas(int idUsuario) throws RemoteException; 
    public ClsFacturaDTO datosFactura(int idUsuario) throws RemoteException; 
    public boolean generarFactura(int idUsuario,ClsFacturaDTO factura) throws RemoteException;
	public void notificarAdminUp()throws RemoteException;
}
