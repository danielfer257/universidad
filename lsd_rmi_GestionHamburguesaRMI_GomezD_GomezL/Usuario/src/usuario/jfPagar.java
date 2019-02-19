/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
import sop_rmi.DTO.ClsFacturaDTO;

/**
 *
 * @author daniel
 */
public class jfPagar extends javax.swing.JFrame {

    /**
     * Creates new form jfPagar
     */
    ClienteDeObjetos principal;
    ClsFacturaDTO factura;
    public jfPagar(ClienteDeObjetos principal,ClsFacturaDTO factura) {
        initComponents();
        this.principal=principal;
        this.factura=factura;
        this.setLocationRelativeTo(principal);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRbEfectivo = new javax.swing.JRadioButton();
        jRbTarjetaCredito = new javax.swing.JRadioButton();
        jRbPagoLinea = new javax.swing.JRadioButton();
        jRbRetornar = new javax.swing.JRadioButton();
        jlMedioPago = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medio de pago");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jRbEfectivo.setText("Efectivo");
        jRbEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbEfectivoActionPerformed(evt);
            }
        });

        jRbTarjetaCredito.setText("Tarjeta de crédito");
        jRbTarjetaCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRbTarjetaCreditoMouseClicked(evt);
            }
        });

        jRbPagoLinea.setText("Pago en línea");
        jRbPagoLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbPagoLineaActionPerformed(evt);
            }
        });

        jRbRetornar.setText("Retornar al menú principal");
        jRbRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbRetornarActionPerformed(evt);
            }
        });

        jlMedioPago.setText("Seleccione un medio de pago");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRbRetornar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRbPagoLinea)
                    .addComponent(jRbTarjetaCredito)
                    .addComponent(jRbEfectivo)
                    .addComponent(jlMedioPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlMedioPago, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRbEfectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRbTarjetaCredito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRbPagoLinea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRbRetornar)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       
    }//GEN-LAST:event_formMouseClicked

    private void jRbTarjetaCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRbTarjetaCreditoMouseClicked
      if(this.jRbTarjetaCredito.isSelected())
        {        
            this.dispose();
            try {
                this.principal.generarFactura(jRbTarjetaCredito.getText(),factura);
            } catch (RemoteException ex) {
                Logger.getLogger(jfPagar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_jRbTarjetaCreditoMouseClicked

 
    private void jRbEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbEfectivoActionPerformed
        if(this.jRbEfectivo.isSelected())
        {        
            this.dispose();
            try {
                this.principal.generarFactura(jRbEfectivo.getText(),factura);
            } catch (RemoteException ex) {
                Logger.getLogger(jfPagar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_jRbEfectivoActionPerformed

    private void jRbPagoLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbPagoLineaActionPerformed
        if(this.jRbPagoLinea.isSelected())
        {        
            this.dispose();
            try {
                this.principal.generarFactura(jRbPagoLinea.getText(),factura);
            } catch (RemoteException ex) {
                Logger.getLogger(jfPagar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_jRbPagoLineaActionPerformed

    private void jRbRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbRetornarActionPerformed
         if(this.jRbRetornar.isSelected())
        {        
            this.dispose();
            try {
                this.principal.generarFactura(jRbRetornar.getText(),factura);
            } catch (RemoteException ex) {
                Logger.getLogger(jfPagar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_jRbRetornarActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton jRbEfectivo;
    private javax.swing.JRadioButton jRbPagoLinea;
    private javax.swing.JRadioButton jRbRetornar;
    private javax.swing.JRadioButton jRbTarjetaCredito;
    private javax.swing.JLabel jlMedioPago;
    // End of variables declaration//GEN-END:variables
}
