package com.example.order.dto;

import com.example.order.model.Order;

public class OrderResponse {

    private Order order;
    private User user;

    OrderResponse(){}
    public OrderResponse(Order order, User user) {
        this.order = order;
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
