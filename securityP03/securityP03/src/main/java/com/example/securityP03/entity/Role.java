package com.example.securityP03.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable=false)
    private String title;

    private String description;

    public Role(){}

    public Role(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public static RoleBuilder builder(){
        return new RoleBuilder();
    }

    public static class RoleBuilder{
        private String title;
        private String description;

        public RoleBuilder title(String title){
            this.title = title;
            return this;
        }

        public RoleBuilder description(String description){
            this.description = description;
            return this;
        }

        public Role build(){
            return new Role(title,description);
        }
    }

}
