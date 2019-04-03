/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Account.Staff;
import Core.Control;
import Login.Login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.sql.SQLException;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author jly09
 */
public class LoginForm extends javax.swing.JFrame {

    Control control;

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        usernameField.getDocument().addDocumentListener(new FieldInputListener(usernameField));
        passwordField.getDocument().addDocumentListener(new FieldInputListener(passwordField));
        
        username_lbl.setVisible(true);
        password_lbl.setVisible(true);
        
        this.setSize(new Dimension(640, 510));
        this.setPreferredSize(new Dimension(640, 510));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public LoginForm(Control c) {
        initComponents();
        usernameField.getDocument().addDocumentListener(new FieldInputListener(usernameField));
        passwordField.getDocument().addDocumentListener(new FieldInputListener(passwordField));
        
        username_lbl.setVisible(true);
        password_lbl.setVisible(true);

        control = c;
        control.getWindowList().add(this);

        this.setSize(new Dimension(640, 510));
        this.setPreferredSize(new Dimension(640, 510));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void dispose() {
        super.dispose();
        control.terminateThread();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        loginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        username_lbl = new javax.swing.JLabel();
        password_lbl = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginButton.setText("Enter");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Login");

        username_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        username_lbl.setText("Username");
        username_lbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));
        username_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        username_lbl.setFocusable(false);
        username_lbl.setRequestFocusEnabled(false);
        username_lbl.setVerifyInputWhenFocusTarget(false);

        password_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        password_lbl.setText("Password");
        password_lbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));
        password_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        password_lbl.setFocusable(false);
        password_lbl.setNextFocusableComponent(passwordField);
        password_lbl.setRequestFocusEnabled(false);
        password_lbl.setVerifyInputWhenFocusTarget(false);

        usernameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameField.setMargin(new java.awt.Insets(2, 8, 2, 8));
        usernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFieldFocusLost(evt);
            }
        });
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        passwordField.setDoubleBuffered(true);
        passwordField.setMargin(new java.awt.Insets(2, 8, 2, 8));
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        panel.setLayer(loginButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(username_lbl, javax.swing.JLayeredPane.PALETTE_LAYER);
        panel.setLayer(password_lbl, javax.swing.JLayeredPane.PALETTE_LAYER);
        panel.setLayer(usernameField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(passwordField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 210, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel1))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panel);
        panel.setBounds(0, 0, 640, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        if (password_lbl.isVisible()) {
            password_lbl.validate();
            password_lbl.repaint();
        }
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        if (passwordField.getPassword().length == 0) {
            password_lbl.setVisible(true);
        } else {
            password_lbl.setVisible(false);
        }
        passwordField.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179), 1), new EmptyBorder(2, 8, 2, 8)));
    }//GEN-LAST:event_passwordFieldFocusLost

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        password_lbl.setVisible(false);
        passwordField.setBorder(new CompoundBorder(new LineBorder(new Color(0, 120, 215), 2), new EmptyBorder(2, 8, 2, 8)));
    }//GEN-LAST:event_passwordFieldFocusGained

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        System.out.println(username_lbl.isVisible());
        if (username_lbl.isVisible()) {
            username_lbl.validate();
            username_lbl.repaint();
        }
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void usernameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFieldFocusLost
        System.out.println(usernameField.getText().length());
        if (usernameField.getText().length() == 0) {
            username_lbl.setVisible(true);
        } else {
            username_lbl.setVisible(false);
        }
        usernameField.setBorder(new LineBorder(new Color(171, 173, 179), 1));
        usernameField.setBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179), 1), new EmptyBorder(2, 8, 2, 8)));
    }//GEN-LAST:event_usernameFieldFocusLost

    private void usernameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFieldFocusGained
        username_lbl.setVisible(false);
        usernameField.setBorder(new CompoundBorder(new LineBorder(new Color(0, 120, 215), 2), new EmptyBorder(2, 8, 2, 8)));

        usernameField.setMargin(new Insets(2, 8, 2, 8));
    }//GEN-LAST:event_usernameFieldFocusGained

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        
        Login login = new Login();
        
        // add code here to go to main menu, allow access to methods for features etc
        try {
            if (login.validateLogin(username, password)) {
                // returns the staff member that logged in for access to the appropriate methods
                control.setStaff(login.createStaffObject(username));
                control.OpenMenu();
                this.dispose();
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLayeredPane panel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel password_lbl;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel username_lbl;
    // End of variables declaration//GEN-END:variables

    class FieldInputListener implements DocumentListener {

        JTextField field;

        public FieldInputListener(JTextField f) {
            field = f;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            checker();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checker();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            checker();
        }

        public void checker() {
            if (field == usernameField) {
                if (usernameField.getText().length() == 0 && !usernameField.isFocusOwner()) {
                    username_lbl.setVisible(true);
                } else {
                    username_lbl.setVisible(false);
                }
            }

            if (field == passwordField) {
                if (passwordField.getPassword().length == 0 && !passwordField.isFocusOwner()) {
                    password_lbl.setVisible(true);
                } else {
                    password_lbl.setVisible(false);
                }
            }
        }
    }

}
