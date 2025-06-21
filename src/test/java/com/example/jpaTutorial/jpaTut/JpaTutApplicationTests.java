package com.example.jpaTutorial.jpaTut;

import com.example.jpaTutorial.jpaTut.Entity.Product;
import com.example.jpaTutorial.jpaTut.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpaTutApplicationTests {

	@Autowired
	ProductRepo productRepo;
	@Test
	void contextLoads() {
	}


	@Test
	void findByTiitleRepo(){
		List<Product> product1 = productRepo.findByTitle("bis");
		System.out.println(product1);
	}

	@Test
	void AfterDateRepo(){
		List<Product> product1 = productRepo.findByCreatedAtAfter(LocalDateTime.of(2024 , 1 , 01 , 0 ,0 ,0 ));
		System.out.println(product1);
	}

	@Test
	void titleLikeRepo(){
		List<Product> product1 = productRepo.findByTitleContaining("per");
		System.out.println(product1);
	}

	@Test
	void testRepo(){
		Product product = Product.builder()
				.sku("park avenue")
				.title("perfume")
				.price(BigDecimal.valueOf(100))
				.quantity(13)
				.build();

		Product product1 = productRepo.save(product);

		System.out.println(product1);
	}

//	@Test
//	void getRepo(){
//		List<Product> product1 = productRepo.findAll();
//		System.out.println(product1);
//	}



}
