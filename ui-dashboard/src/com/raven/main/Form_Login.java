/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.main;

import com.raven.connection.koneksi;
import com.raven.model.Model_Login;
import com.raven.service.Service_Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Zeidr
 */
public class Form_Login extends javax.swing.JFrame {
    
    private Connection conn;
    /**
     * Creates new form NewJFrame
     */
    public Form_Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jTextFieldUsername = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelLogin.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldUsername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUsername.setText("Username");
        jTextFieldUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jTextFieldUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusLost(evt);
            }
        });
        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });

        jTextFieldPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldPassword.setForeground(new java.awt.Color(102, 102, 255));
        jTextFieldPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPassword.setText("Password");
        jTextFieldPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jTextFieldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPasswordFocusLost(evt);
            }
        });

        jButtonLogin.setBackground(new java.awt.Color(102, 102, 255));
        jButtonLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonLogin.setText("LOGIN");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Masukan Username dan Password");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/logo.png"))); // NOI18N
        jLabel2.setText("Pocket Billiard");

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jTextFieldUsername)
                            .addComponent(jTextFieldPassword)))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusGained
        // TODO add your handling code here:
        String username = jTextFieldUsername.getText();
        if (username.equals("Username")) {
            jTextFieldUsername.setText("");
        }
    }//GEN-LAST:event_jTextFieldUsernameFocusGained

    private void jTextFieldUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusLost
        // TODO add your handling code here:
        String username = jTextFieldUsername.getText();
        if (username.equals("") || username.equals("Username")) {
            jTextFieldUsername.setText("Username");
        }
    }//GEN-LAST:event_jTextFieldUsernameFocusLost

    private void jTextFieldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPasswordFocusGained
        // TODO add your handling code here:
        String password = jTextFieldPassword.getText();
        if (password.equals("Password")) {
            jTextFieldPassword.setText("");
        }
    }//GEN-LAST:event_jTextFieldPasswordFocusGained

    private void jTextFieldPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPasswordFocusLost
        // TODO add your handling code here:
        String password = jTextFieldPassword.getText();
        if (password.equals("") || password.equals("Password")) {
            jTextFieldPassword.setText("Password");
        }
    }//GEN-LAST:event_jTextFieldPasswordFocusLost

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        try {
            conn = koneksi.getConnection();
            
            Statement st = conn.createStatement();
           
            String sql = "SELECT * FROM pengguna WHERE username='" + jTextFieldUsername.getText()
                    +"' and password='"+ jTextFieldPassword.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()){
                //JOptionPane.showMessageDialog(null, "Login Successfully");
                Menu_Utama menu = new Menu_Utama();
                menu.setVisible(true);
                menu.revalidate();
                this.dispose(); //close the form
                conn.close();
                
            }else{
                JOptionPane.showMessageDialog(null, "Username dan Password Salah");
                jTextFieldPassword.requestFocus();
                conn.close();
            }
        } catch (Exception e) {
             System.out.println("error");
             
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Login().setVisible(true);
            }
        });
    }

//    private void prosesLogin(){
//        if (validasiInput() == true) {
//            String id = jTextFieldUsername.getText();
//            String user = jTextFieldUsername.getText();
//            String pass = jTextFieldPassword.getText();
//            
//            Model_Login mod_log = new Model_Login();
//            
//            mod_log.setId_user(id);
//            mod_log.setUsername(user);
//            mod_log.setPass_user(pass);
//            
//            //prosesLogin(mod_log);
//           
//        }
//    }
    
//    private boolean validasiInput(){
//        boolean valid = false;
//        
//        if (jTextFieldUsername.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong");
//        }else if (jTextFieldPassword.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Password tidak boleh kosong");
//        }else {
//            valid = true;
//        }
//        return valid;
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

   

   
}
