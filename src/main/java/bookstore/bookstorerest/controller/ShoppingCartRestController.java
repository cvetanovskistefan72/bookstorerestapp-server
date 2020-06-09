package bookstore.bookstorerest.controller;


import bookstore.bookstorerest.entity.ShoppingCart;
import bookstore.bookstorerest.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class ShoppingCartRestController {

    @Autowired
    public ShoppingCartService shoppingCartService;


    @PostMapping("")
    public ResponseEntity<?> addShoppingCart(@RequestBody  ShoppingCart shoppingCart){


        shoppingCartService.addShoppingCart(shoppingCart);

        return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getShoppingCart(@PathVariable Long id){


        return new ResponseEntity<ShoppingCart>(shoppingCartService.getSHoppingCart(id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deelteShoppingCart(@PathVariable Long id){


         shoppingCartService.deleteSHoppingCart(id);
    }

    @GetMapping("/status/{username}")
    public ShoppingCart getActiveShoppingCart(@PathVariable String username){


        return shoppingCartService.getCartByStatus(username);
    }


}
