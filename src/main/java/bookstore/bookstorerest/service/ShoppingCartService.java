package bookstore.bookstorerest.service;


import bookstore.bookstorerest.entity.Book;
import bookstore.bookstorerest.entity.Category;
import bookstore.bookstorerest.entity.ShoppingCart;
import bookstore.bookstorerest.entity.User;
import bookstore.bookstorerest.repositories.BookRepository;
import bookstore.bookstorerest.repositories.ShoppingCartRepository;
import bookstore.bookstorerest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {


    @Autowired
    public ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public UserRepository userRepository;

    public void addShoppingCart(ShoppingCart shoppingCart){



        List<Book> booksFromSc = shoppingCart.getBooks();
        List<Long> ids = new ArrayList<>();
        shoppingCart.setBooks(null);
        List<Long> books = new ArrayList<>();
        for (Book book : booksFromSc) {


            if (!books.contains(book.getId())) {

                books.add(book.getId());
            }
        }



        for(Long bookId : books){
            ids.add(bookId);

        }


        for(Long bookId : ids) {
            shoppingCart.addBooks(bookRepository.findBookById(bookId));
        }

        if(shoppingCart.getCartStatus().equals("submited")){
            for(Long bookId : ids){
                Book book= bookRepository.findBookById(bookId);
                int samples1 = book.getBooksLeft();
                book.setBooksLeft(samples1-1);
            }
        }

        shoppingCart.setUser(userRepository.findUserByUsername(shoppingCart.getUsername()));


        shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart getSHoppingCart(Long id){


        return shoppingCartRepository.findShoppingCartById(id);
    }

    public void deleteSHoppingCart(Long id){


        shoppingCartRepository.delete(shoppingCartRepository.findShoppingCartById(id));
    }

    public ShoppingCart getCartByStatus(String username){
        User user = userRepository.findUserByUsername(username);
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findShoppingCartsByUser(user);


        if(shoppingCarts==null){
            return null;
        }else{
            ShoppingCart shoppingCart2 = null;
             for(ShoppingCart shoppingCart : shoppingCarts){
                 System.out.println(shoppingCart.getCartStatus());
                 if(shoppingCart.getCartStatus().equals("active")){
                     shoppingCart2=shoppingCart;

                 } 
             }
            return shoppingCart2;
        }
          
    }




}
