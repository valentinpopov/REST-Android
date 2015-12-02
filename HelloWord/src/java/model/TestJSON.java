/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author valentin
 */
public class TestJSON {
    public static void main(String []Args ){
        try {
            JSONObject jo = new JSONObject();
            jo.put("num_sala", 1);
            jo.put("num_tavolo", 2);
            jo.put("num_commensali", 10);
            jo.put("id_ordine", 10222);
            System.out.println(jo.toString());
        } catch (JSONException ex) {
            Logger.getLogger(TestJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
