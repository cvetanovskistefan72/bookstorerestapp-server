package bookstore.bookstorerest.service;

import bookstore.bookstorerest.entity.User;
import bookstore.bookstorerest.exceptions.MessageException;
import bookstore.bookstorerest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@Service
@CrossOrigin
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public void createUser(User user){

        userRepository.save(user);
    }

    public boolean checkIfUsernameExists(String username){
        User user = userRepository.findUserByUsername(username);

        if(user==null){
            return false;
        }else{
            return true;
        }
    }


    public User findUserByUsername(User user){
        User user2 = userRepository.findUserByUsername(user.getUsername());

        if(user2==null){
            throw new MessageException("Incorect Username and Password");
        }else if(!user2.getPassword().equals(user.getPassword())){
            throw new MessageException("Incorect Password");
        }else{
            return user2;
        }


    }

    public User findUserByUsername2(String username){

        return userRepository.findUserByUsername(username);
    }


}
