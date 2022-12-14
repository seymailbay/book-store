package com.seyma.bookstore.service;

import com.seyma.bookstore.model.Book;
import com.seyma.bookstore.model.Order;
import com.seyma.bookstore.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderService {

    private final BookService bookService;
    private final Logger logger= LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }


    public Order putAnOrder(List<Integer> bookIdList, String userName){
        List<Optional<Book>> bookList = bookIdList.stream()
                .map(bookService::findBookById).collect(Collectors.toList());//her bir kitabın idsini bookliste döndürüyoruz.

        Double totalPrice = bookList.stream()
                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
                .reduce(0.0,Double::sum);

        Order orders= Order.builder()
                .bookIdList(bookIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();
        return orderRepository.save(orders);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
