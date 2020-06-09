package bookstore.bookstorerest.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cart_status")
    private String cartStatus;


    @Column(name = "cart_created")
    private Date cart_created;


    @Column(name = "cart_closed")
    private Date cart_closed;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "username")
    private String username;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "book_shopping_cart",
            joinColumns = @JoinColumn(name = "shopping_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )

    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    public Date getCart_created() {
        return cart_created;
    }

    public void setCart_created(Date cart_created) {
        this.cart_created = cart_created;
    }

    public Date getCart_closed() {
        return cart_closed;
    }



    public void setCart_closed(Date cart_closed) {
        this.cart_closed = cart_closed;
    }

    public User getUser() {
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBooks(Book book){
        if(books==null){
            books= new ArrayList<>();
        }
        books.add(book);
    }
}
