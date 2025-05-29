/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Tithira
 */
@Entity
@Table(name = "EMPLOYEE", catalog = "", schema = "TITHI1")
@NamedQueries({
    @NamedQuery(name = "Employee_1.findAll", query = "SELECT e FROM Employee_1 e")
    , @NamedQuery(name = "Employee_1.findByEmpid", query = "SELECT e FROM Employee_1 e WHERE e.empid = :empid")
    , @NamedQuery(name = "Employee_1.findByEmpname", query = "SELECT e FROM Employee_1 e WHERE e.empname = :empname")
    , @NamedQuery(name = "Employee_1.findByJobtitle", query = "SELECT e FROM Employee_1 e WHERE e.jobtitle = :jobtitle")
    , @NamedQuery(name = "Employee_1.findByDateofbirth", query = "SELECT e FROM Employee_1 e WHERE e.dateofbirth = :dateofbirth")
    , @NamedQuery(name = "Employee_1.findByEmptype", query = "SELECT e FROM Employee_1 e WHERE e.emptype = :emptype")
    , @NamedQuery(name = "Employee_1.findBySalary", query = "SELECT e FROM Employee_1 e WHERE e.salary = :salary")})
public class Employee_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPID")
    private Integer empid;
    @Column(name = "EMPNAME")
    private String empname;
    @Column(name = "JOBTITLE")
    private String jobtitle;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Column(name = "EMPTYPE")
    private String emptype;
    @Column(name = "SALARY")
    private Integer salary;

    public Employee_1() {
    }

    public Employee_1(Integer empid) {
        this.empid = empid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        Integer oldEmpid = this.empid;
        this.empid = empid;
        changeSupport.firePropertyChange("empid", oldEmpid, empid);
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        String oldEmpname = this.empname;
        this.empname = empname;
        changeSupport.firePropertyChange("empname", oldEmpname, empname);
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        String oldJobtitle = this.jobtitle;
        this.jobtitle = jobtitle;
        changeSupport.firePropertyChange("jobtitle", oldJobtitle, jobtitle);
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        Date oldDateofbirth = this.dateofbirth;
        this.dateofbirth = dateofbirth;
        changeSupport.firePropertyChange("dateofbirth", oldDateofbirth, dateofbirth);
    }

    public String getEmptype() {
        return emptype;
    }

    public void setEmptype(String emptype) {
        String oldEmptype = this.emptype;
        this.emptype = emptype;
        changeSupport.firePropertyChange("emptype", oldEmptype, emptype);
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        Integer oldSalary = this.salary;
        this.salary = salary;
        changeSupport.firePropertyChange("salary", oldSalary, salary);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empid != null ? empid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee_1)) {
            return false;
        }
        Employee_1 other = (Employee_1) object;
        if ((this.empid == null && other.empid != null) || (this.empid != null && !this.empid.equals(other.empid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "package1.Employee_1[ empid=" + empid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
