package sop_rmi.DAO;
import sop_rmi.DTO.ClsEmpresaDTO;
import sop_rmi.DTO.ClsPreciosDTO;
import java.io.*;

public class empresaDAO
{
	public ClsEmpresaDTO getDatosEmpresa(){
		ClsEmpresaDTO empresa =null;
		try
        {
			BufferedReader b = new BufferedReader(new FileReader("./datos/datosEmpresa.txt"));
			empresa = new ClsEmpresaDTO(b.readLine(),b.readLine());
			b.close();
		}
		catch(Exception e){
         e.printStackTrace();
		}
		finally {
		  return empresa;
		}
}

	public ClsPreciosDTO getPreciosHamburguesas(){
		ClsPreciosDTO precios=null;
		try
        {
			BufferedReader b = new BufferedReader(new FileReader("./datos/datosHamburguesa.txt"));
			double pHamPequena=Double.parseDouble(b.readLine());
			double pHamMediana=Double.parseDouble(b.readLine());
			double pHamGrande=Double.parseDouble(b.readLine());
			double pIngredientesExtra=Double.parseDouble(b.readLine());
		
			precios= new ClsPreciosDTO(pHamPequena,pHamMediana,pHamGrande,pIngredientesExtra);
			b.close();
		}
		catch(Exception e){
         e.printStackTrace();
		}finally {
		  return precios;
		}

	}
}