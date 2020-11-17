/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myApplication;

import businessLayer.BLUser;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import objectFactory.User;
import objectFactory.Client;


/**
 *
 * @author Kriss
 */
public class DeleteStaffProfile extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewClientProfile1
     */
    public DeleteStaffProfile() {
        super("Delete Staff Profile");
        initComponents();
        bluser = new BLUser();
        user = new User();
        
    }

    public void setUser(User usr){
        this.user = usr;
    }
    
    public void deleteOfficeStaffProfile() {
        DefaultTableModel dtm = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        try{
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
            ResultSet rs = bluser.selectOfficeStaffProfile();
            while(rs.next()) {
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
        
            /*Getting the value at selected row and deleting the selected row*/
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    
                    /*Getting the id value of selected row*/
                    String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    int num_id = Integer.parseInt(id);

                    /*Confirming to delete*/
                    int option = JOptionPane.showConfirmDialog(rootPane, "Staff username as: " + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + " is going to be deleted.", null, 2);
                    if (option == JOptionPane.OK_OPTION) {
                        try {
                            BLUser bluser = new BLUser();
                            /*That particular office staff is deleted*/
                            bluser.deleteOfficeStaffProfile(num_id);
                            

                        }//end try
                        catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
                        }//end catch

                        refreshTable();
                    }//end if
                    else {
                        JOptionPane.getRootFrame();//setVisible(false);
                    }//end else

                    
                }
            }
            );

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void refreshTable() {
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        try{
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
            ResultSet rs = bluser.selectOfficeStaffProfile();
            while(rs.next()) {
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
            this.jTable1.removeAll();
            this.jTable1.setModel(dtm); //Populating values in jTable1
            
        }//end try
        catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
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

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1265, 643));

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
    private objectFactory.Client client;
}
