package ee.maiko.veebipood.controller;

import ee.maiko.veebipood.entitiy.Product;
import ee.maiko.veebipood.repository.ProductRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Turvaviga, p2ris arendustes seda ei teeks
// @CrossOriging(origins = "https://localhost5137
// @CrossOrigin(origins = "https://www.arvutitark.ee")
@RestController
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    //localhost:8080/products?page=0&size=4&sort=price,asc --> Pageable
    // ?activeCategoryId=0 --> @RequestParam Long activeCategoryId
    @GetMapping("products")
    public Page<Product> getProducts(Pageable pageable, @RequestParam(required = false) Long activeCategoryId) {
        if (activeCategoryId == null || activeCategoryId == 0) {
            return productRepository.findAll(pageable);
        }else{
            return productRepository.findAllByCategoryId(pageable, activeCategoryId);
        }
    }

    @GetMapping("products/admin")
    public List<Product> getAdminProducts(){
        return productRepository.findAll();
    }

    @GetMapping("products/{id}")
    public Product getOneProduct(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("products/{id}")
    public List<Product> deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }
    @PostMapping("products")
    public List<Product> addProduct(@RequestBody Product product){
        if (product.getId()!=null){
            throw new RuntimeException("Cannot add with ID");
        }
        productRepository.save(product);
        return productRepository.findAll();
    }
    @PutMapping("products")
    public List<Product> editProduct(@RequestBody Product product){
        if (product.getId()==null){
            throw new RuntimeException("Cannot edit without ID");
        }
        if (!productRepository.existsById(product.getId())){
            throw new RuntimeException("Product ID does not exist");
        }
        productRepository.save(product);
        return productRepository.findAll();
    }


}
