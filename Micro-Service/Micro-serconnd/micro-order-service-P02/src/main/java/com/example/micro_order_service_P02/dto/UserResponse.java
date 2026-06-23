package com.example.micro_order_service_P02.dto;

public class UserResponse {
    private String name;
    private String email;
    private Integer id;

    public UserResponse(String name, String email, Integer id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    UserResponse() {}
}
