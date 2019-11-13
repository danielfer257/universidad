/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sop_rmi.DTO;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
public class ClsEmpresaDTO implements Serializable {
    private String nit;
    private String nombre;


    public ClsEmpresaDTO(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
    }
    
    public String getNit() {
        return nit;
    }
    public String getNombre() {
        return nombre;
    }

    
  
    
    
}
