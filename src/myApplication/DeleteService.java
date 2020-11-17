/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myApplication;

import businessLayer.BLServices;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import objectFactory.Services;

/**
 *
 * @author Kriss
 */
public class DeleteService extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewServiceList1
     */
    public DeleteService() {
        super("Delete Service");
        initComponents();
        blservices = new BLServices();
        services = new Services();

    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void deleteService() {
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

                    /*Confirming to delete*/
                    int option = JOptionPane.showConfirmDialog(rootPane, "Service Id as: " + jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() + " is going to be deleted.", null, 2);
                    if (option == JOptionPane.OK_OPTION) {
                        try {
                            BLServices blservices = new BLServices();
                            services.setServiceId(num_id);
                            blservices.setServices(services);

                            /*That particular service is deleted*/
                            blservices.deleteServices();

                        }//end try
                        catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
                        }//end catch

                        refreshTable();
                    }//end if
                    else {
                        JOptionPane.getRootFrame();//setVisible(false);
                    }//end else

                    //BLServices blservices = new BLServices();
                    //services.setServiceId(num_id);
                }
            }
            );
        } catch (Exception ex) {
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private businessLayer.BLServices blservices;
    private objectFactory.Services services;
}
