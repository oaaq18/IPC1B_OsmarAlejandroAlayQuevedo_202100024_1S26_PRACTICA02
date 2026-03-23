/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Practica02.Vista;

/**
 *
 * @author alejandro
 */
public class VistaAgregarJugador extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaAgregarJugador.class.getName());

    
    public VistaAgregarJugador() {
        initComponents();
        llenarCombos();
    }
    private void llenarCombos() {
    // Limpiar los items
    ComboBoxEscoba.removeAllItems();
    ComboBoxCasa.removeAllItems();

    // Llenar escobas
    ComboBoxEscoba.addItem("Nimbus 2000");
    ComboBoxEscoba.addItem("Nimbus 2001");
    ComboBoxEscoba.addItem("Saeta de Fuego");

    // Llenar casas
    ComboBoxCasa.addItem("Gryffindor");
    ComboBoxCasa.addItem("Slytherin");
    ComboBoxCasa.addItem("Hufflepuff");
    ComboBoxCasa.addItem("Ravenclaw");
    }
    
    // Getters para que el controlador lea los valores
    public String getNombre() {
        return TextoNombre.getText().trim();
    }

    public String getEscoba() {
        return (String) ComboBoxEscoba.getSelectedItem();
    }

    public String getCasa() {
        return (String) ComboBoxCasa.getSelectedItem();
    }

    public void mostrarMensaje(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        TextoNombre.setText("");
        ComboBoxEscoba.setSelectedIndex(0);
        ComboBoxCasa.setSelectedIndex(0);
    }

    public javax.swing.JButton getBotonAgregar() {
        return BotonAgregar;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextoNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ComboBoxEscoba = new javax.swing.JComboBox<>();
        ComboBoxCasa = new javax.swing.JComboBox<>();
        BotonSalir = new javax.swing.JButton();
        BotonAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Z003", 0, 36)); // NOI18N
        jLabel1.setText("Agregar Jugador");

        jLabel2.setFont(new java.awt.Font("Z003", 0, 24)); // NOI18N
        jLabel2.setText("Casa");

        jLabel5.setFont(new java.awt.Font("Z003", 0, 24)); // NOI18N
        jLabel5.setText("Nombre");

        jLabel6.setFont(new java.awt.Font("Z003", 0, 24)); // NOI18N
        jLabel6.setText("Escoba");

        ComboBoxEscoba.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxEscoba.addActionListener(this::ComboBoxEscobaActionPerformed);

        ComboBoxCasa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxCasa.addActionListener(this::ComboBoxCasaActionPerformed);

        BotonSalir.setFont(new java.awt.Font("Z003", 0, 24)); // NOI18N
        BotonSalir.setText("Salir/Cancelar");
        BotonSalir.setAlignmentX(0.5F);
        BotonSalir.addActionListener(this::BotonSalirActionPerformed);

        BotonAgregar.setFont(new java.awt.Font("Z003", 0, 24)); // NOI18N
        BotonAgregar.setText("Agregar");
        BotonAgregar.setAlignmentX(0.5F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(ComboBoxEscoba, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBoxCasa, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotonSalir)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(254, Short.MAX_VALUE)
                    .addComponent(BotonAgregar)
                    .addGap(41, 41, 41)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ComboBoxEscoba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(ComboBoxCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BotonSalir)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(222, Short.MAX_VALUE)
                    .addComponent(BotonAgregar)
                    .addGap(40, 40, 40)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //boton de salir
    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void ComboBoxEscobaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxEscobaActionPerformed
        
    }//GEN-LAST:event_ComboBoxEscobaActionPerformed

    private void ComboBoxCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxCasaActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new VistaAgregarJugador().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JComboBox<String> ComboBoxCasa;
    private javax.swing.JComboBox<String> ComboBoxEscoba;
    private javax.swing.JTextField TextoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
