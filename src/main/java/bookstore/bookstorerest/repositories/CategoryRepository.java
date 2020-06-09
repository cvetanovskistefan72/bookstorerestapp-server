package bookstore.bookstorerest.repositories;

import bookstore.bookstorerest.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findCategoryById(Long id);




}
