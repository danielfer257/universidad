package usuario;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import usuario.jfDatosHamburguesa;
import javax.swing.JFrame;
import sop_rmi.ClsGestorHamburguesasInt;
import sop_rmi.DTO.*;

public class ClienteDeObjetos extends javax.swing.JFrame {

    
    private static ClsGestorHamburguesasInt objRemoto;
    private static int idUsuario;
    private String idHamburguesa;
        
    public ClienteDeObjetos(ClsGestorHamburguesasInt objRemoto) throws RemoteException {    
       this.objRemoto =objRemoto; 
       idUsuario=objRemoto.registrarUsuario();
       initComponents();  
       this.setVisible(true);
    }
    
    public void comprarHamburguesa(String idHamburguesa,String tipo,String cantIngredientes) throws RemoteException
    {     
        if(objRemoto.comprarHamburguesa(idUsuario, new ClsHamburguesaDTO(idHamburguesa,tipo,Integer.parseInt(cantIngredientes)))) this.jTextArea1.setText("Se ha comprado la hamburguesa con exito");
                                              else{this.jTextArea1.setText("La hamburguesa con el id registrado ya existe");}
    }
    public void modificarHamburguesa(String idHamburguesa) throws RemoteException
    {
        ClsHamburguesaDTO hamModificar=this.mostrarHamburguesa(idHamburguesa);
        if(hamModificar!=null)
        {
            jfDatosHamburguesa modificar=new jfDatosHamburguesa(this,hamModificar.getId(),hamModificar.getTipo(),hamModificar.getCantidadIngredientesExtra());
            modificar.setVisible(true);
        }
    }
    public void modificarHamburguesa(String idModificar,String newIdHamburguesa,String newTipo,String newCantIngredientes) throws RemoteException
    {        
        if(objRemoto.modificarHamburguesa(idUsuario,idModificar,new ClsHamburguesaDTO(newIdHamburguesa,newTipo,Integer.parseInt(newCantIngredientes)))) this.jTextArea1.setText("Se ha modificado la hamburguesa con exito");
        else{this.jTextArea1.setText("La hamburguesa con el id registrado ya existe");}
    }
    public ClsHamburguesaDTO mostrarHamburguesa(String id) throws RemoteException
    {
        ClsHamburguesaDTO hamBuscada=objRemoto.buscarHamburguesa(idUsuario,id);
           if(hamBuscada!=null)
               {
                   this.jTextArea1.setText("Datos de la hamburguesa\n");        
                   this.jTextArea1.append("\nId hamburguesa:"+hamBuscada.getId());
                   this.jTextArea1.append("\nTipo:"+hamBuscada.getTipo());
                   this.jTextArea1.append("\nCantidad de ingredientes extra:"+hamBuscada.getCantidadIngredientesExtra());
                   this.jTextArea1.append("\nPrecio:"+hamBuscada.getPrecio());                                                
               }
           else{this.jTextArea1.setText("La hamburguesa con el id "+id+" no existe");}
        return hamBuscada;
    }
    public void eliminarHamburguesa(String id) throws RemoteException
    {
        ClsHamburguesaDTO hamEliminar=this.mostrarHamburguesa(id);
        if(hamEliminar!=null)
        {
            this.jDialogVerificacion.setVisible(true);
            this.jDialogVerificacion.setAlwaysOnTop(true);
            this.jDialogVerificacion.setLocationRelativeTo(this);
            idHamburguesa=id;
        }      
    }
    public void generarFactura(String opcion,ClsFacturaDTO factura) throws RemoteException
    {
        if(!opcion.equals("Retornar al menú principal"))
        {
            factura.setMedioDePago(opcion);
            this.objRemoto.generarFactura(idUsuario, factura);
            this.jTextArea1.setText("Se ha generado la factura con exito");
        }
        else
        {
            this.jTextArea1.setText("Se ha cancelado la factura");
        }
        
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogVerificacion = new javax.swing.JDialog();
        jlVerificacion = new javax.swing.JLabel();
        jbVerificacionEliminar = new javax.swing.JButton();
        jbVerificacionC = new javax.swing.JButton();
        jbMostrarDatos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbComprar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbListar = new javax.swing.JButton();
        jbFactura = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jDialogVerificacion.setTitle("Verificacion");
        jDialogVerificacion.setMinimumSize(new java.awt.Dimension(230, 20));
        jDialogVerificacion.setPreferredSize(new java.awt.Dimension(230, 20));
        jDialogVerificacion.setSize(new java.awt.Dimension(300, 100));

        jlVerificacion.setText("Esta seguro que desea eliminar la hamburguesa");

        jbVerificacionEliminar.setText("Aceptar");
        jbVerificacionEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerificacionEliminarActionPerformed(evt);
            }
        });

        jbVerificacionC.setText("Cancelar");
        jbVerificacionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerificacionCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogVerificacionLayout = new javax.swing.GroupLayout(jDialogVerificacion.getContentPane());
        jDialogVerificacion.getContentPane().setLayout(jDialogVerificacionLayout);
        jDialogVerificacionLayout.setHorizontalGroup(
            jDialogVerificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogVerificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogVerificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogVerificacionLayout.createSequentialGroup()
                        .addComponent(jlVerificacion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDialogVerificacionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbVerificacionEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbVerificacionC)
                        .addGap(34, 34, 34))))
        );
        jDialogVerificacionLayout.setVerticalGroup(
            jDialogVerificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogVerificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlVerificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogVerificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVerificacionEliminar)
                    .addComponent(jbVerificacionC))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HAMBURGESERIA GOMEZ");
        setLocation(new java.awt.Point(500, 500));
        setLocationByPlatform(true);

        jbMostrarDatos.setText("Mostrar datos de la empresa");
        jbMostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarDatosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("Menu de pedidos");

        jbComprar.setText("Comprar Hamburguesa");
        jbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar compra de hamburguesa");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar hamburguesa del pedido");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbListar.setText("Listar hamburguesas pedidas");
        jbListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarActionPerformed(evt);
            }
        });

        jbFactura.setText("Mostrar factura y pagar pedido");
        jbFactura.setFocusPainted(false);
        jbFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFacturaActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbFactura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbListar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbMostrarDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbComprar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbMostrarDatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbComprar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbModificar)
                        .addGap(15, 15, 15)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbFactura)
                        .addGap(0, 351, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarDatosActionPerformed
        try {
            ClsEmpresaDTO datosEmpresa=objRemoto.mostrarDatosEmpresa();
            this.jTextArea1.setText("El nombre de la empresa es:\n"+datosEmpresa.getNombre()+"\nEl nit es:\n"+datosEmpresa.getNit());
            ClsPreciosDTO precios=objRemoto.mostrarPrecios();
            jTextArea1.append("\nEl precio de la hamburguesa pequena es:\n"+precios.getPrecioHamPequenia());
            jTextArea1.append("\nEl precio de la hamburguesa medina es:\n"+precios.getPrecioHamMediana());
            jTextArea1.append("\nEl precio de la hamburguesa grande es:\n"+precios.getPrecioHamGrandes());
            jTextArea1.append("\nEl precio de cada ingrediente extra es:\n"+precios.getPrecioIngredienteExtra());
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteDeObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbMostrarDatosActionPerformed

    private void jbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarActionPerformed
         jfDatosHamburguesa compra=new jfDatosHamburguesa(this);
         compra.setVisible(true);
    }//GEN-LAST:event_jbComprarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        jfIngresarID modificar=new jfIngresarID(this,"Modificando Hamburguesa");
        modificar.setVisible(true);   
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        jfIngresarID eliminar=new jfIngresarID(this,"Eliminando Hamburguesa");
        eliminar.setVisible(true);
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarActionPerformed
        ArrayList<ClsHamburguesaDTO> colHamburguesas;
        try 
        {
            colHamburguesas = objRemoto.listarHamburguesas(idUsuario);
            if(colHamburguesas.size()>0)
            {
                int cont=1;
                this.jTextArea1.setText("Listado de hamburguesas compradas\n");
                for(ClsHamburguesaDTO hamActual:colHamburguesas)
                {
                    this.jTextArea1.append("\nHamburguesa no:"+cont);
                    this.jTextArea1.append("\nIdentificador:"+hamActual.getId());
                    this.jTextArea1.append("\nTipo:"+hamActual.getTipo());
                    this.jTextArea1.append("\nCantidad de ingredientes extra:"+hamActual.getCantidadIngredientesExtra());
                    this.jTextArea1.append("\nCosto:$"+hamActual.getPrecio()+"\n");	
                    cont++;
                }
                ClsFacturaDTO factura=objRemoto.datosFactura(idUsuario);
                this.jTextArea1.append("\nCosto con iva del pedido:$"+factura.getCostoTotal());
            }
            else{this.jTextArea1.setText("No existen hamburguesas registradas");}
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteDeObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_jbListarActionPerformed

    private void jbFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFacturaActionPerformed
        ArrayList<ClsHamburguesaDTO> colHamburguesas;       
        try 
        {
            colHamburguesas = objRemoto.listarHamburguesas(idUsuario);
            if(colHamburguesas.size()>0)
            {
                int cont=1;
                this.jTextArea1.setText("Factura de venta\n");
                for(ClsHamburguesaDTO hamActual:colHamburguesas)
                {
                    this.jTextArea1.append("\nHamburguesa no:"+cont);
                    this.jTextArea1.append("\nTipo:"+hamActual.getTipo());
                    this.jTextArea1.append("\nCantidad de ingredientes extra:"+hamActual.getCantidadIngredientesExtra());
                    this.jTextArea1.append("\nCosto:$"+hamActual.getPrecio()+"\n");	
                    cont++;
                }
                ClsFacturaDTO factura=objRemoto.datosFactura(idUsuario);
                this.jTextArea1.append("\nHamburguesas de tipo pequeno:"+factura.getCantHamPequenia());
                this.jTextArea1.append("\nHamburguesas de tipo mediano:"+factura.getCantHamMediana());
                this.jTextArea1.append("\nHamburguesas de tipo grande:"+factura.getCantHamGrande()+"\n");
                this.jTextArea1.append("\nCosto sin iva del pedido:$"+factura.getCostoSinIva());
                this.jTextArea1.append("\niva del pedido:$"+factura.getCostoIva());
                this.jTextArea1.append("\nCosto con iva del pedido:$"+factura.getCostoTotal());     
             
                jfPagar pagarFactura=new jfPagar(this,factura);
                pagarFactura.setVisible(true);
            }
            else{this.jTextArea1.setText("No existen hamburguesas registradas");}
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteDeObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jbFacturaActionPerformed

    private void jbVerificacionEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerificacionEliminarActionPerformed
        try {
            objRemoto.EliminarHamburguesa(idUsuario, this.idHamburguesa);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteDeObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.jTextArea1.setText("Se ha eliminado la hamburguesa con exito");
        this.jDialogVerificacion.setVisible(false); 
    }//GEN-LAST:event_jbVerificacionEliminarActionPerformed

    private void jbVerificacionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerificacionCActionPerformed
        this.jTextArea1.setText("Se ha cancelado la eliminacion");
        this.jDialogVerificacion.setVisible(false);
    }//GEN-LAST:event_jbVerificacionCActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialogVerificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbComprar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbFactura;
    private javax.swing.JButton jbListar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbMostrarDatos;
    private javax.swing.JButton jbVerificacionC;
    private javax.swing.JButton jbVerificacionEliminar;
    private javax.swing.JLabel jlVerificacion;
    // End of variables declaration//GEN-END:variables
}
