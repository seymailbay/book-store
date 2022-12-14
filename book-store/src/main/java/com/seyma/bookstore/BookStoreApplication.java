package com.seyma.bookstore;

import com.seyma.bookstore.model.Book;
import com.seyma.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public BookStoreApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1= Book.builder()
				.name("Yuzuklerin efendisi")
				.author("J.r.r tolkien")
				.price(10.0)
				.stock(10).build();
		Book book2=Book.builder()
				.name("Yeraltından notlar")
				.author("Dostoyevski")
				.price(100.0)
				.stock(3).build();
		Book book3=Book.builder()
				.name("Canterbury Tales")
				.author("Chaucer")
				.price(23.0)
				.stock(2).build();
		bookRepository.saveAll(Arrays.asList(book1,book2,book3));

	}
}
