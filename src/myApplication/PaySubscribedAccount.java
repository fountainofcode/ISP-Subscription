/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myApplication;

import businessLayer.BLAccount;
import businessLayer.BLSubscription;
import businessLayer.BLUser;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import objectFactory.User;

/**
 *
 * @author Kriss
 */
public class PaySubscribedAccount extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewServiceList1
     */
    public PaySubscribedAccount() {
        super("Pay Subscribed Account");
        initComponents();
        blaccount = new BLAccount();
        account = new objectFactory.Account();

    }

    public void setAccount(objectFactory.Account act) {
        this.account = act;
    }

    public void viewAccountData() {
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        try {
            dtm.addColumn("Account ID");
            dtm.addColumn("Client Id");
            dtm.addColumn("Client Name");
            dtm.addColumn("Subscription Id");
            dtm.addColumn("Subscription Name");
            dtm.addColumn("Paid Date");

            blaccount.setAccount(this.account);

            ResultSet rs = blaccount.selectAccountWithSubscription();
            while (rs.next()) {
                Object objData[] = new Object[6];
                objData[0] = rs.getInt("accountId");
                objData[1] = rs.getInt("accountHolderId");
                objData[2] = rs.getString("accountHolderName");
                objData[3] = rs.getInt("subscripId");
                objData[4] = rs.getString("subscripName");
                objData[5] = rs.getString("paidDate");

                dtm.addRow(objData);
            }
            this.jTable1.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    public void paySubscription() {
        /*Getting the value at selected row and populating on the textboxes to update*/
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                //System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());

                /*Getting the id value of selected row*/
                String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                int num_id = Integer.parseInt(id);

                /*Confirming to update*/
                //int option = JOptionPane.showConfirmDialog(rootPane, "Client username as: " + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + " is going to be updated.", null, 2);
                int option = JOptionPane.showConfirmDialog(rootPane, "Account Id as: " + num_id + " is going to be updated.", null, 2);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        BLAccount blaccount = new BLAccount();
                        blaccount.updatePaidDateofAccount(num_id);
                        setVisible(false);
                    }//end try
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
                    }//end catch
                }//end if
                else {
                    JOptionPane.getRootFrame();//setVisible(false);
                }//end else

            }
        });
    }

    /*Show that particular User's subscriptions*/
    public void ShowUserSubscription() throws Exception {
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        try {
            dtm.addColumn("Account ID");
            dtm.addColumn("Client Id");
            dtm.addColumn("Client Name");
            dtm.addColumn("Subscription Id");
            dtm.addColumn("Subscription Name");
            dtm.addColumn("Paid Date");

            blaccount.setAccount(this.account);

            ResultSet rs = blaccount.selectParticularAccountWithSubscription(txt_username.getText());
            while (rs.next()) {
                Object objData[] = new Object[6];
                objData[0] = rs.getInt("accountId");
                objData[1] = rs.getInt("accountHolderId");
                objData[2] = rs.getString("accountHolderName");
                objData[3] = rs.getInt("subscripId");
                objData[4] = rs.getString("subscripName");
                objData[5] = rs.getString("paidDate");

                dtm.addRow(objData);
            }
            this.jTable1.setModel(dtm);

            /*Clicked row in the table to pay the subscription*/
            paySubscription();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /*Check Username Exist*/
    /**
     *
     */
    public void checkUsernameExist() {
        try {
            BLUser bluser = new BLUser();
            User user = new User();

            ResultSet rs = bluser.selectUserIdFromUsername(txt_username.getText());
            user.setUsername(txt_username.getText());
            bluser.setUser(user);

            if (bluser.checkUsernameExist()) {
                ShowUserSubscription();
            }// end if
            else {
                JOptionPane.showMessageDialog(rootPane, "Invalid username!");
            }// end else        

        }// end try
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }//end catch
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_enter2 = new javax.swing.JButton();
        txt_username = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1265, 643));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel1.setText("Client Username");

        btn_enter2.setText("Enter");
        btn_enter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enter2ActionPerformed(evt);
            }
        });
        btn_enter2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_enter2KeyPressed(evt);
            }
        });

        jLabel2.setText("Subscribed Account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_enter2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_enter2))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enter2ActionPerformed
        checkUsernameExist();

    }//GEN-LAST:event_btn_enter2ActionPerformed

    private void btn_enter2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_enter2KeyPressed
        checkUsernameExist();
    }//GEN-LAST:event_btn_enter2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_enter2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
    private objectFactory.Account account;
    private businessLayer.BLAccount blaccount;
}
