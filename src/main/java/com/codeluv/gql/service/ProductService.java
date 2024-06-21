package com.codeluv.gql.service;

import com.codeluv.gql.entity.Product;
import com.codeluv.gql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

//    getProducts getProductsByCategory updateStock

    public List<Product> getProducts(){
       return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public Product updateStock(int id, int qty){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id " + id));
        product.setQty(qty);
        return  productRepository.save(product);
    }


}
