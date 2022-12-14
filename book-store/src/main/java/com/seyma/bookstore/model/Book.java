package com.seyma.bookstore.model;


import jakarta.persistence.*;
import lombok.*;


@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Book {
    @Id  // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)  //1den başlayıp eklendikçe yeni bir id üretir.
    private Integer id;

    private String name;
    private String author;
    private Double price;
    private Integer stock;

}
