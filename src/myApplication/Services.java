/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myApplication;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Kriss
 */
@Entity
@Table(name = "services", catalog = "isp_subscription", schema = "")
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findByServiceId", query = "SELECT s FROM Services s WHERE s.serviceId = :serviceId"),
    @NamedQuery(name = "Services.findByServiceName", query = "SELECT s FROM Services s WHERE s.serviceName = :serviceName"),
    @NamedQuery(name = "Services.findByBandwidth", query = "SELECT s FROM Services s WHERE s.bandwidth = :bandwidth"),
    @NamedQuery(name = "Services.findByDuration", query = "SELECT s FROM Services s WHERE s.duration = :duration"),
    @NamedQuery(name = "Services.findByPrice", query = "SELECT s FROM Services s WHERE s.price = :price"),
    @NamedQuery(name = "Services.findByInstallationCost", query = "SELECT s FROM Services s WHERE s.installationCost = :installationCost"),
    @NamedQuery(name = "Services.findBySharingRatio", query = "SELECT s FROM Services s WHERE s.sharingRatio = :sharingRatio"),
    @NamedQuery(name = "Services.findByServiceRemarks", query = "SELECT s FROM Services s WHERE s.serviceRemarks = :serviceRemarks")})
public class Services implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serviceId")
    private Integer serviceId;
    @Basic(optional = false)
    @Column(name = "serviceName")
    private String serviceName;
    @Basic(optional = false)
    @Column(name = "bandwidth")
    private String bandwidth;
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "installationCost")
    private int installationCost;
    @Basic(optional = false)
    @Column(name = "sharingRatio")
    private String sharingRatio;
    @Basic(optional = false)
    @Column(name = "serviceRemarks")
    private String serviceRemarks;

    public Services() {
    }

    public Services(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Services(Integer serviceId, String serviceName, String bandwidth, int duration, int price, int installationCost, String sharingRatio, String serviceRemarks) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.bandwidth = bandwidth;
        this.duration = duration;
        this.price = price;
        this.installationCost = installationCost;
        this.sharingRatio = sharingRatio;
        this.serviceRemarks = serviceRemarks;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        Integer oldServiceId = this.serviceId;
        this.serviceId = serviceId;
        changeSupport.firePropertyChange("serviceId", oldServiceId, serviceId);
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        String oldServiceName = this.serviceName;
        this.serviceName = serviceName;
        changeSupport.firePropertyChange("serviceName", oldServiceName, serviceName);
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        String oldBandwidth = this.bandwidth;
        this.bandwidth = bandwidth;
        changeSupport.firePropertyChange("bandwidth", oldBandwidth, bandwidth);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        int oldDuration = this.duration;
        this.duration = duration;
        changeSupport.firePropertyChange("duration", oldDuration, duration);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        int oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public int getInstallationCost() {
        return installationCost;
    }

    public void setInstallationCost(int installationCost) {
        int oldInstallationCost = this.installationCost;
        this.installationCost = installationCost;
        changeSupport.firePropertyChange("installationCost", oldInstallationCost, installationCost);
    }

    public String getSharingRatio() {
        return sharingRatio;
    }

    public void setSharingRatio(String sharingRatio) {
        String oldSharingRatio = this.sharingRatio;
        this.sharingRatio = sharingRatio;
        changeSupport.firePropertyChange("sharingRatio", oldSharingRatio, sharingRatio);
    }

    public String getServiceRemarks() {
        return serviceRemarks;
    }

    public void setServiceRemarks(String serviceRemarks) {
        String oldServiceRemarks = this.serviceRemarks;
        this.serviceRemarks = serviceRemarks;
        changeSupport.firePropertyChange("serviceRemarks", oldServiceRemarks, serviceRemarks);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myApplication.Services[ serviceId=" + serviceId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
