package bookstore.bookstorerest.repositories;

import bookstore.bookstorerest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RepositoryRestResource
@CrossOrigin
public interface UserRepository extends JpaRepository<User,Long> {


    User findUserByUsername(String username);

}
