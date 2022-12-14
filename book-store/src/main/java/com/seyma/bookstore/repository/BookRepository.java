package com.seyma.bookstore.repository;


import com.seyma.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {   // uygulama-veritabanı arası köprüdür.



}
