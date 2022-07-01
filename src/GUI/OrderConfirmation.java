/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Helper.Cart;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OrderConfirmation extends javax.swing.JFrame {

    public OrderConfirmation() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // Variables declaration - do not modify//GEN-BEGIN:variables
        JPanel backgroundcolor = new JPanel();
        JLabel thankyouPanel = new JLabel();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundcolor.setBackground(new java.awt.Color(231, 246, 255));

        thankyouPanel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
        thankyouPanel.setText("Thank you.Your order was succesful ");

        jButton1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); // NOI18N
        jButton1.setText("Go to mainpage");
        jButton1.addActionListener(actionEvent -> {
            dispose();
            Mainpage main = null;
            try {
                main = new Mainpage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            main.setVisible(true);
        });

        jButton2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); // NOI18N
        jButton2.setText("Logout");
        jButton2.addActionListener(actionEvent -> {
            dispose();
            Login login = null;
            try {
                login = new Login("Bookstore application");
            } catch (IOException e) {
                e.printStackTrace();
            }
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            Cart.user = null;
        });


        javax.swing.GroupLayout BackgroundcolorLayout = new javax.swing.GroupLayout(backgroundcolor);
        backgroundcolor.setLayout(BackgroundcolorLayout);
        BackgroundcolorLayout.setHorizontalGroup(
                BackgroundcolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BackgroundcolorLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(thankyouPanel)
                                .addContainerGap(43, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundcolorLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(BackgroundcolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        BackgroundcolorLayout.setVerticalGroup(
                BackgroundcolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BackgroundcolorLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(thankyouPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundcolor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundcolor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new OrderConfirmation().setVisible(true));
    }

    // End of variables declaration//GEN-END:variables
}
