package com.ensat.controllers;
import com.ensat.entities.Product;
import com.ensat.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/products") @CrossOrigin(origins="*")
public class ProductController {
 private final ProductService service;
 public ProductController(ProductService service){this.service=service;}
 @GetMapping public List<Product> list(){return service.listAllProducts();}
 @GetMapping("/{id}") public Product get(@PathVariable Integer id){return service.getProductById(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Product create(@Valid @RequestBody Product p){return service.saveProduct(p);}
 @PutMapping("/{id}") public Product update(@PathVariable Integer id,@Valid @RequestBody Product p){return service.updateProduct(id,p);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Integer id){service.deleteProduct(id);}
}