package com.example.practice.services;

import org.springframework.beans.factory.annotation.Autowired;

public class ClasssScheduleService {
    @Autowired
    private NotificationServices notificationServices;

    void sendClassSchedule(){
        System.out.println("Class scheduled--");
        notificationServices.sendNotification();
    }


}
