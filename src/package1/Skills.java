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
@Table(name = "SKILLS", catalog = "", schema = "TITHI1")
@NamedQueries({
    @NamedQuery(name = "Skills.findAll", query = "SELECT s FROM Skills s")
    , @NamedQuery(name = "Skills.findBySkillid", query = "SELECT s FROM Skills s WHERE s.skillid = :skillid")
    , @NamedQuery(name = "Skills.findBySkillDes", query = "SELECT s FROM Skills s WHERE s.skillDes = :skillDes")})
public class Skills implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SKILLID")
    private String skillid;
    @Column(name = "SKILL_DES")
    private String skillDes;

    public Skills() {
    }

    public Skills(String skillid) {
        this.skillid = skillid;
    }

    public String getSkillid() {
        return skillid;
    }

    public void setSkillid(String skillid) {
        String oldSkillid = this.skillid;
        this.skillid = skillid;
        changeSupport.firePropertyChange("skillid", oldSkillid, skillid);
    }

    public String getSkillDes() {
        return skillDes;
    }

    public void setSkillDes(String skillDes) {
        String oldSkillDes = this.skillDes;
        this.skillDes = skillDes;
        changeSupport.firePropertyChange("skillDes", oldSkillDes, skillDes);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillid != null ? skillid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skills)) {
            return false;
        }
        Skills other = (Skills) object;
        if ((this.skillid == null && other.skillid != null) || (this.skillid != null && !this.skillid.equals(other.skillid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "package1.Skills[ skillid=" + skillid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
