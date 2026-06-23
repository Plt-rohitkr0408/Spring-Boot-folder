package com.example.micro_order_service_P02.controller;

import com.example.micro_order_service_P02.config.UserClient;
import com.example.micro_order_service_P02.dto.UserResponse;
import com.example.micro_order_service_P02.dto.requestResponse;
import com.example.micro_order_service_P02.entity.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private UserClient userClient;

   List<order> orders = Arrays.asList(
           new order().builder().orderid(1).customerid(1).orderName("Washing machine").orderAmount(45100.00).build(),
           new order().builder().orderid(2).customerid(2).orderName(" Laptop").orderAmount(95500.00).build(),
           new order().builder().customerid(2).orderid(3).orderName("Cricket kits").orderAmount(8540.00).build(),
           new order().builder().orderAmount(65451.00).orderName("Ac").customerid(1).orderid(4).build()
   );

   @GetMapping
    public List<order> getOrders() {
       System.out.println("Calling All orders at port "+   port );
       return orders;
    }

    @GetMapping("/{id}")
    public order getOrderById(@PathVariable Integer id) {
        System.out.println("Calling order by id at port "+   port );
       return orders.stream().filter(order -> order.getOrderid().equals(id)).findFirst().orElse(null);
    }

    @GetMapping("/{id}/user")
    public requestResponse getUserbyOrderId(@PathVariable Integer id) {
       order ord = orders.stream().filter(order -> order.getOrderid().equals(id)).findFirst().orElse(null);
        if(ord == null){
            return null;
        }
        UserResponse userResponse = userClient.getUserById(ord.getCustomerid());
        return  new requestResponse(ord, userResponse);
    }

    @GetMapping("/customer/{id}")
    public UserResponse getUserbyCustomerId(@PathVariable Integer id) {
       UserResponse userResponse = userClient.getUserById(id);
       return userResponse;

   }

}
