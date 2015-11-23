/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.bean;

import com.mycompany.bookstore.entity.Book;
import com.mycompany.bookstore.dao.BookDao;
import com.mycompany.bookstore.dao.CategoryDao;
import com.mycompany.bookstore.entity.Category;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author fx3costa
 */
@ManagedBean(name="bookBean")
@SessionScoped
public class BookBean implements Serializable {    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static final long serialVersionUID = 1L;
    
    public List<Book> books;

    public Book bookEntity;
    
    private Book selectBook;
    
    public List<Category> selectCategories;

//    public Category[] getSelectCategories() {
//        return selectCategories;
//    }
//
//    public void setSelectCategories(Category[] selectCategories) {
//        this.selectCategories = selectCategories;
//    }

    public List<Category> getSelectedCategories() {
        return selectCategories;
    }

    public void setSelectedCategories(List<Category> selectedCities) {
        this.selectCategories = selectedCities;
    }
    
    
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
    
    public List<Category> getCategories() {
        return new CategoryDao().getCategories();
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
    
    public String save() throws Exception { 
        //System.out.println(selectCategories.size());
        //this.bookEntity.setCategories(selectCategories);
        dao.save(this.bookEntity);
        newBookEntity();
        return "index?faces-redirect=true";
    }
    
    public String edit() {
        dao.update(this.bookEntity);
        newBookEntity();
        return "index?faces-redirect=true";
    }
    
    public String create() {
       //newBookEntity();
       return "new?faces-redirect=true";
    }
    
    public String load(Integer id) {
        this.bookEntity = dao.getById(id);
        return "new?faces-redirect=true&includeViewParams=true";
    }
    
    /**
     * Métodos apenas para teste!
     * @return 
     */
    public String loadWithId() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.bookEntity = dao.getById(getCountryParam(fc));	
	return "result";
    }
    
    /**
     * Métodos apenas para teste!
     * @return 
     */
    public int getCountryParam(FacesContext fc){	
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        //return params.get("id");
        return 1;
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
