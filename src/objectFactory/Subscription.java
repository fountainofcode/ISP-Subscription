/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectFactory;

//import objectFactory.Services;

/**
 *
 * @author Kriss
 */
public class Subscription {
    	/*Different attributes of Subscription*/
	private int subscripId;
	private String subscripName ; //=serviceName
	private String expiryDate;      //Will have to be updated expiryDate
        private String duePaid; //See from Account table if paid or unpaid
        private int clientId;
        private int serviceId;
	
        /*Default constructor*/
        public Subscription() {
                this.subscripId = 0;
                //this.subscripName = new objectFactory.Services().getServiceName();
                this.subscripName = "";
                this.expiryDate = "";
                this.duePaid = "";
                this.clientId = 0;
                this.serviceId = 0;
        }
	
    /*Getters and Setters of Subscription*/
        
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

        
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

        
    public int getSubscripId() {
        return subscripId;
    }

    /**
     * @param subscripId the subscripId to set
     */
    
    public void setSubscripId(int subscripId) {
        this.subscripId = subscripId;
    }

    /**
     * @return the subscripName
     */
    public String getSubscripName() {
        return subscripName;
    }

    /**
     * @param subscripName the subscripName to set
     */
    public void setSubscripName(String subscripName) {
        this.subscripName = subscripName;
    }

    
    public String getDuePaid() {
        return duePaid;
    }

    public void setDuePaid(String duePaid) {
        this.duePaid = duePaid;
    }

    
	

}
