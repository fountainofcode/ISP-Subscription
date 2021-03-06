/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myApplication;

import businessLayer.BLRequest;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objectFactory.Request;

/**
 *
 * @author Kriss
 */
public class ViewCurrentRequest extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewServiceList1
     */
    public ViewCurrentRequest() {
        super("View Current Request");
        initComponents();
        blrequest = new BLRequest();
        request = new Request();
    }

    public void setRequest(Request request){
        this.request = request;
    }
    
    public void viewCurrentRequest() {
        DefaultTableModel dtm = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        try{
            dtm.addColumn("Current Date");
            dtm.addColumn("Request Id");
            dtm.addColumn("Client");
            dtm.addColumn("Subject");
            dtm.addColumn("Description");
            
            blrequest.setRequest(request);
            ResultSet rs = blrequest.selectRequestNotResponded();
            
            while(rs.next()) {
                Object objData[] = new Object[5];
                objData[0] = rs.getString("currentDate");
                objData[1] = rs.getInt("requestId");
                objData[2] = rs.getInt("clientId");
                objData[3] = rs.getString("requestSubject");
                objData[4] = rs.getString("requestDescrip");
                
                dtm.addRow(objData);
            }
            this.jTable1.setModel(dtm);
        }catch(Exception ex){
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private businessLayer.BLRequest blrequest;
    private objectFactory.Request request;
}
