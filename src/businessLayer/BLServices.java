/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLayer;

import java.sql.*;
import databaseLayer.Dbconnect;
import objectFactory.Services;

/**
 *
 * @author Kriss
 */
public class BLServices {

    private Dbconnect dbcon;
    private Services services;

    /*Default constructor of Business Layer*/
    public BLServices() {
        this.dbcon = new Dbconnect();
        this.services = new Services();
    }

    /*Making getter and setter in Business Layer*/
    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    /*Select services' all info*/
    public ResultSet selectServices(int num_id) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryServicesSelect = "select * from services where serviceId = " + num_id;

            stat1.executeQuery(qryServicesSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectServices()

    /*Select all services' all info*/
    public ResultSet selectAllServices() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryAllServicesSelect = "select * from services";
            stat1.executeQuery(qryAllServicesSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectAllServices()

    
    /*Insert services' all info*/
    public void insertServices() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To insert*/
            String qryServicesInsert = "Insert into services (serviceName, bandwidth, duration, price, installationCost, sharingRatio, serviceRemarks) values (?, ?, ?, ?, ?, ?, ?)";
            stat1 = con.prepareStatement(qryServicesInsert);

            /*Set all the details from the services class variables to services table attributes*/
            //stat1.setInt(1, this.services.getServiceId());
            stat1.setString(1, this.services.getServiceName());
            stat1.setString(2, this.services.getBandwidth());
            stat1.setInt(3, this.services.getDuration());
            stat1.setInt(4, this.services.getPrice());
            stat1.setInt(5, this.services.getInstallationCost());
            stat1.setString(6, this.services.getSharingRatio());
            stat1.setString(7, this.services.getServiceRemarks());

            stat1.executeUpdate();
            //int res = stat1.executeUpdate();
            //if (res == 1) {
            //    System.out.println("Record inserted");
            //}
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertServices()

    /*Update services*/
    public void updateServices(int num_id) throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To update*/
            String qryServicesUpdate = "Update services set serviceId = ?, serviceName = ?, bandwidth = ?, duration = ?, price = ?, installationCost = ?, sharingRatio = ?, serviceRemarks = ? where serviceId = " + num_id;
            stat1 = con.prepareStatement(qryServicesUpdate);

            /*Set all the details from the services class variables to services table attributes*/
            stat1.setInt(1, this.services.getServiceId());
            stat1.setString(2, this.services.getServiceName());
            stat1.setString(3, this.services.getBandwidth());
            stat1.setInt(4, this.services.getDuration());
            stat1.setInt(5, this.services.getPrice());
            stat1.setInt(6, this.services.getInstallationCost());
            stat1.setString(7, this.services.getSharingRatio());
            stat1.setString(8, this.services.getServiceRemarks());

            int res = stat1.executeUpdate();
            if (res == 1) {
                System.out.println("Record updated");
            }
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end updateServices()

    /*Delete services's attribute values*/
    public void deleteServices() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To delete*/
            String qryServiceDelete = "Delete from services where serviceId = ?";
            stat1 = con.prepareStatement(qryServiceDelete);

            /*Set all the details from the services class variables to services table attributes*/
            stat1.setInt(1, this.services.getServiceId());
            stat1.executeUpdate();

            stat1.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end deleteServices()

}//end class
