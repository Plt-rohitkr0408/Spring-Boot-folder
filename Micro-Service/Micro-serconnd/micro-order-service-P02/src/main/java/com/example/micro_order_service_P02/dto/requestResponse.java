package com.example.micro_order_service_P02.dto;

import com.example.micro_order_service_P02.entity.order;

public class requestResponse {
    private order ord;
    private UserResponse user;
    public order getOrder() {
        return ord;
    }
    public void setOrder(order order) {
        this.ord = order;
    }
    public UserResponse getUser() {
        return user;
    }
    public void setUser(UserResponse user) {
        this.user = user;
    }
    public requestResponse(order ord, UserResponse user) {
        this.ord = ord;
        this.user = user;
    }
}
