/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myApplication;

import businessLayer.BLAccount;
import businessLayer.BLUser;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import objectFactory.User;
import objectFactory.Account;
import objectFactory.Subscription;
import businessLayer.BLSubscription;

/**
 *
 * @author Kriss
 */
public class PayAccount extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewClientProfile1
     */
    public PayAccount() {
        super("Client Profile");
        initComponents();
        bluser = new BLUser();
        user = new User();

    }

    public void setUser(User usr) {
        this.user = usr;
    }

    public void viewClientProfile() {
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        try {
            dtm.addColumn("User ID");
            dtm.addColumn("Username");
            dtm.addColumn("First Name");
            dtm.addColumn("Middle Name");
            dtm.addColumn("Last Name");
            dtm.addColumn("Block Code");
            dtm.addColumn("Street Name");
            dtm.addColumn("City Code");
            dtm.addColumn("City Name");
            dtm.addColumn("Telephone");
            dtm.addColumn("Email");
            dtm.addColumn("Status");

            bluser.setUser(this.user);
            ResultSet rs = bluser.selectClientProfile();//.selectOfficeStaffProfile();
            while (rs.next()) {
                Object ObjData[] = new Object[12];
                ObjData[0] = rs.getInt("userId");
                ObjData[1] = rs.getString("username");
                ObjData[2] = rs.getString("firstName");
                ObjData[3] = rs.getString("middleName");
                ObjData[4] = rs.getString("lastName");
                ObjData[5] = rs.getString("blockCode");
                ObjData[6] = rs.getString("streetName");
                ObjData[7] = rs.getString("cityCode");
                ObjData[8] = rs.getString("cityName");
                ObjData[9] = rs.getString("telephone");
                ObjData[10] = rs.getString("email");
                ObjData[11] = rs.getString("status");

                dtm.addRow(ObjData);
            }
            this.jTable1.setModel(dtm);

            /*Getting the value at selected row and deleting the selected row*/
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    //System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());

                    /*Getting the id value of selected row*/
                    String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    int num_id = Integer.parseInt(id);

                    /*Checking if the user has subscribed*/
                    try {
                        BLSubscription blsubscription = new BLSubscription();
                        Subscription subscription = new Subscription();
                        subscription.setClientId(num_id);
                        blsubscription.setSubscription(subscription);
                        if (blsubscription.checkClientIdExist()) {

                            /*Checking if the user has already been given authentication*/
                            BLAccount blaccount = new BLAccount();
                            Account account = new Account();
                            account.setAccountHolderId(num_id);
                            blaccount.setAccount(account);
                            if (blaccount.checkUserIdExist()) {
                                JOptionPane.getRootFrame();//setVisible(false);
                                JOptionPane.showMessageDialog(null, "Username as: '" + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + "' has already been given authentication.");

                            }
                            /*If authentication has already not been given*/
                            else {
                                /*Getting the full name from firstname, middlename, lastname*/
                                String fullName = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() + jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString() + jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();

                                /*Confirming to select that client*/
                                int option = JOptionPane.showConfirmDialog(rootPane, "Client username as: " + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + " is selected for subscription authentication.", null, 2);
                                if (option == JOptionPane.OK_OPTION) {
                                    try {
                                        blaccount = new BLAccount();
                                        account = new Account();

                                        account.setAccountHolderId(num_id);
                                        account.setAccountHolderName(fullName);

                                        /*Getting current date*/
                                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        Date date = new Date();
                                        account.setPaidDate(dateFormat.format(date).toString());

                                        blaccount.setAccount(account);
                                        /*That particular service is inserted*/
                                        blaccount.insertAccount();

                                        /*Also the subscription table is authenticated now*/
                                        blsubscription = new BLSubscription();
                                        subscription = new Subscription();

                                        subscription.setDuePaid("Yes");

                                        blsubscription.setSubscription(subscription);
                                        blsubscription.updateDuePaidSubscription(num_id);

                                        /*Give subscription authentication msg*/
                                        setVisible(false);
                                        JOptionPane.showMessageDialog(null, "Subscribed username as: '" + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + "' has been given authentication. \n Hope you enjoy using our service.");

                                    }//end try
                                    catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
                                    }//end catch

                                    //refreshTable();
                                }//end if
                                else {
                                    JOptionPane.getRootFrame();//setVisible(false);
                                }//end else

                            }

                        } /*If client has not subscribed*/ else {
                            JOptionPane.getRootFrame();//setVisible(false);
                            JOptionPane.showMessageDialog(null, "Username as: '" + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + "' has not subscribed.");

                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
                    }//end catch

                }
            }
            );

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }
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

        setClosable(true);
        setMaximizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private businessLayer.BLUser bluser;
    private objectFactory.User user;

    private businessLayer.BLAccount blaccount;
    private objectFactory.Account account;

    private businessLayer.BLSubscription blsubscription;
    private objectFactory.Subscription subscription;
}
