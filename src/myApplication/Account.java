/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myApplication;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Kriss
 */
@Entity
@Table(name = "account", catalog = "isp_subscription", schema = "")
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "Account.findByAccountHolderId", query = "SELECT a FROM Account a WHERE a.accountHolderId = :accountHolderId"),
    @NamedQuery(name = "Account.findByAccountHolderName", query = "SELECT a FROM Account a WHERE a.accountHolderName = :accountHolderName"),
    @NamedQuery(name = "Account.findByPaidCheck", query = "SELECT a FROM Account a WHERE a.paidCheck = :paidCheck"),
    @NamedQuery(name = "Account.findByPaidDate", query = "SELECT a FROM Account a WHERE a.paidDate = :paidDate")})
public class Account implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountId")
    private Integer accountId;
    @Basic(optional = false)
    @Column(name = "accountHolderId")
    private int accountHolderId;
    @Basic(optional = false)
    @Column(name = "accountHolderName")
    private String accountHolderName;
    @Basic(optional = false)
    @Column(name = "paidCheck")
    private boolean paidCheck;
    @Basic(optional = false)
    @Column(name = "paidDate")
    @Temporal(TemporalType.DATE)
    private Date paidDate;

    public Account() {
    }

    public Account(Integer accountId) {
        this.accountId = accountId;
    }

    public Account(Integer accountId, int accountHolderId, String accountHolderName, boolean paidCheck, Date paidDate) {
        this.accountId = accountId;
        this.accountHolderId = accountHolderId;
        this.accountHolderName = accountHolderName;
        this.paidCheck = paidCheck;
        this.paidDate = paidDate;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        Integer oldAccountId = this.accountId;
        this.accountId = accountId;
        changeSupport.firePropertyChange("accountId", oldAccountId, accountId);
    }

    public int getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(int accountHolderId) {
        int oldAccountHolderId = this.accountHolderId;
        this.accountHolderId = accountHolderId;
        changeSupport.firePropertyChange("accountHolderId", oldAccountHolderId, accountHolderId);
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        String oldAccountHolderName = this.accountHolderName;
        this.accountHolderName = accountHolderName;
        changeSupport.firePropertyChange("accountHolderName", oldAccountHolderName, accountHolderName);
    }

    public boolean getPaidCheck() {
        return paidCheck;
    }

    public void setPaidCheck(boolean paidCheck) {
        boolean oldPaidCheck = this.paidCheck;
        this.paidCheck = paidCheck;
        changeSupport.firePropertyChange("paidCheck", oldPaidCheck, paidCheck);
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        Date oldPaidDate = this.paidDate;
        this.paidDate = paidDate;
        changeSupport.firePropertyChange("paidDate", oldPaidDate, paidDate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myApplication.Account[ accountId=" + accountId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
