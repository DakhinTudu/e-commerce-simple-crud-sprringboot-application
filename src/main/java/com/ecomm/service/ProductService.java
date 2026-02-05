package com.ecomm.service;

import com.ecomm.dto.ProductUpdateDto;
import com.ecomm.exception.ProductNotFoundException;
import com.ecomm.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    // In memory Database for storing the products
    private final ArrayList<Product> productDb =new ArrayList<>();

    // idGenerator for product id since Spring Boot Controller classes are Multithreaded
    private final AtomicLong idGenerator  = new AtomicLong(0);


    // BUSINESS LOGICS


    // save product into database
    public Product addProduct(Product product){
            product.setProductId(idGenerator.getAndIncrement());
            productDb.add(product);
            return product;
    }

    // get product by product id
    public Product getProductById(long productId){
        return productDb.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // get all products
    public List<Product> getProducts(){
        return productDb.stream().toList();
    }

    // update product
    public Product update(Long productId, ProductUpdateDto updatedProduct) {

       Product existingProduct = this.getProductById(productId);

        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setProductPrice(updatedProduct.getProductPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());

        return existingProduct;
    }


    // delete product from db
    public void deleteProductById(long productId) {
        Product existingProduct = this.getProductById(productId);
        productDb.remove(existingProduct);
    }


}
