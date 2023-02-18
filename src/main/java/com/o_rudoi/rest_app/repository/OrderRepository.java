package com.o_rudoi.rest_app.repository;

import com.o_rudoi.rest_app.model.Order;
import com.o_rudoi.rest_app.model.Product;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * Order repository class.
 * Contains methods of operations with orders.
 *
 * @author Oleg Rudoi
 * @version 1.0 18 Feb 2023
 */
@Service
public class OrderRepository {
    /* map with all orders */
    Map<Long, Order> orders = new HashMap<>();

    /* global counter for orders numbering */
    private Long counter = 1L;

    /**
     * Create an order in a repository from a preliminary
     * installed product order. Initialize the required order parameters.
     * The method adds an order to the repository.
     *
     * @param order preliminary installed product order.
     */
    public void create(Order order) {
        Timestamp time = new Timestamp(new Date().getTime());
        long orderID = counter++;
        long productID = 1;

        order.setTime(time);
        order.setId(orderID);
        for (Product product : order.getProducts()) {
            product.setId(productID++);
        }

        orders.put(orderID, order);
    }

    /**
     * returns all the repositories added to the repository.
     *
     * @return List of orders
     */
    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    /**
     * returns orders from repository by id
     *
     * @param id required ID
     * @return order on id
     */
    public Order getById(Long id) {
        return orders.getOrDefault(id, null);
    }
}