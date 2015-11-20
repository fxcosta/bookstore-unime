/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.bean;

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
@ManagedBean(name="categoryBean")
@SessionScoped
public class CategoryBean implements Serializable {    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static final long serialVersionUID = 1L;
    
    public List<Category> categories;

    public Category categoryEntity;
    
    private Category selectCategory;
    
    //@ManagedProperty(value="#{BookDao}")
    public CategoryDao dao;
    
    public CategoryBean() {
        dao = new CategoryDao();
        newCatEntity();
    }
    
    @PostConstruct
    public void init() {
        newCatEntity();
    }

    public CategoryDao getDao() {
        return dao;
    }

    public void setDao(CategoryDao dao) {
        this.dao = dao;
    }
    
    public List<Category> getCategories() {
        return dao.getCategories();
    }
    
    public Category getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(Category category) {
        this.categoryEntity = category;
    }
    
    public Category getSelectCategory() {
        return selectCategory;
    }

    public void setSelectCategory(Category category) {
        this.selectCategory = category;
    }
    
    public String save() {
        dao.save(this.categoryEntity);
        newCatEntity();
        return "index?faces-redirect=true";
    }
    
    public String edit() {
        dao.update(this.categoryEntity);
        newCatEntity();
        return "index?faces-redirect=true";
    }
    
    public String create() {
       //newBookEntity();
       return "new?faces-redirect=true";
    }
    
    public String load(Integer id) {
        this.categoryEntity = dao.getById(id);
        return "new?faces-redirect=true&includeViewParams=true";
    }
    
    /**
     * Métodos apenas para teste!
     * @return 
     */
    public String loadWithId() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.categoryEntity = dao.getById(getCountryParam(fc));	
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
        Category b = dao.getById(id);
        if (b != null) {
            dao.delete(b);
        }
    }
    
    public void newCatEntity() {
        this.categoryEntity = new Category();
    }
}
