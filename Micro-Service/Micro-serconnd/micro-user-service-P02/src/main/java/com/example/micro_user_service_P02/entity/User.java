package com.example.micro_user_service_P02.entity;

public class User {
    private Integer id;
    private String name;
    private String email;
    User(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


    public UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder {
        private Integer id;
        private String name;
        private String email;

        public UserBuilder id(Integer id) {
            this.id = id;
            return this;
        }
        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this.id, this.name, this.email);
        }
    }
}
