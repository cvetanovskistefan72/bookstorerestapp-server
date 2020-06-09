package bookstore.bookstorerest.repositories;


import bookstore.bookstorerest.entity.Book;
import bookstore.bookstorerest.entity.ShoppingCart;
import bookstore.bookstorerest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

    ShoppingCart findShoppingCartById(Long id);

    List<ShoppingCart> findShoppingCartsByUser(User user);


}
