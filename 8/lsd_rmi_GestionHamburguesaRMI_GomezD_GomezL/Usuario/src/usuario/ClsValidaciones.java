/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

public class ClsValidaciones {
    
    public boolean validarCampos(String id, String cantIngredientes)
    {
        boolean varResultado=false;  
        if(!id.equals("")&&!cantIngredientes.equals("")){varResultado=true;}
        return varResultado;
    }
    public boolean validarRango(String cantIntgredientes )
    {
      boolean varResultado=false;
        int cantIng=Integer.parseInt(cantIntgredientes);
        if(cantIng>=0){varResultado=true;}
      return varResultado;
    }
            
}
