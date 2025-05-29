/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Tithira
 */
@Entity
@Table(name = "VENDOR", catalog = "", schema = "TITHI1")
@NamedQueries({
    @NamedQuery(name = "Vendor_1.findAll", query = "SELECT v FROM Vendor_1 v")
    , @NamedQuery(name = "Vendor_1.findByVendorid", query = "SELECT v FROM Vendor_1 v WHERE v.vendorid = :vendorid")
    , @NamedQuery(name = "Vendor_1.findByVendorname", query = "SELECT v FROM Vendor_1 v WHERE v.vendorname = :vendorname")
    , @NamedQuery(name = "Vendor_1.findByVendoraddress", query = "SELECT v FROM Vendor_1 v WHERE v.vendoraddress = :vendoraddress")})
public class Vendor_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VENDORID")
    private String vendorid;
    @Basic(optional = false)
    @Column(name = "VENDORNAME")
    private String vendorname;
    @Column(name = "VENDORADDRESS")
    private String vendoraddress;

    public Vendor_1() {
    }

    public Vendor_1(String vendorid) {
        this.vendorid = vendorid;
    }

    public Vendor_1(String vendorid, String vendorname) {
        this.vendorid = vendorid;
        this.vendorname = vendorname;
    }

    public String getVendorid() {
        return vendorid;
    }

    public void setVendorid(String vendorid) {
        String oldVendorid = this.vendorid;
        this.vendorid = vendorid;
        changeSupport.firePropertyChange("vendorid", oldVendorid, vendorid);
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        String oldVendorname = this.vendorname;
        this.vendorname = vendorname;
        changeSupport.firePropertyChange("vendorname", oldVendorname, vendorname);
    }

    public String getVendoraddress() {
        return vendoraddress;
    }

    public void setVendoraddress(String vendoraddress) {
        String oldVendoraddress = this.vendoraddress;
        this.vendoraddress = vendoraddress;
        changeSupport.firePropertyChange("vendoraddress", oldVendoraddress, vendoraddress);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorid != null ? vendorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendor_1)) {
            return false;
        }
        Vendor_1 other = (Vendor_1) object;
        if ((this.vendorid == null && other.vendorid != null) || (this.vendorid != null && !this.vendorid.equals(other.vendorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "package1.Vendor_1[ vendorid=" + vendorid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
