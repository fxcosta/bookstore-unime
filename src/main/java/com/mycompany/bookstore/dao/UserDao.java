/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.dao;

import com.mycompany.bookstore.entity.Book;
import com.mycompany.bookstore.entity.Borrowing;
import com.mycompany.bookstore.entity.Category;
import com.mycompany.bookstore.entity.User;
import com.mycompany.bookstore.util.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author fx3costa
 */
public class UserDao extends AbstractDao<Integer, User> {
    
    //public GenericDAO genericDao;
    public EntityManager em = HibernateUtil.getEntityManager();
    
    public List<User> getUsers() {
        return super.findAll();
    }
}
