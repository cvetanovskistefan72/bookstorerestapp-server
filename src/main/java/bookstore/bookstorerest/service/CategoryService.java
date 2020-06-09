package bookstore.bookstorerest.service;

import bookstore.bookstorerest.entity.Book;
import bookstore.bookstorerest.entity.Category;
import bookstore.bookstorerest.exceptions.MessageException;
import bookstore.bookstorerest.repositories.BookRepository;
import bookstore.bookstorerest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public void addCategory(Category category)
    {



       categoryRepository.save(category);
    }



    public void deleteCategory(Long id){
        Category category= categoryRepository.findCategoryById(id);
        categoryRepository.delete(category);
    }

    public List<Category> getAllCategories (){

        return categoryRepository.findAll();
    }

    public Category getSingleCategory(Long categoryId){


        Category category= categoryRepository.findCategoryById(categoryId);
            if(category==null){
                throw new MessageException("Category not found");
            }
        return category;
    }


}
