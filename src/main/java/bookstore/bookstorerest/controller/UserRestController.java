package bookstore.bookstorerest.controller;


import bookstore.bookstorerest.entity.User;
import bookstore.bookstorerest.exceptions.MessageException;
import bookstore.bookstorerest.service.UserService;
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
@RequestMapping("/users")
@CrossOrigin
public class UserRestController {

    @Autowired
    public UserService userService;



    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){

            if(!userService.checkIfUsernameExists(user.getUsername())){

                userService.createUser(user);
            }else{
                throw  new MessageException("User Exists");
            }
        }else{
            Map<String,String> errorMap = new HashMap<>();

            for(FieldError fieldError : bindingResult.getFieldErrors()){
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>("User Created",HttpStatus.CREATED);
    }

    @PostMapping("/api")
    public ResponseEntity<?> findUserByUsername(@Valid @RequestBody User user,BindingResult bindingResult)
    {
        if(!bindingResult.hasErrors()){


            User user2 = userService.findUserByUsername(user);

            return new ResponseEntity<String>(user2.getUsername(),HttpStatus.OK);

        }else{
            Map<String,String> errorMap = new HashMap<>();

            for(FieldError fieldError : bindingResult.getFieldErrors()){
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("{username}")
    public Long getUserIdByUsername(@PathVariable String username){
        User user = userService.findUserByUsername2(username);

        return user.getId();
    }





}
