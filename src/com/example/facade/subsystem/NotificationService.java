package com.example.facade.subsystem;

public class NotificationService {
    public void sendEmail(String customerEmail, String message){
        System.out.println("[NotificationService] Email to " + customerEmail + ": " + message);
    }
}
