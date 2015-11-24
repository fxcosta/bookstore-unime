/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookstore.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fx3costa
 */
@Entity
@Table(name = "BookItem")
public class BookItem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "bookId")
    private int bookId;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "time")
    private String time;
    
    @JoinColumn(name = "borrowingId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Borrowing borrowingId;

    public BookItem() {
    }

    public BookItem(Integer id) {
        this.id = id;
    }

    public BookItem(Integer id, int bookId, String status, String time) {
        this.id = id;
        this.bookId = bookId;
        this.status = status;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Borrowing getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Borrowing borrowingId) {
        this.borrowingId = borrowingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookItem)) {
            return false;
        }
        BookItem other = (BookItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.bookstore.entity.BookItem[ id=" + id + " ]";
    }
    
}
