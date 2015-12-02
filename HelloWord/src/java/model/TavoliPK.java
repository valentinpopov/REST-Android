/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author valentin
 */
@Embeddable
public class TavoliPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_SALA")
    private int numSala;

    public TavoliPK() {
    }

    public TavoliPK(int numero, int numSala) {
        this.numero = numero;
        this.numSala = numSala;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numero;
        hash += (int) numSala;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TavoliPK)) {
            return false;
        }
        TavoliPK other = (TavoliPK) object;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.numSala != other.numSala) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TavoliPK[ numero=" + numero + ", numSala=" + numSala + " ]";
    }
    
}
