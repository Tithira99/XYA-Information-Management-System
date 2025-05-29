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
@Table(name = "PROJECT", catalog = "", schema = "TITHI1")
@NamedQueries({
    @NamedQuery(name = "Project_1.findAll", query = "SELECT p FROM Project_1 p")
    , @NamedQuery(name = "Project_1.findByProjectno", query = "SELECT p FROM Project_1 p WHERE p.projectno = :projectno")
    , @NamedQuery(name = "Project_1.findByEstimatedcost", query = "SELECT p FROM Project_1 p WHERE p.estimatedcost = :estimatedcost")
    , @NamedQuery(name = "Project_1.findByBegindate", query = "SELECT p FROM Project_1 p WHERE p.begindate = :begindate")
    , @NamedQuery(name = "Project_1.findByExpectedenddate", query = "SELECT p FROM Project_1 p WHERE p.expectedenddate = :expectedenddate")})
public class Project_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROJECTNO")
    private String projectno;
    @Column(name = "ESTIMATEDCOST")
    private Integer estimatedcost;
    @Column(name = "BEGINDATE")
    @Temporal(TemporalType.DATE)
    private Date begindate;
    @Column(name = "EXPECTEDENDDATE")
    @Temporal(TemporalType.DATE)
    private Date expectedenddate;

    public Project_1() {
    }

    public Project_1(String projectno) {
        this.projectno = projectno;
    }

    public String getProjectno() {
        return projectno;
    }

    public void setProjectno(String projectno) {
        String oldProjectno = this.projectno;
        this.projectno = projectno;
        changeSupport.firePropertyChange("projectno", oldProjectno, projectno);
    }

    public Integer getEstimatedcost() {
        return estimatedcost;
    }

    public void setEstimatedcost(Integer estimatedcost) {
        Integer oldEstimatedcost = this.estimatedcost;
        this.estimatedcost = estimatedcost;
        changeSupport.firePropertyChange("estimatedcost", oldEstimatedcost, estimatedcost);
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        Date oldBegindate = this.begindate;
        this.begindate = begindate;
        changeSupport.firePropertyChange("begindate", oldBegindate, begindate);
    }

    public Date getExpectedenddate() {
        return expectedenddate;
    }

    public void setExpectedenddate(Date expectedenddate) {
        Date oldExpectedenddate = this.expectedenddate;
        this.expectedenddate = expectedenddate;
        changeSupport.firePropertyChange("expectedenddate", oldExpectedenddate, expectedenddate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectno != null ? projectno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project_1)) {
            return false;
        }
        Project_1 other = (Project_1) object;
        if ((this.projectno == null && other.projectno != null) || (this.projectno != null && !this.projectno.equals(other.projectno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "package1.Project_1[ projectno=" + projectno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
