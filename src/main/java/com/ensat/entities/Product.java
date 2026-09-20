package com.ensat.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;
 @Version private Integer version;
 @NotBlank(message="Product ID is required") @Size(max=50) @Column(name="product_id",nullable=false,unique=true,length=50) private String productId;
 @NotBlank(message="Name is required") @Size(max=150) @Column(nullable=false,length=150) private String name;
 @NotNull(message="Price is required") @PositiveOrZero(message="Price must be zero or greater") @Column(nullable=false,precision=12,scale=2) private BigDecimal price;
 public Product(){}
 public Integer getId(){return id;} public void setId(Integer v){id=v;}
 public Integer getVersion(){return version;} public void setVersion(Integer v){version=v;}
 public String getProductId(){return productId;} public void setProductId(String v){productId=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;}
}