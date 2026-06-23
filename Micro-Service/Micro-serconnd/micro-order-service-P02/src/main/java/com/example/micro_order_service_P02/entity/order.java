package com.example.micro_order_service_P02.entity;

public class order {
    private Integer orderid;
    private Integer customerid;
    private String orderName;
    private Double orderAmount;

    public order() {
    }

    public order(Integer orderid, Integer customerid, String orderName, Double orderAmount) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.orderName = orderName;
        this.orderAmount = orderAmount;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public  OrderBuilder builder() {
        return new OrderBuilder();
    }

    public static class OrderBuilder{
        private Integer orderid;
        private Integer customerid;
        private String orderName;
        private Double orderAmount;
        public OrderBuilder orderid(Integer orderid) {
            this.orderid = orderid;return  this;
        }

        public OrderBuilder customerid(Integer customerid) {
            this.customerid = customerid;return this;
        }
        public OrderBuilder orderName(String orderName) {
            this.orderName = orderName;return this;
        }
        public OrderBuilder orderAmount(Double orderAmount) {
            this.orderAmount = orderAmount;return this;
        }
        public order build(){
            return new order(orderid,customerid,orderName,orderAmount);
        }
    }


}
