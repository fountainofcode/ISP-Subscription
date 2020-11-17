/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myApplication;

import businessLayer.BLServices;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static myApplication.InsertService.isNumeric;
import objectFactory.Services;

/**
 *
 * @author Kriss
 */
public class UpdateService extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewServiceList1
     */
    public UpdateService() {
        super("Update Service");
        initComponents();
        blservices = new BLServices();
        services = new Services();

    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void updateService_List() {
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
            this.jTable1.setModel(dtm); //Populating values in jTable1

            //jTable1.add(jTable1.getTableHeader(), BorderLayout.CENTER);
            //jTable1.setFillsViewportHeight(true);
            /*Getting the value at selected row and deleting the selected row*/
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());

                    /*Getting the id value of selected row*/
                    String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    int num_id = Integer.parseInt(id);

                    /*Confirming to update*/
                    int option = JOptionPane.showConfirmDialog(rootPane, "Service Id as: " + jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() + " is going to be updated.", null, 2);
                    if (option == JOptionPane.OK_OPTION) {
                        try {
                            BLServices blservices = new BLServices();
                            ResultSet rs = blservices.selectServices(num_id);

                            while (rs.next()) {
                                txt_serviceId.setText(new Integer(rs.getInt("serviceId")).toString());
                                txt_serviceName.setText(rs.getString("serviceName"));
                                txt_bandwidth.setText(rs.getString("bandwidth"));
                                txt_duration.setText(new Integer(rs.getInt("duration")).toString());
                                txt_price.setText(new Integer(rs.getInt("price")).toString());
                                txt_installationCost.setText(new Integer(rs.getInt("installationCost")).toString());
                                txt_sharingRatio.setText(rs.getString("sharingRatio"));
                                txt_serviceRemarks.setText(rs.getString("serviceRemarks"));

                            }

                        }//end try
                        catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
                        }//end catch
                    }//end if
                    else {
                        JOptionPane.getRootFrame();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_bandwidth = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_duration = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_sharingRatio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_serviceId = new javax.swing.JTextField();
        txt_serviceName = new javax.swing.JTextField();
        txt_installationCost = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_serviceRemarks = new javax.swing.JTextArea();
        btn_update = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(594, 643));

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

        jLabel2.setText("Service Name");

        jLabel3.setText("Bandwidth");

        jLabel7.setText("(Max 200 letters)");

        jLabel1.setText("Service Id");

        jLabel8.setText("Sharing Ratio");

        jLabel9.setText("Service Remarks");

        txt_serviceId.setEditable(false);
        txt_serviceId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_serviceIdActionPerformed(evt);
            }
        });

        jLabel4.setText("Duration");

        jLabel5.setText("Price");

        jLabel6.setText("Installation Cost");

        txt_serviceRemarks.setColumns(20);
        txt_serviceRemarks.setRows(5);
        jScrollPane3.setViewportView(txt_serviceRemarks);

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(btn_update)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(151, 151, 151)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel9)
                        .addComponent(jLabel7))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_serviceName, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_sharingRatio, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                            .addComponent(txt_bandwidth)
                                            .addComponent(txt_duration)
                                            .addComponent(txt_price)
                                            .addComponent(txt_installationCost))
                                        .addComponent(txt_serviceId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(8, 8, 8))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(151, 151, 151)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                .addComponent(btn_update)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(230, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_serviceId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_serviceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_bandwidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txt_installationCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_sharingRatio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(80, 80, 80)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_serviceIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_serviceIdActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_serviceIdActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            BLServices blservices = new BLServices();
            services = new objectFactory.Services();

            services.setServiceId(Integer.parseInt(txt_serviceId.getText()));
            services.setServiceName(txt_serviceName.getText());
            services.setBandwidth(txt_bandwidth.getText());

            /*Checking if the strings given are numeric*/
            if (isNumeric(txt_duration.getText().toString()) && isNumeric(txt_price.getText().toString()) && isNumeric(txt_installationCost.getText().toString())) {
                services.setDuration(Integer.parseInt(txt_duration.getText()));

                services.setPrice(Integer.parseInt(txt_price.getText()));
                services.setInstallationCost(Integer.parseInt(txt_installationCost.getText()));
                services.setSharingRatio(txt_sharingRatio.getText());
                services.setServiceRemarks(txt_serviceRemarks.getText());

                blservices.setServices(services);
                blservices.updateServices(Integer.parseInt(txt_serviceId.getText()));

                JOptionPane.showMessageDialog(null, "Service Id as '" + services.getServiceId() + "' is updated.");
                setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "'Duration', 'price' and 'installation cost' should be integer values.");
                JOptionPane.getRootFrame();

            }

        }//end try
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
        }//end catch
    }//GEN-LAST:event_btn_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField txt_bandwidth;
    private javax.swing.JTextField txt_duration;
    private javax.swing.JTextField txt_installationCost;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_serviceId;
    private javax.swing.JTextField txt_serviceName;
    private javax.swing.JTextArea txt_serviceRemarks;
    private javax.swing.JTextField txt_sharingRatio;
    // End of variables declaration//GEN-END:variables
    private businessLayer.BLServices blservices;
    private objectFactory.Services services;
}
