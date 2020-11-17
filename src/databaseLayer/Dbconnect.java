/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseLayer;

import java.sql.*;

/**
 *
 * @author Kriss
 */
public class Dbconnect {
    
	/*Assigning the parameters for database connection*/
	private String username;
	private String password;
	private String host;
	private String port;
	private String dbName;
	private String url;
	/*Parameter for querying the database*/
	private Connection conn;
	
	/*Default constructor*/
	public Dbconnect() {
		this.username = "root";
		this.password = "";
		this.host = "localhost";
		this.port = "3306";
		this.dbName = "isp_subscription";
		this.url = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dbName;
//                jdbc:mysql://localhost:3306/
		this.conn = null;
	}
	
	/*Connecting the database and handling its exception at that time*/
	public Connection connect() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.conn = DriverManager.getConnection(this.url, this.username, this.password);
                        //this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/isp_subscription?zeroDateTimeBehavior=convertToNull", this.username, this.password);
                        
			return this.conn;
			
		}	catch(InstantiationException ex){
				throw ex;
		}	catch(IllegalAccessException ex){
				throw ex;
		}	catch(SQLException ex){
                            throw ex;
		}
	}
	
	/*To disconnect the database*/
	public void disconnect() throws SQLException {
		if(this.conn != null) {
			try{
				this.conn.close();
			}
			catch(SQLException ex){
				throw ex;
			}
		}
	}

    
}
