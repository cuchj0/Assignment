package com.example.facade;

public class Main {
    public static void main(String[] args){
        OrderFacade orderFacade = new OrderFacade();

        System.out.println("=== SCENARIO 1: Successfull Order ===");
        orderFacade.placeOrder(
                "LAPTOP-01",
                1,
                800.0,
                "ACC-12345",
                "Dostyk Ave 12. Astana",
                "user@example.com"
        );

        System.out.println("=== SCENARIO 2: Payment Failure (Rollback Triggered) ===");
        orderFacade.placeOrder(
                "PHONE-99",
                2,
                1200.0,
                "ACC-12345",
                "Mangilik El Ave 55, Astana",
                "user@example.com"
        );
    }
}