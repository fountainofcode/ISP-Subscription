/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myApplication;

import businessLayer.BLUser;
import java.sql.ResultSet;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objectFactory.User;
import objectFactory.OfficeStaff;
import businessLayer.BLServices;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import objectFactory.Services;
import objectFactory.Subscription;
import businessLayer.BLSubscription;
import objectFactory.Account;
import businessLayer.BLAccount;

/**
 *
 * @author Kriss
 */
public class UpdateStaffProfile extends javax.swing.JInternalFrame {

    /**
     * Creates new form CreateProfile
     */
    public UpdateStaffProfile() {
        super("Update OfficeStaff Profile");
        initComponents();
        bluser = new BLUser();
        user = new User();
        officeStaff = new OfficeStaff();

    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOfficeStaff(OfficeStaff officeStaff) {
        this.officeStaff = officeStaff;
    }

    public void updateOfficeStaffProfile() {
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
            dtm.addColumn("User Type");
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
            dtm.addColumn("Designation");

            bluser.setUser(this.user);
            ResultSet rs = bluser.selectOfficeStaffProfile();//.selectOfficeStaffProfile();
            while (rs.next()) {
                Object objData[] = new Object[14];
                objData[0] = rs.getInt("userId");
                objData[1] = rs.getString("username");
                objData[2] = rs.getString("userType");
                objData[3] = rs.getString("firstName");
                objData[4] = rs.getString("middleName");
                objData[5] = rs.getString("lastName");
                objData[6] = rs.getString("blockCode");
                objData[7] = rs.getString("streetName");
                objData[8] = rs.getString("cityCode");
                objData[9] = rs.getString("cityName");
                objData[10] = rs.getString("telephone");
                objData[11] = rs.getString("email");
                objData[12] = rs.getString("status");
                objData[13] = rs.getString("designation");

                dtm.addRow(objData);
            }
            this.jTable1.setModel(dtm);

            /*Getting the value at selected row and populating on the textboxes to update*/
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());

                    /*Getting the id value of selected row*/
                    String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    int num_id = Integer.parseInt(id);

                    /*Confirming to update*/
                    int option = JOptionPane.showConfirmDialog(rootPane, "OfficeStaff username as: " + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + " is going to be updated.", null, 2);
                    if (option == JOptionPane.OK_OPTION) {
                        try {
                            BLUser bluser = new BLUser();
                            ResultSet rs = bluser.selectParticularOfficeStaffProfile(num_id);

                            while (rs.next()) {
                                txt_userId.setText(new Integer(rs.getInt("userId")).toString());
                                txt_username.setText(rs.getString("username"));

                                /*Make the first item of combo box choice, the same as the data(userType) in the table*/
                                String str[] = {"operator", "account", "technician", "administrator"};
                                System.out.println(rs.getString("userType"));
                                if (str[0].compareTo(rs.getString("userType")) == 0) {
                                    combo_userType.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Operator", "Account", "Technician", "Administrator"}));

                                }
                                else if (str[1].compareTo(rs.getString("userType")) == 0) {
                                    combo_userType.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Account", "Operator", "Technician", "Administrator"}));

                                }
                                else if (str[2].compareTo(rs.getString("userType")) == 0) {
                                    combo_userType.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Technician", "Account", "Operator", "Administrator"}));

                                }
                                else {
                                    combo_userType.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Administrator", "Technician", "Account", "Operator"}));

                                }
                                combo_userType.setSelectedItem(rs.getString("userType"));
                                
                                txt_password.setText(rs.getString("password"));
                                txt_firstName.setText(rs.getString("firstName"));
                                txt_middleName.setText(rs.getString("middleName"));
                                txt_lastName.setText(rs.getString("lastName"));
                                txt_blockCode.setText(rs.getString("blockCode"));
                                txt_streetName.setText(rs.getString("streetName"));
                                txt_cityCode.setText(rs.getString("cityCode"));
                                txt_cityName.setText(rs.getString("cityName"));
                                txt_telephone.setText(rs.getString("telephone"));
                                txt_email.setText(rs.getString("email"));
                                txt_status.setText(rs.getString("status"));
                                txt_designation.setText(rs.getString("designation"));

                            }

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_firstName = new javax.swing.JTextField();
        txt_middleName = new javax.swing.JTextField();
        txt_lastName = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_blockCode = new javax.swing.JTextField();
        txt_streetName = new javax.swing.JTextField();
        txt_cityCode = new javax.swing.JTextField();
        txt_cityName = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_status = new javax.swing.JTextField();
        button_update = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        txt_telephone = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_userId = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_designation = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        combo_userType = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(569, 643));

        jLabel2.setText("First Name");

        jLabel3.setText("Middle Name");

        jLabel4.setText("Last Name");

        jLabel5.setText("Username");

        jLabel6.setText("Password");

        jLabel8.setText("Block Code");

        jLabel9.setText("Street Name");

        jLabel10.setText("City Code");

        jLabel11.setText("City Name");

        jLabel12.setText("Telephone");

        jLabel13.setText("Email");

        jLabel14.setText("Status");

        txt_cityName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cityNameActionPerformed(evt);
            }
        });

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        button_update.setText("Update");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

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

        jScrollPane3.setViewportView(jScrollPane1);

        jLabel1.setText("User Id");

        txt_userId.setEditable(false);

        jLabel15.setText("Designation");

        jLabel7.setText("User Type");

        combo_userType.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Operator", "Account", "Technician", "Administrator" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combo_userType, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cityName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_middleName)
                            .addComponent(txt_lastName)
                            .addComponent(txt_username)
                            .addComponent(txt_blockCode)
                            .addComponent(txt_streetName)
                            .addComponent(txt_cityCode)
                            .addComponent(txt_email)
                            .addComponent(txt_firstName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(187, 187, 187))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_userId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(button_update)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_middleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_blockCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_streetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cityCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_designation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(combo_userType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(button_update)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        // TODO add your handling code here:
        char[] temp_pwd = txt_password.getPassword();
        String pwd = null;
        pwd = String.copyValueOf(temp_pwd);

        try {
            BLUser bluser = new BLUser();
            User user = new User();
            OfficeStaff officeStaff = new OfficeStaff();

            user.setUserId(Integer.parseInt(txt_userId.getText().toString()));
            user.setUsername(txt_username.getText());
            user.setPassword(pwd);
            user.setUserType(combo_userType.getSelectedItem().toString());
            officeStaff.setUserId(Integer.parseInt(txt_userId.getText().toString()));
            officeStaff.setFirstName(txt_firstName.getText());
            officeStaff.setMiddleName(txt_middleName.getText());
            officeStaff.setLastName(txt_lastName.getText());
            officeStaff.setBlockCode(txt_blockCode.getText());
            officeStaff.setStreetName(txt_streetName.getText());
            officeStaff.setCityCode(txt_cityCode.getText());
            officeStaff.setCityName(txt_cityName.getText());
            officeStaff.setTelephone(txt_telephone.getText());
            officeStaff.setEmail(txt_email.getText());
            officeStaff.setStatus(txt_status.getText());
            officeStaff.setDesignation(txt_designation.getText());

            bluser.setUser(user);
            bluser.setOfficeStaff(officeStaff);

            user = bluser.getUser();

            /*Checking if username exists*/
            if (bluser.checkUsernameExist()) {
                /*Checking if the username is other than the previous one*/
                String a1 = user.getUsername();

                if (a1.compareTo(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()) == 0) {
                    bluser.updateOfficeStaffProfile(Integer.parseInt(txt_userId.getText().toString()));
                    JOptionPane.showMessageDialog(null, "The profile is updated.");
                    setVisible(false);

                } //When the username exists in the table but is not the previous one
                else {
                    JOptionPane.showMessageDialog(null, "Username: " + user.getUsername() + " already exists or it is blank! \nEnter another username.");
                }

            } //When the username does not exist in the table and is not the previous one
            else {
                bluser.updateOfficeStaffProfile(Integer.parseInt(txt_userId.getText().toString()));
                JOptionPane.showMessageDialog(null, "The profile is updated.");
                setVisible(false);

            }
        }//end try
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }//end catch

    }//GEN-LAST:event_button_updateActionPerformed

    public void setServices(Services services) {
        this.services = services;
    }


    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_cityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cityNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cityNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_update;
    private javax.swing.JComboBox combo_userType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_blockCode;
    private javax.swing.JTextField txt_cityCode;
    private javax.swing.JTextField txt_cityName;
    private javax.swing.JTextField txt_designation;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_firstName;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_middleName;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_status;
    private javax.swing.JTextField txt_streetName;
    private javax.swing.JTextField txt_telephone;
    private javax.swing.JTextField txt_userId;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

    private businessLayer.BLUser bluser;
    private objectFactory.User user;
    private objectFactory.OfficeStaff officeStaff;

    private businessLayer.BLServices blservices;
    private objectFactory.Services services;

    private businessLayer.BLSubscription blsubscription;
    private objectFactory.Subscription subscription;

    private businessLayer.BLAccount blaccount;
    private objectFactory.Account account;
}
