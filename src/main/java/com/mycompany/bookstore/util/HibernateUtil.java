/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sergio Sa Filho
 * @email code@serginho.org
 * @website www.Serginho.org
 * 
 */
public class HibernateUtil {
    
//    private static EntityManagerFactory factory;
//
//    public HibernateUtil() {
//        if (factory == null) {
//            factory = Persistence.createEntityManagerFactory("generic-dao");
//        }
//    }
//
//    public static EntityManagerFactory getFactory() {
//        return factory;
//    }
//	
//	public EntityManager getEntityManager(){
//            return factory.createEntityManager();		
//	}
    
    private static SessionFactory instance = null;
    
    public static SessionFactory getSessionFactory(){
        if(instance == null)
            createInstance();
        
        return instance;
    }
    
    private synchronized static void createInstance() {
        if(instance != null)
            return;
        
        instance = new Configuration().configure().buildSessionFactory();
    }
    
    private static EntityManagerFactory factory;
    static {
        factory = Persistence.createEntityManagerFactory("generic-dao");
    }
      
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
