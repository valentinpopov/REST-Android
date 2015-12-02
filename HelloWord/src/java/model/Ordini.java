/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valentin
 */
@Entity
@Table(name = "ORDINI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordini.findAll", query = "SELECT o FROM Ordini o"),
    @NamedQuery(name = "Ordini.findById", query = "SELECT o FROM Ordini o WHERE o.id = :id"),
    @NamedQuery(name = "Ordini.findByOraApertura", query = "SELECT o FROM Ordini o WHERE o.oraApertura = :oraApertura"),
    @NamedQuery(name = "Ordini.findByOraChiusura", query = "SELECT o FROM Ordini o WHERE o.oraChiusura = :oraChiusura")})
public class Ordini implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ORA_APERTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oraApertura;
    @Column(name = "ORA_CHIUSURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oraChiusura;

    public Ordini() {
    }

    public Ordini(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOraApertura() {
        return oraApertura;
    }

    public void setOraApertura(Date oraApertura) {
        this.oraApertura = oraApertura;
    }

    public Date getOraChiusura() {
        return oraChiusura;
    }

    public void setOraChiusura(Date oraChiusura) {
        this.oraChiusura = oraChiusura;
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
        if (!(object instanceof Ordini)) {
            return false;
        }
        Ordini other = (Ordini) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ordini[ id=" + id + " ]";
    }
    
}
