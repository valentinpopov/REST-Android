/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import model.Ordini;
import model.Tavoli;
import model.TavoliPK;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author valentin
 */
@Path("ordine")
public class OrdineResource {

    @Context
    private UriInfo context;
    @PersistenceContext(unitName = "HelloWordPU")
    private EntityManager em;
    @Resource
    UserTransaction ut;

    /**
     * Creates a new instance of OrdineResource
     */
    public OrdineResource() {
    }

    /**
     * Retrieves representation of an instance of resource.OrdineResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        try {
            Ordini o=new Ordini();
            Date d=new Date();
            o.setOraApertura(d);
            ut.begin();
            em.persist(o);
            ut.commit();
            
            
            List<Ordini> ls=(List<Ordini>)em.createNamedQuery("Ordini.findByOraApertura").setParameter("oraApertura", d).getResultList();
            if(!ls.isEmpty()){
                JSONObject jo = new JSONObject();
            jo.put("id", ls.get(0).getId());
                return jo.toString();
            }
            
        } catch (NotSupportedException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return "error_json";
    }

    /**
     * PUT method for updating or creating an instance of OrdineResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/json")
    public void putJson(String content) {
        System.err.println(content);
        try {
            JSONObject o=new JSONObject(content);
            List<Tavoli> lt=(List<Tavoli>)em.createNamedQuery("Tavoli.findUnique").setParameter("numSala",o.getInt("num_sala")).setParameter("numero",o.getInt("num_tavolo")).getResultList();
            if(!lt.isEmpty()){
                Tavoli t=lt.get(0);
                t.setNumCommensali(o.getInt("num_commensali"));
                t.setStato("occupato");
                ut.begin();
                em.merge(t);
                ut.commit();
            }
        } catch (JSONException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(OrdineResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
