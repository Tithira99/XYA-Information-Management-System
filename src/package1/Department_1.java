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
@Table(name = "DEPARTMENT", catalog = "", schema = "TITHI1")
@NamedQueries({
    @NamedQuery(name = "Department_1.findAll", query = "SELECT d FROM Department_1 d")
    , @NamedQuery(name = "Department_1.findByDepartmentname", query = "SELECT d FROM Department_1 d WHERE d.departmentname = :departmentname")
    , @NamedQuery(name = "Department_1.findByTelNo", query = "SELECT d FROM Department_1 d WHERE d.telNo = :telNo")})
public class Department_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEPARTMENTNAME")
    private String departmentname;
    @Column(name = "TEL_NO")
    private String telNo;

    public Department_1() {
    }

    public Department_1(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        String oldDepartmentname = this.departmentname;
        this.departmentname = departmentname;
        changeSupport.firePropertyChange("departmentname", oldDepartmentname, departmentname);
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        String oldTelNo = this.telNo;
        this.telNo = telNo;
        changeSupport.firePropertyChange("telNo", oldTelNo, telNo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentname != null ? departmentname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department_1)) {
            return false;
        }
        Department_1 other = (Department_1) object;
        if ((this.departmentname == null && other.departmentname != null) || (this.departmentname != null && !this.departmentname.equals(other.departmentname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "package1.Department_1[ departmentname=" + departmentname + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
