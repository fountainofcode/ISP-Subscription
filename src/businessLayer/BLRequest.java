/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLayer;

import java.sql.*;
import databaseLayer.Dbconnect;
import objectFactory.Request;

/**
 *
 * @author Kriss
 */
public class BLRequest {

    private Dbconnect dbcon;
    private Request request;

    /*Default constructor*/
    public BLRequest() {
        this.dbcon = new Dbconnect();
        this.request = new Request();
    }

    /*Getter and setter*/
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    /*Select request that is not responded*/
    public ResultSet selectRequestNotResponded() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryRequestSelect = "SELECT request.currentDate, request.requestId, request.clientId, request.requestSubject, request.requestDescrip\n"
                    + "FROM request\n"
                    + "WHERE request.requestId NOT \n"
                    + "IN (\n"
                    + "\n"
                    + "SELECT response.requestId\n"
                    + "FROM response\n"
                    + ")";
            stat1.executeQuery(qryRequestSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectRequest()

    /*Select the MaxRequestId*/
    public ResultSet selectMaxRequestId() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            Statement stat1 = con.createStatement();

            /*To select*/
            String qryRequestSelect = "select max(requestId) as max_id from request";
            stat1.executeQuery(qryRequestSelect);
            ResultSet rs1 = stat1.getResultSet();
            return rs1;
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end selectRequest()

    /*Insert request's all info*/
    public void insertRequest() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To insert*/
            String qryRequestInsert = "Insert into request (currentDate, requestId, requestSubject, requestDescrip, clientId) values (?, ?, ?, ?, ?)";
            stat1 = con.prepareStatement(qryRequestInsert);

            /*Set all the details from the request class variables to request table attributes*/
            stat1.setString(1, this.request.getCurrentDate());
            stat1.setInt(2, this.request.getRequestId());
            stat1.setString(3, this.request.getRequestSubject());
            stat1.setString(4, this.request.getRequestDescrip());
            stat1.setInt(5, this.request.getClientId());

            stat1.executeUpdate();
            stat1.close();
            this.dbcon.disconnect();

        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end insertRequest()

    /*Update Request*/
    public void updateRequest() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To update*/
            String qryRequestUpdate = "Update request set currentDate = ?, requestId = ?, requestSubject = ?, requestDescrip = ? where requestId = ?";
            stat1 = con.prepareStatement(qryRequestUpdate);
            stat1.executeUpdate(qryRequestUpdate);

            //while(rs.next()) {
            /*Set all the details from the request class variables to request table attributes*/
            stat1.setString(1, this.request.getCurrentDate());
            stat1.setInt(2, this.request.getRequestId());
            stat1.setString(3, this.request.getRequestSubject());
            stat1.setString(4, this.request.getRequestDescrip());

            stat1.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end updateRequest()

    /*Delete Request's attribute values*/
    public void deleteRequest() throws Exception {
        try {
            Connection con = this.dbcon.connect();
            PreparedStatement stat1;

            /*To delete*/
            String qryUserDelete = "Delete from request where requestId = ?";
            stat1 = con.prepareStatement(qryUserDelete);
            stat1.executeUpdate(qryUserDelete);

            /*Set all the details from the services class variables to services table attributes*/
            stat1.setInt(1, this.request.getRequestId());

            stat1.close();
            this.dbcon.disconnect();
        }//end try
        catch (Exception ex) {
            throw ex;
        }//end catch
    }//end deleteRequest()

}
