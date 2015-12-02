/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valentin
 */
@Entity
@Table(name = "TAVOLI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tavoli.findUnique", query = "SELECT t FROM Tavoli t WHERE t.tavoliPK.numero = :numero and t.tavoliPK.numSala = :numSala"),
    @NamedQuery(name = "Tavoli.findAll", query = "SELECT t FROM Tavoli t"),
    @NamedQuery(name = "Tavoli.findByNumero", query = "SELECT t FROM Tavoli t WHERE t.tavoliPK.numero = :numero"),
    @NamedQuery(name = "Tavoli.findByNumPosti", query = "SELECT t FROM Tavoli t WHERE t.numPosti = :numPosti"),
    @NamedQuery(name = "Tavoli.findByNumSala", query = "SELECT t FROM Tavoli t WHERE t.tavoliPK.numSala = :numSala")})
public class Tavoli implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TavoliPK tavoliPK;
    @Column(name = "NUM_POSTI")
    private Integer numPosti;
    @Column(name = "STATO")
    private String stato;
    @Column(name = "NUM_COMMENSALI")
    private Integer numCommensali;

    public Tavoli() {
    }

    public Integer getNumCommensali() {
        return numCommensali;
    }

    public void setNumCommensali(Integer numCommensali) {
        this.numCommensali = numCommensali;
    }
    
    
    

    public Tavoli(TavoliPK tavoliPK) {
        this.tavoliPK = tavoliPK;
    }

    public Tavoli(int numero, int numSala) {
        this.tavoliPK = new TavoliPK(numero, numSala);
    }

    public TavoliPK getTavoliPK() {
        return tavoliPK;
    }

    public void setTavoliPK(TavoliPK tavoliPK) {
        this.tavoliPK = tavoliPK;
    }
    
    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Integer getNumPosti() {
        return numPosti;
    }

    public void setNumPosti(Integer numPosti) {
        this.numPosti = numPosti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tavoliPK != null ? tavoliPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tavoli)) {
            return false;
        }
        Tavoli other = (Tavoli) object;
        if ((this.tavoliPK == null && other.tavoliPK != null) || (this.tavoliPK != null && !this.tavoliPK.equals(other.tavoliPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tavoli[ tavoliPK=" + tavoliPK + " ]";
    }
    
}
