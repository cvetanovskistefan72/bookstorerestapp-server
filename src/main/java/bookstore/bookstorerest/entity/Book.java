package bookstore.bookstorerest.entity;


import bookstore.bookstorerest.repositories.BookRepository;
import bookstore.bookstorerest.service.BookService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @NotBlank(message = "Book name required")
    @Column(name = "book_name")
    private String bookName;

    @NotBlank(message = "Book description required")
    @Size(min= 10,message = "Please use minimum 10 characters")
    @Size(max = 200,message = "Maximum 200 characters allowed")
    @Column(name = "description")
    private String description;

    @Min(value = 0,message = "Please enter number of books left")
    @NotNull(message = "Enter a correct number")
    @Column(name = "books_left")
    private int booksLeft;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_at",updatable = false)
    private Date created_At;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @Size(min = 2,message = "Please select minimum two categories")
    private List<Category> categories;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "book_shopping_cart",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "shopping_id")
    )
    @JsonIgnore
    private List<ShoppingCart> shoppingCarts;


    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
        System.out.println(created_At);
    }


    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;

    }

    public int getBooksLeft() {
        return booksLeft;
    }

    public void setBooksLeft(int booksLeft) {
        this.booksLeft = booksLeft;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public void addCategories(Category category){
        if(categories==null){
            categories= new ArrayList<>();
        }
        categories.add(category);
    }
}
