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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valentin
 */
@Entity
@Table(name = "PIATTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piatti.findAll", query = "SELECT p FROM Piatti p"),
    @NamedQuery(name = "Piatti.findByNome", query = "SELECT p FROM Piatti p WHERE p.nome = :nome"),
    @NamedQuery(name = "Piatti.findByPrezzo", query = "SELECT p FROM Piatti p WHERE p.prezzo = :prezzo"),
    @NamedQuery(name = "Piatti.findByFoto", query = "SELECT p FROM Piatti p WHERE p.foto = :foto")})
public class Piatti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PREZZO")
    private Float prezzo;
    @Size(max = 50)
    @Column(name = "FOTO")
    private String foto;
    @Size(max = 100)
    @Column(name = "descrizione")
    private String descrizione;
    @Size(max = 50)
    @Column(name = "tipo")
    private String tipo;

    public Piatti() {
    }

    public Piatti(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Float prezzo) {
        this.prezzo = prezzo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piatti)) {
            return false;
        }
        Piatti other = (Piatti) object;
        if ((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Piatti[ nome=" + nome + " ]";
    }
    
}
