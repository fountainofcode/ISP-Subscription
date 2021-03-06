/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myApplication;

import businessLayer.BLUser;
import javax.swing.JOptionPane;
import objectFactory.User;

/**
 *
 * @author Kriss
 */
public class LoginForm1 extends javax.swing.JFrame {
    
    //BLUser bluser;
    //User user;

    /**
     * Creates new form LoginForm1
     */
    public LoginForm1() {
        super("Login Form");
        initComponents();
        this.user = new User();
    }

    //public
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_login = new javax.swing.JButton();
        t_username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t_password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));

        b_login.setText("Login");
        b_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loginActionPerformed(evt);
            }
        });
        b_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b_loginKeyPressed(evt);
            }
        });

        t_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_usernameActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel3.setText("ISP Subscription System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t_username, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(t_password))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(b_login)
                        .addGap(175, 175, 175))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(b_login)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_loginActionPerformed
        // TODO add your handling code here:
        char[] temp_pwd = t_password.getPassword(); //Getting the thing typed on the password field. This can be taken in chars only.
        String pwd = null;
        pwd = String.copyValueOf(temp_pwd); //Changing the char taken to string
        
        //The entered username and password are sent via "checkLogin()" with return boolean
        try {
            BLUser blUser = new BLUser();
            
            user.setUsername(t_username.getText());
            user.setPassword(pwd);
            
            blUser.setUser(user);
            
            if(blUser.checkLogin()) {
                user = blUser.getUser();
                setVisible(false);
                
                switch (user.getUserType()) {
                    case "operator":
                        OperatorDesktop o_d = new OperatorDesktop();
                        o_d.setUser(user);
                        o_d.setVisible(true);
                        //o_d.setExtendedState(o_d.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                        break;
                    case "account":
                        AccountDesktop acc_d = new AccountDesktop();
                        acc_d.setUser(user);
                        acc_d.setVisible(true);
                        break;
                    case "technician":
                        TechnicianDesktop t_d = new TechnicianDesktop();
                        t_d.setUser(user);
                        t_d.setVisible(true);
                        break;
                    case "administrator":
                        AdministratorDesktop ad_d = new AdministratorDesktop();
                        ad_d.setUser(user);
                        ad_d.setVisible(true);
                        break;
                    default:
                        setVisible(true);
                        JOptionPane.showMessageDialog(rootPane, "Dear client, you cannot be logged on!");
                        this.dispose();//setVisible(false);
                        LoginForm1 lf = new LoginForm1();
                        lf.setVisible(true);
                        System.out.println("Invalid user!" + user.getUserType() + user.getUsername());
                }// end switch
            }// end if
            
            else {
                JOptionPane.showMessageDialog(rootPane, "Invalid user or password!");
                this.dispose();//setVisible(false);
                LoginForm1 lf = new LoginForm1();
                lf.setVisible(true);
                System.out.println("Invalid user or password!" + user.getUserType() + user.getUsername());
            }// end else
            
        }// end try
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_b_loginActionPerformed

    private void t_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_usernameActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_t_usernameActionPerformed

    private void b_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b_loginKeyPressed
        // TODO add your handling code here:
        char[] temp_pwd = t_password.getPassword(); //Getting the thing typed on the password field. This can be taken in chars only.
        String pwd = null;
        pwd = String.copyValueOf(temp_pwd); //Changing the char taken to string
        
        //The entered username and password are sent via "checkLogin()" with return boolean
        try {
            BLUser blUser = new BLUser();
            
            user.setUsername(t_username.getText());
            user.setPassword(pwd);
            
            blUser.setUser(user);
            
            if(blUser.checkLogin()) {
                user = blUser.getUser();
                setVisible(false);
                
                switch (user.getUserType()) {
                    case "operator":
                        OperatorDesktop o_d = new OperatorDesktop();
                        o_d.setUser(user);
                        o_d.setVisible(true);
                        break;
                    case "account":
                        AccountDesktop acc_d = new AccountDesktop();
                        acc_d.setUser(user);
                        acc_d.setVisible(true);
                        break;
                    case "technician":
                        TechnicianDesktop t_d = new TechnicianDesktop();
                        t_d.setUser(user);
                        t_d.setVisible(true);
                        break;
                    case "administrator":
                        AdministratorDesktop ad_d = new AdministratorDesktop();
                        ad_d.setUser(user);
                        ad_d.setVisible(true);
                        break;
                    default:
                        setVisible(true);
                        JOptionPane.showMessageDialog(rootPane, "Dear client, you cannot be logged on!");
                        this.dispose();//setVisible(false);
                        LoginForm1 lf = new LoginForm1();
                        lf.setVisible(true);
                        System.out.println("Invalid user!" + user.getUserType() + user.getUsername());
                }// end switch
            }// end if
            
            else {
                JOptionPane.showMessageDialog(rootPane, "Invalid user or password!");
                this.dispose();//setVisible(false);
                LoginForm1 lf = new LoginForm1();
                lf.setVisible(true);
                System.out.println("Invalid user or password!" + user.getUserType() + user.getUsername());
            }// end else
            
        }// end try
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_b_loginKeyPressed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField t_password;
    private javax.swing.JTextField t_username;
    // End of variables declaration//GEN-END:variables

    private objectFactory.User user;
    private businessLayer.BLUser blUser;
}
