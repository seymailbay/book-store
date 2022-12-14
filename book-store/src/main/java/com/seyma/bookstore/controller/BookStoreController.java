package com.seyma.bookstore.controller;

import com.seyma.bookstore.dto.BookOrderRequest;
import com.seyma.bookstore.model.Book;
import com.seyma.bookstore.model.Order;
import com.seyma.bookstore.service.BookService;
import com.seyma.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/v1/bookstore")
public class BookStoreController {
    private final OrderService orderService;
    private final BookService bookService;

    public BookStoreController(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }


    @GetMapping
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> bookList=bookService.getAllBooks();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orderList=orderService.getAllOrders();
        return ResponseEntity.ok(orderList);

    }

    @PostMapping
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest){
        Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());

        return ResponseEntity.ok(order);
    }  //JSON olarak yolladığım datayı objeye çeviriyor.
}
