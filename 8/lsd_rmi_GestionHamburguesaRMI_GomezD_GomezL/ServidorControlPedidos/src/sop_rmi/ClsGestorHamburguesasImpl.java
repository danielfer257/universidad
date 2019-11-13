
package sop_rmi;

import sop_rmi.DTO.*;
import servidor.ClsUsuario;
import sop_rmi.DAO.*;
import servidor.UtilidadesRegistroC;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ClsGestorHamburguesasImpl extends UnicastRemoteObject implements ClsGestorHamburguesasInt {

    private ArrayList<ClsUsuario>colUsuarios;
    private int cantUsuarios;
	private empresaDAO datosEmpresa;
	private facturaDAO datosFactura;
	private CallBackInt objRemotoCallBack;
	private ArrayList<ClsHamburguesaDTO> ultimaCompra;
	
	public ClsGestorHamburguesasImpl() throws RemoteException
	{
		super();
		objRemotoCallBack = (CallBackInt)UtilidadesRegistroC.obtenerObjRemoto(3030,"localhost","objRemotoCallBack");
		colUsuarios=new ArrayList<ClsUsuario>();
		datosEmpresa=new empresaDAO();
		datosFactura=new facturaDAO();
		cantUsuarios=0;
	}

    @Override
    public int registrarUsuario() throws RemoteException {
        System.out.println("Registrando usuario");
		cantUsuarios++;
        colUsuarios.add(new ClsUsuario(cantUsuarios));
        System.out.println("Se ha registrado el usuario con exito");
        return cantUsuarios;
    }

    @Override
    public ClsEmpresaDTO mostrarDatosEmpresa() throws RemoteException {
		System.out.println("MOSTRANDO DATOS DE EMPRESA");
		ClsEmpresaDTO varResultado =datosEmpresa.getDatosEmpresa();
		if(varResultado!=null){System.out.println("Se mostro con exito los datos de la empresa");}
		else{System.out.println("ERROR,no se pudo mostrar los datos de la empresa");}
        return varResultado;
    }

    @Override
    public ClsPreciosDTO mostrarPrecios() throws RemoteException {
		System.out.println("MOSTRANDO PRECIOS");
		ClsPreciosDTO varResultado =datosEmpresa.getPreciosHamburguesas();
		if(varResultado!=null){System.out.println("Se mostro con exito los precios de las hamburguesas");}
		else{System.out.println("ERROR,no se pudo mostrar los precios de las hamburguesas");}
        return varResultado;
    }

    @Override
    public boolean comprarHamburguesa(int idUsuario, ClsHamburguesaDTO newHamburguesa) throws RemoteException {
            System.out.println("COMPRANDO HAMBURGUESA");
            ClsUsuario usuarioActual=colUsuarios.get(idUsuario-1);
            boolean varResultado=usuarioActual.comprarHamburguesa(newHamburguesa);
            if(varResultado){
				System.out.println("El usuario "+idUsuario+" ha comprado la hamburguesa con exito");
				}
            else{System.out.println("ERROR,El usuario "+idUsuario+" no ha podido comprar la hamburguesa con exito");}
            return varResultado;
    }

    @Override
    public ClsHamburguesaDTO buscarHamburguesa(int idUsuario, String idHamburguesa) throws RemoteException {
             System.out.println("BUSCANDO HAMBURGUESA");
            ClsUsuario usuarioActual=colUsuarios.get(idUsuario-1);
            ClsHamburguesaDTO varResultado=usuarioActual.buscarHamburguesa(idHamburguesa);
            if(varResultado!=null){System.out.println("Se ha encontrado la hamburguesa "+idHamburguesa+" del usuario "+idUsuario+" con exito");}
            else{System.out.println("ERROR,No se ha podido encontrar la hamburguesa "+idHamburguesa+" del usuario "+idUsuario);}
            return varResultado;
    }

    @Override
    public boolean modificarHamburguesa(int idUsuario, String idHamburguesaModificar, ClsHamburguesaDTO newHamburguesa) throws RemoteException {
            System.out.println("MODIFICANDO HAMBURGUESA");
            ClsUsuario usuarioActual=colUsuarios.get(idUsuario-1);
            boolean varResultado=usuarioActual.modificarHamburguesa(idHamburguesaModificar,newHamburguesa);
            if(varResultado){System.out.println("Se ha modificado la hamburguesa "+idHamburguesaModificar+" del usuario "+idUsuario+" con exito");}
            else{System.out.println("ERROR,No se ha podido modificar la hamburguesa"+idHamburguesaModificar+" del usuario "+idUsuario);}
            return varResultado;
    }

    @Override
    public boolean EliminarHamburguesa(int idUsuario, String idHamburguesa) throws RemoteException {
            System.out.println("ELIMINANDO HAMBURGUESA");
            ClsUsuario usuarioActual=colUsuarios.get(idUsuario-1);
            boolean varResultado=usuarioActual.eliminarHamburguesa(idHamburguesa);
            if(varResultado){System.out.println("Se ha eliminado la hamburguesa "+idHamburguesa+" del usuario "+idUsuario+" con exito");}
            else{System.out.println("ERROR,La hamburguesa "+idHamburguesa+" no existe para el usuario "+idUsuario);}
            return varResultado;
    }

    @Override
    public ArrayList<ClsHamburguesaDTO> listarHamburguesas(int idUsuario) throws RemoteException {
             System.out.println("LISTANDO HAMBURGUESAS");
            ClsUsuario usuarioActual=colUsuarios.get(idUsuario-1);
            ArrayList<ClsHamburguesaDTO> varResultado=usuarioActual.listarHamburguesas();
            if(varResultado!=null){System.out.println("Se ha listado con exito para el usuario "+idUsuario);}
            else{System.out.println("No existe ninguna hamburguesa comprada para el usuario "+idUsuario);}
            return varResultado;
    }

    @Override
    public ClsFacturaDTO datosFactura(int idUsuario) throws RemoteException {
            System.out.println("GENERADO DATOS DE LA FACTURANDO");
            ClsUsuario usuarioActual=colUsuarios.get(idUsuario-1);
            ClsFacturaDTO varResultado=usuarioActual.getFactura();
            if(varResultado!=null){System.out.println("Se ha generado la factura para el usuario "+idUsuario+" con exito");}
            else{System.out.println("No existe ninguna hamburguesa comprada para el usaurio "+idUsuario);}
            return varResultado;
    }
    
    @Override
	public boolean generarFactura(int idUsuario,ClsFacturaDTO factura) throws RemoteException{	
		System.out.println("GENERADO FACTURA EN EL SERVIDOR");
		boolean varResultado=datosFactura.generarFactura(idUsuario,factura);
		if(varResultado)
		{
			ClsUsuario usuarioActual=colUsuarios.get(idUsuario-1);
			
			if(this.objRemotoCallBack!=null){
				this.objRemotoCallBack.notificarCompra(usuarioActual.listarHamburguesas());
			}
			else{ultimaCompra=usuarioActual.listarHamburguesas();}
			System.out.println("Se genero la factura exitosamente");
		} 
		else {System.out.println("ERROR,No se pudo generar la factura");}
		return varResultado;
	}

	@Override
	public void notificarAdminUp()throws RemoteException
	{
		System.out.println("NOTIFICACION!! EL ADMINISTRADOR DE FACTURAS HA INICIADO");
		objRemotoCallBack = (CallBackInt)UtilidadesRegistroC.obtenerObjRemoto(3030,"localhost","objRemotoCallBack");
		if(this.objRemotoCallBack!=null&&this.ultimaCompra!=null){
				this.objRemotoCallBack.notificarCompra(this.ultimaCompra);
				this.ultimaCompra=null;
			}
	}
	@Override
	public void notificarAdminDown()throws RemoteException
	{
		System.out.println("NOTIFICACION!! EL ADMINISTRADOR DE FACTURAS HA CERRADO");
		objRemotoCallBack = null;
	}
   
    
}
