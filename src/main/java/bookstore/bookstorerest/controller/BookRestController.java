package bookstore.bookstorerest.controller;


import bookstore.bookstorerest.entity.Book;
import bookstore.bookstorerest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookRestController {

    @Autowired
    public BookService bookService;



    @PostMapping("")
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book, BindingResult bindingResult){

        if(!bindingResult.hasErrors()){
            bookService.saveOrUpdateBook(book);
        }else{
            Map<String,String> errorMap = new HashMap<>();

            for(FieldError fieldError : bindingResult.getFieldErrors()){
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Book>(book,HttpStatus.CREATED);
    }

    @GetMapping("")
    public Iterable<Book> getBooks(){

        return bookService.getBooks();
    }

    @GetMapping("{bookId}")
    public ResponseEntity<?> getSingleBook(@PathVariable  Long bookId){
       Book book= bookService.getSingleBook(bookId);


        return new ResponseEntity<Book>(book,HttpStatus.OK);

    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<String> deleteSingleBook(@PathVariable Long bookId){
        bookService.deleteSingleBook(bookId);

        return new ResponseEntity<String>("Project deleted",HttpStatus.OK);
    }


}
