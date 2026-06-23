package com.exmaple.Library_Mngt_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer stdId;

    @Column(name="std_name" , length=30 , nullable=false)
    private String stdName;

    @Column(nullable=false, length=30 ,unique=true)
    private String email;

    @Column(name ="phone_no" , nullable=false, length=15)
    private String phoneNo;

    public Student() {
    }

    public Student(Integer stdId, String stdName, String email, String phoneNo) {
        this.stdId = stdId;
        this.stdName = stdName;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public Integer getStdId() {
        return stdId;
    }

    public void setStdId(Integer stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
