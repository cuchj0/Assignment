package com.example.facade.subsystem;

public class PaymentProcessor {
    public boolean processPayment(String accountId, double amount){
        System.out.println("[PaymentProcessor] Processing payment of $" + amount + " from account " + accountId);
        if (amount>1000){
            System.out.println("[PaymentProcessor] ERROR: Insufficient funds or transaction declined!");
            return false;
        }
        return true;
    }
    public void refundPayment(String accountId, double amount){
        System.out.println("[PaymentProcessor] Refunding $" + amount + " to account " + accountId);
    }
}
