/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author valentin
 */

@Stateless
public class HelloBean {

    public String sayHello(String name) {
        return "hello "+name;
    }

    
}
