/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myApplication;

import businessLayer.BLRequest;
import businessLayer.BLResponse;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import objectFactory.Request;
import objectFactory.Response;

/**
 *
 * @author Kriss
 */
public class Input_DataRespond extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewServiceList1
     */
    public Input_DataRespond() {
        super("Respond to Request");
        initComponents();
        blrequest = new BLRequest();
        request = new Request();
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    /*To populate data on the table that is exactly the result of ViewCurrentRequest*/
    public void viewCurrentRequest() {
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        try {
            dtm.addColumn("Current Date");
            dtm.addColumn("Request Id");
            dtm.addColumn("Client");
            dtm.addColumn("Subject");
            dtm.addColumn("Description");

            blrequest.setRequest(request);
            ResultSet rs = blrequest.selectRequestNotResponded();

            while (rs.next()) {
                Object objData[] = new Object[5];
                objData[0] = rs.getString("currentDate");
                objData[1] = rs.getInt("requestId");
                objData[2] = rs.getInt("clientId");
                objData[3] = rs.getString("requestSubject");
                objData[4] = rs.getString("requestDescrip");

                dtm.addRow(objData);
            }
            this.jTable1.setModel(dtm);

            /*Data from Table to Boxes*/
            datafromTableToBoxes();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /*Data from Table to Boxes*/
    public void datafromTableToBoxes() {
        /*Getting the value at selected row and populating on the textboxes to update*/
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                //System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());

                /*Getting the request id value of selected row*/
                String id = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                int requestId = Integer.parseInt(id);
                System.out.println(requestId);

                /*Getting the client id value of selected row*/
                String id1 = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                int clientId = Integer.parseInt(id1);
                System.out.println(clientId);

                /*Getting the subject of request*/
                String requestSubject = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
                System.out.println(requestSubject);

                /*Getting the subject of request*/
                String requestDescrip = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();

                /*Confirming to update*/
                int option = JOptionPane.showConfirmDialog(rootPane, "Request Id as: " + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + " is selected.", null, 2);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        txt_requestId.setText(id);
                        txt_userId.setText(id1);
                        txt_requestSubject.setText(requestSubject);
                        txtArea_requestDescrip.setText(requestDescrip);

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

    /*To show date in Text box
     To show new Response Id in Text box*/
    public void input_DataRespond() {

        /*To show date in Text box*/
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        txt_date.setText(new String(dateFormat.format(date)));

        /*To show new Response Id in Text box*/
        try {
            BLResponse blresponse = new BLResponse();
            ResultSet rs = blresponse.selectMaxResponseId();

            while (rs.next()) {
                txt_responseId.setText(new Integer((rs.getInt("max_id")) + 1).toString());
            }
        }//end try
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }//end catch

        /*To populate data on the table that is exactly the result of ViewCurrentRequest*/
        viewCurrentRequest();
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
        txt_date = new javax.swing.JTextField();
        txt_responseId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_userId = new javax.swing.JTextField();
        txt_requestSubject = new javax.swing.JTextField();
        txt_responseSubject = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtArea_requestDescrip = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtArea_responseDescrip = new javax.swing.JTextArea();
        btn_response = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_requestId = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setMaximizable(true);

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

        txt_date.setEditable(false);
        txt_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dateActionPerformed(evt);
            }
        });

        txt_responseId.setEditable(false);

        jLabel6.setText("Response Id");

        jLabel1.setText("Date");

        jLabel2.setText("Client Id");

        jLabel3.setText("Request Subject");

        jLabel4.setText("Response Subject");

        jLabel5.setText("Request Description");

        jLabel7.setText("Response Description");

        txt_userId.setEditable(false);

        txt_requestSubject.setEditable(false);

        txtArea_requestDescrip.setEditable(false);
        txtArea_requestDescrip.setBackground(new java.awt.Color(240, 240, 240));
        txtArea_requestDescrip.setColumns(20);
        txtArea_requestDescrip.setRows(5);
        jScrollPane3.setViewportView(txtArea_requestDescrip);

        txtArea_responseDescrip.setColumns(20);
        txtArea_responseDescrip.setRows(5);
        jScrollPane4.setViewportView(txtArea_responseDescrip);

        btn_response.setText("Response");
        btn_response.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_responseActionPerformed(evt);
            }
        });

        jLabel8.setText("Request Id");

        txt_requestId.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(126, 126, 126)
                                            .addComponent(txt_requestId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(78, 78, 78)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(txt_responseId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_requestSubject, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                                    .addComponent(txt_responseSubject)
                                    .addComponent(txt_userId))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_response)
                .addGap(175, 175, 175))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_responseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_requestId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_requestSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_responseSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_response)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateActionPerformed

    private void btn_responseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_responseActionPerformed
        try {
            BLResponse blresponse = new BLResponse();
            Response response = new Response();

            response.setCurrentDate(txt_date.getText().toString());
            response.setResponseId(Integer.parseInt(txt_responseId.getText()));
            response.setResponseSubject(txt_responseSubject.getText().toString());
            response.setResponseDescrip(txtArea_responseDescrip.getText().toString());
            response.setClientId(Integer.parseInt(txt_userId.getText()));
            response.setRequestId(Integer.parseInt(txt_requestId.getText()));

            blresponse.setResponse(response);
            blresponse.insertResponse();

            JOptionPane.showMessageDialog(null, "The request is responded.");
            setVisible(false);

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }//end catch

    }//GEN-LAST:event_btn_responseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_response;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtArea_requestDescrip;
    private javax.swing.JTextArea txtArea_responseDescrip;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_requestId;
    private javax.swing.JTextField txt_requestSubject;
    private javax.swing.JTextField txt_responseId;
    private javax.swing.JTextField txt_responseSubject;
    private javax.swing.JTextField txt_userId;
    // End of variables declaration//GEN-END:variables
    private businessLayer.BLRequest blrequest;
    private objectFactory.Request request;
}
