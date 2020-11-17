/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myApplication;

import objectFactory.Request;
import businessLayer.BLRequestResponse;
import businessLayer.BLUser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objectFactory.Response;
import java.sql.ResultSet;
import objectFactory.User;


/**
 *
 * @author Kriss
 */
public class ViewRequestResponse extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewResponse1
     */
    public ViewRequestResponse() {
        super("View Request/Response");
        initComponents();
        blRequestResponse = new BLRequestResponse();
        response = new Response();
        request = new Request();
        
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    //public void viewRequestResponse(int num) {
    public void viewRequestResponse() {
        DefaultTableModel dtm = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        try{
            dtm.addColumn("Client Id");
            dtm.addColumn("Request Date");
            dtm.addColumn("Request Id");
            dtm.addColumn("Request Subject");
            dtm.addColumn("Description");
            dtm.addColumn("Response Date");
            dtm.addColumn("Response Id");
            dtm.addColumn("Response Subject");
            dtm.addColumn("Description");
            
            //blRequestResponse.setRequest(this.request);
            //blRequestResponse.setResponse(this.response);
            //ResultSet rs = blRequestResponse.selectParticularClientRequestResponse();
            
            //while(rs.next())
            {
                Object objData[] = new Object[9];
                //objData[0] = this.setInt(num);
                /*objData[0] = rs.getInt("clientId");
                objData[1] = rs.getString("requestDate");
                objData[2] = rs.getInt("requestId");
                objData[3] = rs.getString("requestSubject");
                objData[4] = rs.getString("requestDescrip");
                objData[5] = rs.getString("responseDate");
                objData[6] = rs.getInt("responseId");
                objData[7] = rs.getString("responseSubject");
                objData[8] = rs.getString("responseDescrip");
                */
                
                for(int i=0; i<=8; i++ ) {
                    objData[i] = 0;
                }
                
                dtm.addRow(objData);
            }
            this.jTable1.setModel(dtm);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /*Populate Data on Table*/
    public void populateDataOnTable() {
        /*Defining default table model*/
        DefaultTableModel dtm = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        try{
            dtm.addColumn("Client Id");
            dtm.addColumn("Request Date");
            dtm.addColumn("Request Id");
            dtm.addColumn("Request Subject");
            dtm.addColumn("Description");
            dtm.addColumn("Response Date");
            dtm.addColumn("Response Id");
            dtm.addColumn("Response Subject");
            dtm.addColumn("Description");
        
            /*Getting the value of clientId and setting it to the request and response*/
            BLRequestResponse blRequestResponse = new BLRequestResponse();
            ResultSet rs = blRequestResponse.selectParticularClientRequestResponse(txt_username.getText());            
            
            while(rs.next()) {
                Object objData[] = new Object[9];
                //objData[0] = this.setInt(num);
                objData[0] = rs.getInt("clientId");
                objData[1] = rs.getString("reqDate");
                objData[2] = rs.getInt("requestId");
                objData[3] = rs.getString("requestSubject");
                objData[4] = rs.getString("requestDescrip");
                objData[5] = rs.getString("resDate");
                objData[6] = rs.getInt("responseId");
                objData[7] = rs.getString("responseSubject");
                objData[8] = rs.getString("responseDescrip");
                
                dtm.addRow(objData);
            }
            this.jTable1.setModel(dtm);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /*Check if the given Username exists and get User Id from username*/
    public void checkUsernameExist() {

        try {
            BLUser bluser = new BLUser();
            User user = new User();

            ResultSet rs = bluser.selectUserIdFromUsername(txt_username.getText());

            user.setUsername(txt_username.getText());
            bluser.setUser(user);

            if (bluser.checkUsernameExist()) {
                
                populateDataOnTable();
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

        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        btn_enter = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1265, 643));

        jLabel1.setText("Client Username");

        btn_enter.setText("Enter");
        btn_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enterActionPerformed(evt);
            }
        });
        btn_enter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_enterKeyPressed(evt);
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

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_enter))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enterActionPerformed
        // TODO add your handling code here:
        checkUsernameExist();
    }//GEN-LAST:event_btn_enterActionPerformed

    private void btn_enterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_enterKeyPressed
        // TODO add your handling code here:
        checkUsernameExist();
    }//GEN-LAST:event_btn_enterKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_enter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
    
    private objectFactory.Request request;
    private objectFactory.Response response;
    private businessLayer.BLRequestResponse blRequestResponse;
    private objectFactory.User user;
    private businessLayer.BLUser bluser;
    
}
