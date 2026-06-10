package com.example.practice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private NotificationServices notificationServices;

    void doPayment(){
        System.out.println("Payment Done");
        notificationServices.sendNotification();
    }
}
