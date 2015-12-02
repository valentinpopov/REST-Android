/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valentin
 */
@Entity
@Table(name = "SEQUENZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sequenze.findAll", query = "SELECT s FROM Sequenze s"),
    @NamedQuery(name = "Sequenze.findById", query = "SELECT s FROM Sequenze s WHERE s.id = :id"),
    @NamedQuery(name = "Sequenze.findByNumSequenza", query = "SELECT s FROM Sequenze s WHERE s.numSequenza = :numSequenza"),
    @NamedQuery(name = "Sequenze.findByQuantita", query = "SELECT s FROM Sequenze s WHERE s.quantita = :quantita"),
    @NamedQuery(name = "Sequenze.findByNumTavolo", query = "SELECT s FROM Sequenze s WHERE s.numTavolo = :numTavolo"),
    @NamedQuery(name = "Sequenze.findByStato", query = "SELECT s FROM Sequenze s WHERE s.stato = :stato")})
public class Sequenze implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUM_SEQUENZA")
    private Integer numSequenza;
    @Column(name = "QUANTITA")
    private Integer quantita;
    @Column(name = "NUM_TAVOLO")
    private Integer numTavolo;
    @Size(max = 20)
    @Column(name = "STATO")
    private String stato;

    public Sequenze() {
    }

    public Sequenze(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumSequenza() {
        return numSequenza;
    }

    public void setNumSequenza(Integer numSequenza) {
        this.numSequenza = numSequenza;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Integer getNumTavolo() {
        return numTavolo;
    }

    public void setNumTavolo(Integer numTavolo) {
        this.numTavolo = numTavolo;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
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
        if (!(object instanceof Sequenze)) {
            return false;
        }
        Sequenze other = (Sequenze) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sequenze[ id=" + id + " ]";
    }
    
}
