# Facade Design Pattern — Online Order Processing System

**Course:** ShP-2216 – Software Design Patterns (OP 6B06102)  
**Assignment:** #4 — Facade Pattern  
**Language:** Java (JDK 17)

---

## 📌 Project Overview

This project demonstrates the **Facade Structural Design Pattern** in Java. It models an **Online Order Processing System** where a single high-level interface (`OrderFacade`) simplifies interaction with a complex subsystem consisting of four collaborating services:
1. `InventoryService` — Manages item availability, reservations, and stock rollbacks.
2. `PaymentProcessor` — Handles financial transactions and refunds.
3. `ShippingService` — Schedules product deliveries and generates tracking IDs.
4. `NotificationService` — Dispatches confirmation and error emails to customers.

---

## 🏗 Subsystem & Facade Architecture

The client application interacts **exclusively with `OrderFacade`**[cite: 1]. The subsystem classes remain completely decoupled from the Facade and can still be used directly by advanced clients if needed[cite: 1].

### Key Features
- **Simplified API:** Wraps complex orchestration into a single method `placeOrder(...)`[cite: 1].
- **Transaction Safety & Rollback:** Automatically releases reserved inventory if payment fails[cite: 1].
- **Clean Code Adherence:** Strictly adheres to SRP, Encapsulation, and Meaningful Naming[cite: 1].

---

## 🚀 How to Run

### Prerequisites
- JDK 17 or higher
- IntelliJ IDEA (recommended) or any Java IDE / CLI

### Execution
1. Clone the repository:
   ```bash
   git clone [https://github.com/your-username/facade-pattern-assignment.git](https://github.com/your-username/facade-pattern-assignment.git)
   cd facade-pattern-assignment
   ```
2. Compile and run Main.java:
    ```bash
   javac -d bin src/com/example/facade/subsystem/*.java src/com/example/facade/*.java
    java -cp bin com/example/facade.Main
   ```

## Project Structure
    └── com/example/facade/
    ├── subsystem/
    │   ├── InventoryService.java
    │   ├── PaymentProcessor.java
    │   ├── ShippingService.java
    │   └── NotificationService.java
    ├── OrderFacade.java
    └── Main.java