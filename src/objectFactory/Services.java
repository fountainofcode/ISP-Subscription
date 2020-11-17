/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectFactory;

/**
 *
 * @author Kriss
 */
public class Services {
    /*Different attributes of Services*/
	private int serviceId;
	private String serviceName; 
	private String bandwidth;
	private int duration;	//In days
	private int price;	//In NRs
	private int installationCost;	//In NRs
	private String sharingRatio; 
	private String serviceRemarks;
	
	/*Default constructor*/
	public Services() {
		this.serviceId = 0;
		this.serviceName = "";
		this.bandwidth = "";
		this.duration = 0;
		this.price = 0;
		this.installationCost = 0;
		this.sharingRatio = "";
		this.serviceRemarks = "";
	}

	/*Getters of Service*/
	public int getServiceId() {
		return serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getBandwidth() {
		return bandwidth;
	}

	public int getDuration() {
		return duration;
	}

	public int getPrice() {
		return price;
	}

	public int getInstallationCost() {
		return installationCost;
	}

	public String getSharingRatio() {
		return sharingRatio;
	}

	public String getServiceRemarks() {
		return serviceRemarks;
	}

	/*Setters of Service*/
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setInstallationCost(int installationCost) {
		this.installationCost = installationCost;
	}

	public void setSharingRatio(String sharingRatio) {
		this.sharingRatio = sharingRatio;
	}

	public void setServiceRemarks(String serviceRemarks) {
		this.serviceRemarks = serviceRemarks;
	}
	

}
