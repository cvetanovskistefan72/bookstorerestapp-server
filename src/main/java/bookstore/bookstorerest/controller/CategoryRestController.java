package bookstore.bookstorerest.controller;


import bookstore.bookstorerest.entity.Book;
import bookstore.bookstorerest.entity.Category;
import bookstore.bookstorerest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping("")
    public ResponseEntity<?> addCategory (@Valid  @RequestBody Category category, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            categoryService.addCategory(category);
        }else{
            Map<String,String> errorMap = new HashMap<>();

            for(FieldError fieldError : bindingResult.getFieldErrors()){
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Category>(category,HttpStatus.CREATED);
    }
    @GetMapping("{categoryId}")
    public Category getSingleCategory(@PathVariable Long categoryId){

        return categoryService.getSingleCategory(categoryId);
    }



    @GetMapping("")
    public  List<Category> getAllCategories(){

        return categoryService.getAllCategories();
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);

        return new ResponseEntity<String>("Category deleted",HttpStatus.OK);
    }
}
