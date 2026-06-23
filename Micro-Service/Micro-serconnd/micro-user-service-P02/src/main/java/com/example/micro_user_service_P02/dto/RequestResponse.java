package com.example.micro_user_service_P02.dto;

import com.example.micro_user_service_P02.entity.User;

import java.util.List;

public class RequestResponse {
    private User user;
    private List<Order> orders;

    public RequestResponse(User user, List<Order> orders) {
        this.user = user;
        this.orders = orders;
    }
}
