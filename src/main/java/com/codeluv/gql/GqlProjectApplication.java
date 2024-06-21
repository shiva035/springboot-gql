package com.codeluv.gql;

import com.codeluv.gql.entity.Product;
import com.codeluv.gql.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class GqlProjectApplication {

	@Autowired
	private ProductRepository productRepository;
	@PostConstruct
	public void initializeDB(){
		List<Product> lp = Stream.of(
				new Product("Laptop", "Electronics", 74999.99f, 50),
				new Product("Smartphone", "Electronics", 39999.99f, 100),
				new Product("Office Chair", "Furniture", 7999.99f, 200),
				new Product("Notebook", "Stationery", 99.99f, 500),
				new Product("Desk Lamp", "Furniture", 1999.99f, 150),
				new Product("Water Bottle", "Accessories", 499.99f, 300)
		).toList();
		productRepository.deleteAll();
		productRepository.saveAll(lp);
	}

	public static void main(String[] args) {
		SpringApplication.run(GqlProjectApplication.class, args);
	}

}
