package com.example.practice.services;

import org.springframework.beans.factory.annotation.Autowired;

public class CertificateService {
    private NotificationServices notificationServices;


    // setter Dependency Injection
    @Autowired
    public void setNotificationServices(NotificationServices notificationServices) {
        this.notificationServices = notificationServices;
    }

    public NotificationServices getNotificationServe(){
        return notificationServices;
    }

    public void sendCertificate(){
        System.out.println("Certificate Ready");
        notificationServices.sendNotification();
    }
}
