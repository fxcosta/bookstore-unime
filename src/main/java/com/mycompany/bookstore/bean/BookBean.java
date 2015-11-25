package com.mycompany.bookstore.bean;

import com.mycompany.bookstore.entity.Book;
import com.mycompany.bookstore.dao.BookDao;
import com.mycompany.bookstore.dao.CategoryDao;
import com.mycompany.bookstore.entity.Category;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
/**
 *
 * @author fx3costa
 */
@ManagedBean(name="bookBean")
@SessionScoped
public class BookBean implements Serializable {    
    
    private static final long serialVersionUID = 1L;
    
    private List<Book> books;
    private List<Book> searchedBooks;
    public Book bookEntity;
    private Book selectBook;
    
    private List<Category> selectCategories;
    
    private List<Category> categoriesDialog;
    
    //@ManagedProperty(value="#{BookDao}")
    public BookDao dao;
    
    public BookBean() {
        dao = new BookDao();
        //newBookEntity();
    }
    
    @PostConstruct
    public void init() {
        newBookEntity();
        //loadBookList();
    }
    
    public List<Book> search(String value){
        searchedBooks = new ArrayList<>();
        for (Book book : books) {
            if(book.getName().toLowerCase().contains(value.toLowerCase())){
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }
    
    private void loadBookList(){
        books = new ArrayList<>();
        books.add(new Book(1, "123456BR", "O Vendedor de Sonhos - O Chamado", 10, "10"));
        books.add(new Book(2, "6666666BR", "O Vendedor de Sonhos - E a Revolução dos Anônimos", 10, "10"));
        books.add(new Book(3, "222222BR", "O Vendedor de Sonhos - O Semeador de Ideias", 10, "10"));
        //Book(Integer id, String isbn, String name, int quantity, String maxTime)
    }
    
    public String save() throws Exception { 
        //System.out.println(selectCategories.size());
        this.bookEntity.setCategories(selectCategories);
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
       newBookEntity();
       return "new?faces-redirect=true";
    }
    
    public String load(Integer id) {
        this.bookEntity = dao.getById(id);
        return "new?faces-redirect=true&includeViewParams=true";
    }
    
    public void callCategoriesDialog(Integer id) {
        this.categoriesDialog = dao.getById(id).getCategories();
        RequestContext.getCurrentInstance().execute("PF('lolDialog').show()");
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

    public List<Book> getBooks() {
        return dao.getBooks();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(Book bookEntity) {
        this.bookEntity = bookEntity;
    }

    public BookDao getDao() {
        return dao;
    }

    public void setDao(BookDao dao) {
        this.dao = dao;
    }

    public List<Book> getSearchedBooks() {
        return searchedBooks;
    }

    public void setSearchedBooks(List<Book> searchedBooks) {
        this.searchedBooks = searchedBooks;
    }

    public Book getSelectBook() {
        return selectBook;
    }

    public void setSelectBook(Book selectBook) {
        this.selectBook = selectBook;
    }

    public List<Category> getSelectCategories() {
        return selectCategories;
    }

    public void setSelectCategories(List<Category> selectCategories) {
        this.selectCategories = selectCategories;
    }
    
    public List<Category> getCategories() {
        return new CategoryDao().getCategories();
    }

    public List<Category> getCategoriesDialog() {
        return categoriesDialog;
    }

    public void setCategoriesDialog(List<Category> categoriesDialog) {
        this.categoriesDialog = categoriesDialog;
    }
    
    
}
