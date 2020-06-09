package bookstore.bookstorerest.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

 @ResponseStatus
public class MessageException extends RuntimeException {


    public MessageException(String message) {
        super(message);
    }
}
