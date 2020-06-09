package bookstore.bookstorerest.repositories;


import bookstore.bookstorerest.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin
public interface BookRepository  extends JpaRepository<Book,Long> {

    Book findBookById(Long id);


}

