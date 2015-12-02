/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import model.Sale;
import model.Tavoli;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author valentin
 */
@Path("simple")
public class SimpleResource {

    @Context
    private UriInfo context;
    @PersistenceUnit 
    EntityManagerFactory emf;

    /**
     * Creates a new instance of SimpleResource
     */
    public SimpleResource() {
    }

    /**
     * Retrieves representation of an instance of resource.SimpleResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/Json")
    public String getJson() {
        try {
            //TODO return proper representation object
            List<Sale> ls=(List<Sale>)emf.createEntityManager().createNamedQuery("Sale.findAll").getResultList();
            JSONArray ja = new JSONArray();
            
            for(int i=0;i<ls.size();i++){
            List<Tavoli> lt=(List<Tavoli>)emf.createEntityManager().createNamedQuery("Tavoli.findByNumSala").setParameter("numSala", ls.get(i).getNumero()).getResultList();
            JSONObject jo = new JSONObject();
            jo.put("numero", ls.get(i).getNumero());
            jo.put("capienza", ls.get(i).getCapienza());
            //tavoli
            JSONArray jaT = new JSONArray();
                for(int j=0;j<lt.size();j++){
                    JSONObject joT = new JSONObject();
                    joT.put("numero", lt.get(j).getTavoliPK().getNumero());
                    joT.put("num_posti", lt.get(j).getNumPosti());
                    joT.put("stato", lt.get(j).getStato());
                    joT.put("num_commensali",lt.get(j).getNumCommensali() );
                    jaT.put(joT);
                }
            jo.put("tavoli", jaT);
            ja.put(jo);
            }

            
            return ja.toString();
        } catch (JSONException ex) {
            Logger.getLogger(SimpleResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "errore_json";
    }

    /**
     * PUT method for updating or creating an instance of SimpleResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
