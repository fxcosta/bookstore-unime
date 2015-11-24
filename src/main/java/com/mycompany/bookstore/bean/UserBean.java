/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.bean;

import com.mycompany.bookstore.dao.CategoryDao;
import com.mycompany.bookstore.dao.UserDao;
import com.mycompany.bookstore.entity.Category;
import com.mycompany.bookstore.entity.User;
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
@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static final long serialVersionUID = 1L;
    
    public List<User> users;

    public User userEntity;
    
    private User selectUser;
    
    //@ManagedProperty(value="#{BookDao}")
    public UserDao dao;
    
    public UserBean() {
        dao = new UserDao();
        newCatEntity();
    }
    
    @PostConstruct
    public void init() {
        newCatEntity();
    }

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
    
    public List<User> getUsers() {
        return dao.getUsers();
    }
    
    public User getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(User user) {
        this.userEntity = user;
    }
    
    public User getSelectUser() {
        return selectUser;
    }

    public void setSelectUser(User user) {
        this.selectUser = user;
    }
    
    public String save() {
        dao.save(this.userEntity);
        newCatEntity();
        return "index?faces-redirect=true";
    }
    
    public String edit() {
        dao.update(this.userEntity);
        newCatEntity();
        return "index?faces-redirect=true";
    }
    
    public String create() {
       //newBookEntity();
       return "new?faces-redirect=true";
    }
    
    public String load(Integer id) {
        this.userEntity = dao.getById(id);
        return "new?faces-redirect=true&includeViewParams=true";
    }
    
    /**
     * Métodos apenas para teste!
     * @return 
     */
    public String loadWithId() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.userEntity = dao.getById(getCountryParam(fc));	
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
        User b = dao.getById(id);
        if (b != null) {
            dao.delete(b);
        }
    }
    
    public void newCatEntity() {
        this.userEntity = new User();
    }
}
