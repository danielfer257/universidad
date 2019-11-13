package cliente;
import sop_rmi.ClsGestorFacturasInt;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sop_rmi.CallBackImpl;
import sop_rmi.ClsGestorHamburguesasInt;
import sop_rmi.DTO.ClsHamburguesaDTO;
public class ClienteDeObjetosGUI extends javax.swing.JFrame {

    private static ClsGestorFacturasInt objRemotoFacturas;
    private  ClsGestorHamburguesasInt objRemotoUsuario;
    private static int idUsuario;
    
    public ClienteDeObjetosGUI() throws RemoteException { 
        initComponents();
		this.setVisible(true);
        objRemotoFacturas = (ClsGestorFacturasInt)UtilidadesRegistroC.obtenerObjRemoto(2020,"localhost","objRemotoFacturas"); 
        CallBackImpl objRemotoCallBack= new CallBackImpl(this);
        UtilidadesRegistroS.arrancarNS(3030);
        UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoCallBack,"localhost",3030,"objRemotoCallBack");
        this.admiUp();
        
         
    }
  
    public void mostrarCompra(ArrayList<ClsHamburguesaDTO> hamburguesas)throws RemoteException
    {
   
        this.jTextArea1.setText("SE HA NOTIFICADO UNA NUEVA\n COMPRA DE HAMBURGUESAS\n");
        for(ClsHamburguesaDTO hamburguesa:hamburguesas)
        {
            this.jTextArea1.append("Id hamburguesa:"+hamburguesa.getId()+"\n"); 
        }
    }
    public void admiUp() throws RemoteException
    {
        
        objRemotoUsuario= (ClsGestorHamburguesasInt)UtilidadesRegistroC.obtenerObjRemoto(1010,"localhost","ObjetoRemotoUsuarios");
         if(objRemotoUsuario!=null){objRemotoUsuario.notificarAdminUp();}
    } 
           
    
           
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbFacturasRegistradas = new javax.swing.JButton();
        jbCostoCompras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jbFacturasRegistradas.setText("Facturas Registradas");
        jbFacturasRegistradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFacturasRegistradasActionPerformed(evt);
            }
        });

        jbCostoCompras.setText("Costo total de compras");
        jbCostoCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCostoComprasActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("MENU DE PEDIDOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbCostoCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbFacturasRegistradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jbFacturasRegistradas)
                        .addGap(18, 18, 18)
                        .addComponent(jbCostoCompras))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public static void main(String args[]) throws RemoteException {
        new ClienteDeObjetosGUI();
    }
    private void jbFacturasRegistradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFacturasRegistradasActionPerformed
        try {
            int cantFacturas=objRemotoFacturas.facturasRegistradas();
            if(cantFacturas>0)
            {
                this.jTextArea1.setText("El total de facturas registradas es de:"+cantFacturas);
            }
            else{this.jTextArea1.setText("No existen facturas registradas");}
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteDeObjetosGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbFacturasRegistradasActionPerformed

    private void jbCostoComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCostoComprasActionPerformed
        try {
            double costoCompras=objRemotoFacturas.costoTotalCompras();
             if(costoCompras>0)
            {
                this.jTextArea1.setText("El costo total de las compras es de:\n"+costoCompras);
            }
            else{this.jTextArea1.setText("No existen facturas registradas");}
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteDeObjetosGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbCostoComprasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            objRemotoUsuario.notificarAdminDown();
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteDeObjetosGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbCostoCompras;
    private javax.swing.JButton jbFacturasRegistradas;
    // End of variables declaration//GEN-END:variables
}
