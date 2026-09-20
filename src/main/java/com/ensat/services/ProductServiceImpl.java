package com.ensat.services;
import com.ensat.entities.Product;
import com.ensat.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service @Transactional
public class ProductServiceImpl implements ProductService {
 private final ProductRepository repo;
 public ProductServiceImpl(ProductRepository repo){this.repo=repo;}
 @Transactional(readOnly=true) public List<Product> listAllProducts(){return repo.findAll();}
 @Transactional(readOnly=true) public Product getProductById(Integer id){return repo.findById(id).orElseThrow(()->new RuntimeException("Product not found with id: "+id));}
 public Product saveProduct(Product p){if(repo.existsByProductId(p.getProductId()))throw new IllegalArgumentException("Product ID already exists: "+p.getProductId());p.setId(null);return repo.save(p);}
 public Product updateProduct(Integer id,Product p){Product e=getProductById(id);if(!e.getProductId().equals(p.getProductId())&&repo.existsByProductId(p.getProductId()))throw new IllegalArgumentException("Product ID already exists: "+p.getProductId());e.setProductId(p.getProductId());e.setName(p.getName());e.setPrice(p.getPrice());return repo.save(e);}
 public void deleteProduct(Integer id){repo.delete(getProductById(id));}
}