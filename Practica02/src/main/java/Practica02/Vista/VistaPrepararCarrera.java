package Practica02.Vista;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class VistaPrepararCarrera extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaPrepararCarrera.class.getName());

    public VistaPrepararCarrera() {
        initComponents();
    }
    
    public void llennarCombo(String[] corredor){
        ComboJugadores.removeAllItems();
        
        for (String nombre : corredor) {
            ComboJugadores.addItem(nombre);
        }
    }
    

    public JButton getBotonJugar() {
        return BotonJugar;
    }

    public JButton getBotonSalir() {
        return BotonSalir;
    }

    public String getJugadorSeleccionad() {
        return (String) ComboJugadores.getSelectedItem();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ComboJugadores = new javax.swing.JComboBox<>();
        BotonSalir = new javax.swing.JButton();
        BotonJugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Z003", 0, 30)); // NOI18N
        jLabel1.setText("Escoje a tu jugador");

        ComboJugadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboJugadores.addActionListener(this::ComboJugadoresActionPerformed);

        BotonSalir.setBackground(new java.awt.Color(102, 102, 0));
        BotonSalir.setFont(new java.awt.Font("Z003", 0, 24)); // NOI18N
        BotonSalir.setText("Regresar");
        BotonSalir.addActionListener(this::BotonSalirActionPerformed);

        BotonJugar.setBackground(new java.awt.Color(102, 102, 0));
        BotonJugar.setFont(new java.awt.Font("Z003", 0, 24)); // NOI18N
        BotonJugar.setText("Jugar");
        BotonJugar.addActionListener(this::BotonJugarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonSalir)
                        .addGap(18, 18, 18)
                        .addComponent(BotonJugar)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(ComboJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonSalir)
                    .addComponent(BotonJugar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboJugadoresActionPerformed
        
    }//GEN-LAST:event_ComboJugadoresActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void BotonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonJugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonJugarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VistaPrepararCarrera().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonJugar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JComboBox<String> ComboJugadores;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
