/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.bean;

import com.mycompany.bookstore.entity.Book;
import com.mycompany.bookstore.dao.BookDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author fx3costa
 */
@ManagedBean(name="bookBean")
@ViewScoped
public class BookBean implements Serializable {    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static final long serialVersionUID = 1L;
    
    public List<Book> books;

    public Book bookEntity;
    
    private Book selectBook;
    
    //@ManagedProperty(value="#{BookDao}")
    public BookDao dao;
    
    public BookBean() {
        dao = new BookDao();
        newBookEntity();
    }
    
    @PostConstruct
    public void init() {
        newBookEntity();
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
    
    public Book getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(Book book) {
        this.bookEntity = book;
    }
    
    public Book getSelectBook() {
        return selectBook;
    }

    public void setSelectBook(Book selectBook) {
        this.selectBook = selectBook;
    }
    
    public void save() {
        System.out.println(bookEntity.getName());
        dao.save(this.bookEntity);
        newBookEntity();    
    }
    
    public void edit() {
        dao.update(this.bookEntity);
        newBookEntity();
    }
    
    public void load(Integer id) {
        this.bookEntity = dao.getById(id);
    }
    
    public void remove(Integer id) {
        Book b = dao.getById(id);
        if (b != null) {
            dao.delete(b);
        }
    }
    
    public void newBookEntity() {
        this.bookEntity = new Book();
    }
}
