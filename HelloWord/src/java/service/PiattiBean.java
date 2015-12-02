/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import model.Piatti;

/**
 *
 * @author valentin
 */
@ManagedBean(name ="piattiBean")
@RequestScoped
public class PiattiBean {
    @PersistenceUnit 
    EntityManagerFactory emf;
    
    public Piatti getByNome(String s){
        List<Piatti>lp=(List<Piatti>)emf.createEntityManager().createNamedQuery("Piatti.findByNome").setParameter("nome",s).getResultList();
        if(lp.isEmpty())
               return null;
        else
                return lp.get(0);
    }
    
}
