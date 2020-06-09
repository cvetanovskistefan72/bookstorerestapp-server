package bookstore.bookstorerest;

import bookstore.bookstorerest.entity.Book;
import bookstore.bookstorerest.entity.Category;

import bookstore.bookstorerest.entity.User;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import org.springframework.stereotype.Component;

@Component
public class ExposeEntityIdRestMvcConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Book.class, Category.class, User.class);
    }
}