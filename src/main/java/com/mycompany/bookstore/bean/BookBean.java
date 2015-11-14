/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.bean;

import com.mycompany.bookstore.entity.Book;
import com.mycompnay.bookstore.dao.BookDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fx3costa
 */
@ManagedBean(name="bookBean")
@RequestScoped
public class BookBean implements Serializable {    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Book> books;
    
    private Book selectBook;
    
    //@ManagedProperty(value="#{BookDao}")
    public BookDao dao;
    
    public BookBean() {
        
        dao = new BookDao();
        
        books = new ArrayList<>();
        books.add(new Book(1, "3232", "Nome", 23, "43"));
        books.add(new Book(1, "111", "fdfds", 23, "43"));
        books.add(new Book(1, "2444", "fdsfds", 23, "43"));
    }

    public BookDao getDao() {
        return dao;
    }

    public void setDao(BookDao dao) {
        this.dao = dao;
    }
    
    public List<Book> getBooks() {
        return dao.getBooks();
    }
    
    public Book getSelectBook() {
        return selectBook;
    }

    public void setSelectBook(Book selectBook) {
        this.selectBook = selectBook;
    }
}
