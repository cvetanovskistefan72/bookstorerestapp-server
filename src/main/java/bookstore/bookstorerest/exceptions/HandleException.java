package bookstore.bookstorerest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice
@RestController
public class HandleException {

    @ExceptionHandler
    public ResponseEntity<Object> responseHandle(MessageException ex){

       ResponseMessage getResponseMessage = new ResponseMessage(ex.getMessage());


        return new ResponseEntity<Object>(getResponseMessage, HttpStatus.BAD_REQUEST);
    }
}
