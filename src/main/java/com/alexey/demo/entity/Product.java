package com.alexey.demo.entity;


import lombok.*;


import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {


    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name="name_product")
    private String nameProduct;

    @NonNull
    @Column(name = "price")
    private Double price;

    @NonNull
    @Column(name = "size" )
    private Double size;

    @NonNull
    @Column(name = "description")
    private String description;



}
