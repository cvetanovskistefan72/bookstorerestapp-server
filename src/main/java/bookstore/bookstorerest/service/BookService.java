package bookstore.bookstorerest.service;


import bookstore.bookstorerest.entity.Book;
import bookstore.bookstorerest.entity.Category;
import bookstore.bookstorerest.exceptions.MessageException;
import bookstore.bookstorerest.exceptions.HandleException;
import bookstore.bookstorerest.repositories.BookRepository;
import bookstore.bookstorerest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private HandleException getProjectExceptionResponse;

    @Autowired
    private CategoryRepository categoryRepository;



    public void saveOrUpdateBook(Book book){

        List<Category> books = book.getCategories();
        List<Long> ids = new ArrayList<>();
        book.setCategories(null);
        for(Category category : books){
            ids.add(category.getId());


        }
        for(Long broj : ids) {
            book.addCategories(categoryRepository.findCategoryById(broj));
        }
        bookRepository.save(book);

    }

    public Iterable<Book> getBooks(){


        return bookRepository.findAll();
    }

    public Book getSingleBook(Long id){

        Book book = bookRepository.findBookById(id);
        if(book ==null){
            throw  new MessageException("Book was not found");
        }
        return book;
    }

    public void  deleteSingleBook(Long id){

        Book book = bookRepository.findBookById(id);
        if(book ==null){
            throw  new MessageException("Book was not found");
        }else {
            bookRepository.delete(book);
        }

    }
}
