/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author User
 */
public class JPAUtils {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GastosPersonalesPU");
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
}
