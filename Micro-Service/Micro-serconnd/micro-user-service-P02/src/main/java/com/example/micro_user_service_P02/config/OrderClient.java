//package com.example.micro_user_service_P02.config;
//
//import com.example.micro_user_service_P02.dto.Order;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@FeignClient(name="MICRO-ORDER-SERVICE-P02")
//public interface OrderClient {
//    @GetMapping("/api/order/{id}")
//    List<Order> getOrderbyUserId(@PathVariable Integer id);
//}
