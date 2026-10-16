package com.example.facade.subsystem;

public class InventoryService {
    public boolean checkStock(String itemId, int quantity){
        System.out.println("[InventoryService] Checking stock for item: " + itemId);
        return true;
    }

    public boolean reserveStock(String itemId, int quantity){
        System.out.println("[InventoryService] Reserved " + quantity + " units of item: " + itemId);
        return true;
    }

    public void releaseStock(String itemId, int quantity){
        System.out.println("[InventoryService] Releasing stock reservation (Rollback): " + quantity + " units of item: " + itemId);
    }
}
