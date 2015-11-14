/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.bookstore.dao;

import com.mycompany.bookstore.entity.Book;
import com.mycompany.bookstore.util.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author fx3costa
 */
public class BookDao extends AbstractDao<Integer, Book> {
    
    //public GenericDAO genericDao;
    public EntityManager em = HibernateUtil.getEntityManager();
    
    public List<Book> getBooks() {
        return super.findAll();
    }
}
