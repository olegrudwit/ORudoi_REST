package com.o_rudoi.rest_app.controller;

import com.o_rudoi.rest_app.model.Order;
import com.o_rudoi.rest_app.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Order controller class.
 * Contains mapped queries from client service.
 *
 * @author Oleg Rudoi
 * @version 1.0 18 Feb 2023
 */
@RestController
@RequestMapping("order")
public class OrderController {

    /* repository object with all orders */
    private final OrderRepository orders = new OrderRepository();

    /**
     * post-method to create a new order
     *
     * @param order mapped Object of HTTP-request
     * @return responce that the object is created
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Order order) {
        orders.create(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * get-method to take all concern order
     *
     * @return List if orders were already created with http-status
     */
    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        final List<Order> ordersList = orders.getAll();
        return ordersList != null && !ordersList.isEmpty()
                ? new ResponseEntity<>(ordersList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * get-method to take needed order
     *
     * @param id id desired order
     * @return order were already created with http-status
     */
    @GetMapping("{id}")
    public ResponseEntity<Order> getOrder(@PathVariable String id) {
        Order order = orders.getById(Long.parseLong(id));
        return order != null
                ? new ResponseEntity<>(order, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}