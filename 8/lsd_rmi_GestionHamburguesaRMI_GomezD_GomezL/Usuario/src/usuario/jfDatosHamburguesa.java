package usuario;

import java.rmi.RemoteException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class jfDatosHamburguesa extends javax.swing.JFrame {
ClienteDeObjetos principal;
String varId;
ClsValidaciones validaciones;
    /**
     * Creates new form NewJFrame
     */
    public jfDatosHamburguesa(ClienteDeObjetos principal) {
        initComponents();
        this.principal=principal;
        this.setTitle("Comprando hamburguesa");
        this.setLocationRelativeTo(principal);
        
    }
     public jfDatosHamburguesa(ClienteDeObjetos principal,String id,String tipo,int cantIngredientes) {
        initComponents();
        varId=id;
        this.principal=principal;
        this.jTfId.setText(id);
        if(tipo.equals("mediano"))
        {this.jCbTipo.setSelectedIndex(1);}
        else if(tipo.equals("grande")){this.jCbTipo.setSelectedIndex(2); }
        this.jTfCantIngredientes.setText(Integer.toString(cantIngredientes));
        this.setTitle("Modificando hamburguesa");
        this.jbAceptar.setText("Modificar");
        this.setLocationRelativeTo(principal);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogValidaciones = new javax.swing.JDialog();
        jlValidacion = new javax.swing.JLabel();
        jbAceptar = new javax.swing.JButton();
        jlTipo = new javax.swing.JLabel();
        jlID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCbTipo = new javax.swing.JComboBox<>();
        jTfId = new javax.swing.JTextField();
        jTfCantIngredientes = new javax.swing.JTextField();
        jbCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jDialogValidaciones.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogValidaciones.setTitle("Error validaciones");
        jDialogValidaciones.setLocation(new java.awt.Point(300, 450));
        jDialogValidaciones.setSize(new java.awt.Dimension(320, 75));

        jlValidacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlValidacion.setText("*********************************");

        javax.swing.GroupLayout jDialogValidacionesLayout = new javax.swing.GroupLayout(jDialogValidaciones.getContentPane());
        jDialogValidaciones.getContentPane().setLayout(jDialogValidacionesLayout);
        jDialogValidacionesLayout.setHorizontalGroup(
            jDialogValidacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogValidacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlValidacion)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jDialogValidacionesLayout.setVerticalGroup(
            jDialogValidacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogValidacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlValidacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        jlTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlTipo.setText("Tipo:");

        jlID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlID.setText("ID:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cantidad de Ingredientes:");

        jCbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequena", "Mediana", "Grande" }));

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingrese los datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfCantIngredientes)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jbCancelar)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlID)
                        .addGap(18, 18, 18)
                        .addComponent(jTfId)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlID)
                    .addComponent(jTfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTipo)
                    .addComponent(jCbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTfCantIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAceptar)
                    .addComponent(jbCancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
       
    try {
        validaciones=new ClsValidaciones();
        if(validaciones.validarCampos(jTfId.getText(), jTfCantIngredientes.getText()))
         {
            if(validaciones.validarRango(jTfCantIngredientes.getText())){
               if(this.jbAceptar.getText().equals("Aceptar")){
                    principal.comprarHamburguesa(jTfId.getText(),jCbTipo.getItemAt(jCbTipo.getSelectedIndex()),jTfCantIngredientes.getText());     
                }
                else
                {           
                    principal.modificarHamburguesa(varId,jTfId.getText(),jCbTipo.getItemAt(jCbTipo.getSelectedIndex()),jTfCantIngredientes.getText());   
                }
                this.dispose();
            }
            else{
              
                   // jlValidacion.setLocation(500,500);
                this.jlValidacion.setText("La cantidad de ingredientes no puede ser negativo");this.jDialogValidaciones.setVisible(true);
                 this.jDialogValidaciones.setAlwaysOnTop(true); 
            }
         }
         else{ 
             //jlValidacion.setLocation(100,100);
            this.jlValidacion.setText("              No puede haber campos vacios");this.jDialogValidaciones.setVisible(true);     
            this.jDialogValidaciones.setAlwaysOnTop(true); 
        }
        
    } catch (RemoteException ex) {
        Logger.getLogger(jfDatosHamburguesa.class.getName()).log(Level.SEVERE, null, ex);
    }
  
       
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
    this.dispose();            // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCbTipo;
    private javax.swing.JDialog jDialogValidaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTfCantIngredientes;
    private javax.swing.JTextField jTfId;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlID;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JLabel jlValidacion;
    // End of variables declaration//GEN-END:variables
}
