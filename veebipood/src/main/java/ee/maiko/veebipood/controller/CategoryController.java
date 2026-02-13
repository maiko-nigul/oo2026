package ee.maiko.veebipood.controller;

import ee.maiko.veebipood.entitiy.Category;
import ee.maiko.veebipood.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    //localhost:8080/products
    @GetMapping("categories")
    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }

    @DeleteMapping("categories/{id}")
    public List<Category> deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id); // kustutan
        return categoryRepository.findAll(); // uuenenud seis
    }
    @PostMapping("categories")
    public List<Category> addCategory(@RequestBody Category category){
        categoryRepository.save(category); // siia salvestab
        return categoryRepository.findAll(); // siia uuenenud seis
    }

}
