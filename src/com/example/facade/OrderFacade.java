package com.example.facade;

import com.example.facade.subsystem.InventoryService;
import com.example.facade.subsystem.NotificationService;
import com.example.facade.subsystem.PaymentProcessor;
import com.example.facade.subsystem.ShippingService;

public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final NotificationService notificationService;
    private final ShippingService shippingService;

    public OrderFacade(){
        this.inventoryService = new InventoryService();
        this.paymentProcessor = new PaymentProcessor();
        this.notificationService = new NotificationService();
        this.shippingService = new ShippingService();
    }

    public boolean placeOrder(String itemId, int quantity, double price, String accountId, String address, String email){
        System.out.println("\n--- Starting Order Processing Pipeline ---");
        if (!inventoryService.checkStock(itemId, quantity)){
            notificationService.sendEmail(email, "Order failed: Item out of shock.");
            return false;
        }

        inventoryService.reserveStock(itemId, quantity);

        boolean paymentSuccess = paymentProcessor.processPayment(accountId, price * quantity);
        if (!paymentSuccess){
            System.out.println("-> Payment failed. Triggering rollback procedure...");
            inventoryService.releaseStock(itemId, quantity);
            notificationService.sendEmail(email, "Order cancelled: Payment transaction failed.");
            return false;
        }
        String trackingId = shippingService.scheduleDelivery(itemId, address);
        notificationService.sendEmail(email, "Order placed successfully! Tracking ID: " + trackingId);
        System.out.println("--- Order Completed Successfully ---\n");
        return true;
    }
}
