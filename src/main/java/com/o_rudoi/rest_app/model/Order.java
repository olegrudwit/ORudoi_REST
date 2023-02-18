package com.o_rudoi.rest_app.model;

import java.sql.Timestamp;
import java.util.*;

/**
 * Order model class.
 * Contains information about the time the order was created,
 * the list and total cost of the products in the order.
 *
 * @author Oleg Rudoi
 * @version 1.0 18 Feb 2023
 */
public class Order {
    private Long id;

    /* order creation timestamp */
    private Timestamp time;

    /* the total cost of all products in the order */
    private Double cost;

    /* a list of all products in the order */
    private List<Product> products = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Double getCost() {
        updateCurrentCost();
        return cost;
    }

    /**
     * calculates the total cost of all products added to the order
     */
    private void updateCurrentCost() {
        double summ = 0;
        for (Product product :
                products) {
            summ += product.getCost();
        }
        cost = summ;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!Objects.equals(id, order.id)) return false;
        if (!Objects.equals(time, order.time)) return false;
        if (!Objects.equals(cost, order.cost)) return false;
        return Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", time=" + time +
                ", cost=" + cost +
                ", products=" + products +
                '}';
    }
}