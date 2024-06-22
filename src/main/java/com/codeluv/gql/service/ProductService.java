package com.codeluv.gql.service;

import com.codeluv.gql.entity.Product;
import com.codeluv.gql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    /**
     * Retrieves a list of all products.
     *
     * @return List of products
     */
    public List<Product> getProducts(){
       return productRepository.findAll();
    }

    /**
     * Retrieves a list of products filtered by the specified category.
     *
     * @param category The category by which to filter products
     * @return List of products matching the category
     */
    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }

    /**
     * Updates the stock quantity of a product with the given ID.
     *
     * @param id   The ID of the product to update
     * @param qty  The new stock quantity
     * @return The updated product
     * @throws RuntimeException if the product with the specified ID is not found
     */
    public Product updateStock(int id, int qty){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id " + id));
        product.setQty(qty);
        return  productRepository.save(product);
    }


}
