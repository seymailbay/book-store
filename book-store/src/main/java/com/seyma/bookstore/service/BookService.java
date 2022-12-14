package com.seyma.bookstore.service;

import com.seyma.bookstore.model.Book;
import com.seyma.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findBookById(Integer bookId){
        return bookRepository.findById(bookId);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
