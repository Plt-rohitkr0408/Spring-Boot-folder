package com.example.order.Controller;

import com.example.order.dto.OrderResponse;
import com.example.order.dto.User;
import com.example.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private List<Order> orders  = Arrays.asList(
            new Order(1L, 1L , "Washing Machine",54000.00),
            new Order(2L, 2L , "Laptop",94000.00),
            new Order(3L, 3L , "Cricket kits",7000.00),
            new Order(4L, 4L , "Glass",500.00)
    );

    @GetMapping
    public List<Order> getOrders(){
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrderbyId(@PathVariable Long id){
        return orders.stream()
                .filter(order -> order.getOrderId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/{id}/user")
    public OrderResponse getOrderwithUser( @PathVariable Long id){
       Order order = getOrderbyId(id);

        String url ="http://localhost:8081/api/users/"+ order.getUserId() ;
        ResponseEntity<User> response = restTemplate.getForEntity(url,User.class);
       return new  OrderResponse(order,response.getBody());
    }


}
