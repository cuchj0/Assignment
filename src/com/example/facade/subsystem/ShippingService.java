package com.example.facade.subsystem;

public class ShippingService {
    public String scheduleDelivery(String itemId, String address){
        String trackingId = "TRACK-" + (System.currentTimeMillis() % 100000);
        System.out.println("[ShippingService] Delivery scheduled to: " + address + ". Tracking ID: " + trackingId);
        return trackingId;
    }
}
