package com.example.micro_user_service_P02.controller;
//
//import com.example.micro_user_service_P02.config.OrderClient;
//import com.example.micro_user_service_P02.dto.Order;
//import com.example.micro_user_service_P02.dto.RequestResponse;
import com.example.micro_user_service_P02.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
//        @Autowired
//        private OrderClient orderClient;

        @Value("${server.port}")
        private String port;

        List<User>  users= Arrays.asList(
                new User().builder().id(1).name("ABC").email("abc@gmail.com").build(),
                new User().builder().id(2).name("DEF").email("def@gmail.com").build(),
                new User().builder().id(3).name("GHI").email("ghi@gmail.com").build(),
                new User().builder().id(4).name("JKL").email("jkl@gmail.com").build()
        );

        @GetMapping
        public List<User> getAllUsers(){
            System.out.println("All users calling with port "+port);
            return users;
        }

        @GetMapping("/{id}")
        public User getUserById(@PathVariable Integer id){

           System.out.println("User calling with id at port "+port);
            return users.stream()
                    .filter(user -> user.getId().equals(id)).findFirst().orElse(null);
        }


//        @GetMapping("/{id}/orders")
//        public RequestResponse getUsersByOrderId(@PathVariable Integer id){
////            System.out.println("User calling with id at port "+port);
//            User user = users.stream()
//                    .filter(user1 -> user1.getId().equals(id)).findFirst().orElse(null);
//            if(user == null){
//                return null;
//            }
//            List<Order> orderList = orderClient.getOrderbyUserId(user.getId());
//
//            return new RequestResponse(user,orderList);
//        }

}
