/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myApplication;

import businessLayer.BLRequestResponse;
import businessLayer.BLServices;
import businessLayer.BLSubscription;
import businessLayer.BLUser;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import objectFactory.Services;
import objectFactory.Subscription;
import objectFactory.User;

/**
 *
 * @author Kriss
 */
public class UpdateSubscription extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewServiceList1
     */
    public UpdateSubscription() {
        super("Update Subscription");
        initComponents();
        blservices = new BLServices();
        services = new Services();

    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void viewEmptyServiceList() {
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        try {
            dtm.addColumn("Service Id");
            dtm.addColumn("Service Name");
            dtm.addColumn("Bandwidth");
            dtm.addColumn("Duration");
            dtm.addColumn("Price");
            dtm.addColumn("Installation Cost");
            dtm.addColumn("Sharing Ratio");
            dtm.addColumn("Remarks");

            blservices.setServices(this.services);
            ResultSet rs = blservices.selectAllServices();

            Object objData[] = new Object[8];
            for (int i = 0; i <= 7; i++) {
                objData[i] = 0;
            }

            dtm.addRow(objData);
            this.jTable1.setModel(dtm);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /*Check if the given Username exists*/
    public void checkUsernameExist() {

        try {
            BLUser bluser = new BLUser();
            User user = new User();

            ResultSet rs = bluser.selectUserIdFromUsername(txt_username.getText());

            user.setUsername(txt_username.getText());
            bluser.setUser(user);

            if (bluser.checkUsernameExist()) {
                viewServiceList();
            }// end if
            else {
                JOptionPane.showMessageDialog(rootPane, "Invalid username!");
            }// end else        

        }// end try
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }//end catch
    }

    /*And then select one service, which will be subscribed*/
    public void checkUserTakenServiceThenSubscribe() {
        /*Getting the value at selected row*/
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {

                /*Getting the id value of selected row*/
                String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                int num_id = Integer.parseInt(id);

                /*Checking if serviceId exists of that client already*/
                try {
                    BLSubscription blsubscription = new BLSubscription();
                    Subscription subscription = new Subscription();

                    /*Getting client userid from the inserted username*/
                    BLUser bluser = new BLUser();
                    User user = new User();

                    ResultSet rs = bluser.selectUserIdFromUsername(txt_username.getText());

                    while (rs.next()) {
                        subscription.setClientId(rs.getInt("userId"));
                    }//end while

                    subscription.setServiceId(num_id);
                    blsubscription.setSubscription(subscription);
                    //subscription = blsubscription.getSubscription();
                    //System.out.println(subscription.getClientId());

                    if (!blsubscription.checkServiceIdExistParticularClient(num_id, subscription.getClientId())) {
                        /*Confirming to update subscription*/
                        int option = JOptionPane.showConfirmDialog(rootPane, "Service Id as: " + jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() + " is going to be subscribed.", null, 2);
                        if (option == JOptionPane.OK_OPTION) {
                            try {
                                blsubscription = new BLSubscription();
                                subscription = new Subscription();

                                /*Getting subscription name = service name from  the selected row*/
                                String subscriptionName = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                                subscription.setSubscripName(subscriptionName);

                                subscription.setServiceId(num_id);

                                /*Getting client userid from the inserted username*/
                                bluser = new BLUser();
                                user = new User();

                                rs = bluser.selectUserIdFromUsername(txt_username.getText());
                                while (rs.next()) {
                                    subscription.setClientId(rs.getInt("userId"));
                                }//end while

                                /*Expiry date showing*/
                                Calendar date3 = Calendar.getInstance();
                                date3.setTime(new Date());
                                Format f = new SimpleDateFormat("yyyy/MM/dd");  
                                date3.add(Calendar.YEAR, 1);
                                subscription.setExpiryDate(f.format(date3.getTime()));

                                subscription.setDuePaid("No");

                                blsubscription.setSubscription(subscription);

                                /*That particular service is added to the subscription of the client*/
                                blsubscription.insertSubscription();
                                setVisible(false);

                                JOptionPane.showMessageDialog(null, "Welcome user: '" + txt_username.getText() + "'. \nYou are subscribed to " + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + ". \nPay your bill and get authentication for subscription.");

                            }//end try
                            catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
                            }//end catch    
                        }//end if
                    }//end if
                    else {
                        JOptionPane.showMessageDialog(rootPane, "This service is already taken!");
                        JOptionPane.getRootFrame();//setVisible(false);
                        //JOptionPane.showMessageDialog(null, "New client as username: '" + user.getUsername() + "' is created.");

                    }//end else

                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
                }//end catch

            }
        }
        );

    }

    /*Then populate the service list table*/
    public void viewServiceList() {
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        try {
            dtm.addColumn("Service Id");
            dtm.addColumn("Service Name");
            dtm.addColumn("Bandwidth");
            dtm.addColumn("Duration");
            dtm.addColumn("Price");
            dtm.addColumn("Installation Cost");
            dtm.addColumn("Sharing Ratio");
            dtm.addColumn("Remarks");

            blservices.setServices(this.services);
            ResultSet rs = blservices.selectAllServices();

            while (rs.next()) {
                Object objData[] = new Object[8];
                objData[0] = rs.getInt("serviceId");
                objData[1] = rs.getString("serviceName");
                objData[2] = rs.getString("bandwidth");
                objData[3] = rs.getInt("duration");
                objData[4] = rs.getInt("price");
                objData[5] = rs.getInt("installationCost");
                objData[6] = rs.getString("sharingRatio");
                objData[7] = rs.getString("serviceRemarks");

                dtm.addRow(objData);
            }
            this.jTable1.setModel(dtm);

            /*And then select one service, which will be subscribed*/
            checkUserTakenServiceThenSubscribe();

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

        jLabel2.setText("Service List ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_enter2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)))
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
        /*First check if username exist*/
        checkUsernameExist();

        //viewServiceList();
    }//GEN-LAST:event_btn_enter2ActionPerformed

    private void btn_enter2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_enter2KeyPressed
        /*First check if username exist*/
        checkUsernameExist();

        //viewServiceList();
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
    private businessLayer.BLServices blservices;
    private objectFactory.Services services;
}
