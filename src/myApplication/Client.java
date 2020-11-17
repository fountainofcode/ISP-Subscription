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
@Table(name = "client", catalog = "isp_subscription", schema = "")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = "Client.findByFirstName", query = "SELECT c FROM Client c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Client.findByMiddleName", query = "SELECT c FROM Client c WHERE c.middleName = :middleName"),
    @NamedQuery(name = "Client.findByLastName", query = "SELECT c FROM Client c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Client.findByBlockCode", query = "SELECT c FROM Client c WHERE c.blockCode = :blockCode"),
    @NamedQuery(name = "Client.findByStreetName", query = "SELECT c FROM Client c WHERE c.streetName = :streetName"),
    @NamedQuery(name = "Client.findByCityCode", query = "SELECT c FROM Client c WHERE c.cityCode = :cityCode"),
    @NamedQuery(name = "Client.findByCityName", query = "SELECT c FROM Client c WHERE c.cityName = :cityName"),
    @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email"),
    @NamedQuery(name = "Client.findByStatus", query = "SELECT c FROM Client c WHERE c.status = :status")})
public class Client implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "middleName")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "blockCode")
    private String blockCode;
    @Basic(optional = false)
    @Column(name = "streetName")
    private String streetName;
    @Basic(optional = false)
    @Column(name = "cityCode")
    private String cityCode;
    @Basic(optional = false)
    @Column(name = "cityName")
    private String cityName;
    @Basic(optional = false)
    @Column(name = "telephone")
    private int telephone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Client(Integer id, String firstName, String middleName, String lastName, String blockCode, String streetName, String cityCode, String cityName, int telephone, String email, String status) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.blockCode = blockCode;
        this.streetName = streetName;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        String oldMiddleName = this.middleName;
        this.middleName = middleName;
        changeSupport.firePropertyChange("middleName", oldMiddleName, middleName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(String blockCode) {
        String oldBlockCode = this.blockCode;
        this.blockCode = blockCode;
        changeSupport.firePropertyChange("blockCode", oldBlockCode, blockCode);
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        String oldStreetName = this.streetName;
        this.streetName = streetName;
        changeSupport.firePropertyChange("streetName", oldStreetName, streetName);
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        String oldCityCode = this.cityCode;
        this.cityCode = cityCode;
        changeSupport.firePropertyChange("cityCode", oldCityCode, cityCode);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        String oldCityName = this.cityName;
        this.cityName = cityName;
        changeSupport.firePropertyChange("cityName", oldCityName, cityName);
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        int oldTelephone = this.telephone;
        this.telephone = telephone;
        changeSupport.firePropertyChange("telephone", oldTelephone, telephone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myApplication.Client[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
