package com.example.jpaTutorial.jpaTut.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// if we want to change the table name in the db so using the name we can change it easily
//using the uniqueConstraints we can defined the unique constraints

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "product_table" , uniqueConstraints = {
        @UniqueConstraint(name = "sku_unique" , columnNames = {"sku"})
},
        indexes = {
        //this is used to get  request to get it fast
        @Index(name = "sku_index" , columnList = "sku")
        })
public class Product {

    //auto genrated code by the sql we cannot give the id to the db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20 ) // length cannot greater than the 20
    private String sku;


    //when you do not required the name of the column name as same as the entity field name then we use this annotation to change the name
    @Column(name = "product_title", nullable = false)
    private String title;

    private BigDecimal price;

    private Integer quantity;

    @CreationTimestamp // automatically take care by the db
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;


}
