package com.ecomm.controller;

import com.ecomm.dto.ProductUpdateDto;
import com.ecomm.model.Product;
import com.ecomm.service.ProductService;
import com.ecomm.until.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@AllArgsConstructor
public class ProductController {

   // DI of the service layer
    private final ProductService productService;

    // contructor is generated with lombok @AllArgsConstructor

    // Create Product into the system
    @PostMapping
    public ResponseEntity<ApiResponse<Product>> addProduct(
            @Valid @RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(
                new ApiResponse<>("Product created succesfully", savedProduct),
                HttpStatus.CREATED
        );
    }

    // Get Product By Product Id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProduct(
            @PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(
                new ApiResponse<>("Product fetched successfully", product)
        );
    }

    // Get All Products
    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {

        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(
                new ApiResponse<>("Products fetched successfully", products)
        );
    }

    // Update Product By Id

    // taking help of ProductUpdateDto since the only few feilds to be updated
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductUpdateDto product) {
        Product updatedProduct = productService.update(id, product);
        return ResponseEntity.ok(
                new ApiResponse<>("Product updated successfully", updatedProduct)
        );
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(
            @PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok(
                new ApiResponse<>("Product deleted successfully", null) // passing null as the product is deleted
        );
    }
}
