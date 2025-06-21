package com.example.jpaTutorial.jpaTut.repo;

import com.example.jpaTutorial.jpaTut.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository <Product , Long> {

    List<Product> findByTitle(String bis);

    List<Product> findByCreatedAtAfter(LocalDateTime after);

    List<Product> findByTitleLike(String title);

    List<Product> findByTitleContaining(String title);
}
