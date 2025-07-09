# 🚆 Railway Ticket Booking System (Java Console App)

This is a console-based Railway Ticket Booking System built using Java. It simulates real-world railway reservation logic including **Confirmed Tickets**, **RAC (Reservation Against Cancellation)**, and **Waiting List** management.

---

## 📌 Features

- ✅ Book tickets with automatic berth allocation
- ❌ Cancel tickets and auto-promote passengers from RAC/Waiting List
- 🔁 RAC promotion and WL shifting handled dynamically
- 👤 Each passenger assigned a unique Passenger ID
- 📄 Console menu-driven interface
- 🧠 Designed with OOP and modularity

---

## 🛠 Technologies Used

- Java (Core)
- Collections Framework: `ArrayList`, `Queue`, `LinkedList`
- Console I/O

---

## 📁 Project Structure

```
RailwayBookingSystem/
├── Passenger.java          # Class to store passenger details
├── TicketManager.java      # Core logic for booking, cancellation, RAC, WL
└── RailwayBookingSystem.java  # Main menu and entry point
```

---

## ⚙️ How to Run

1. **Clone this repository**

```bash
git clone https://github.com/Kumaran1903/Railway-Ticket-Booking-System.git

cd Railway-Ticket-Booking-System
```

2. **Compile all Java files**

```bash
javac *.java
```

3. **Run the application**

```bash
java RailwayBookingSystem
```

---

## 🧪 Sample Console Flow

```bash
===== Railway Booking System =====
1. Book Ticket
2. Cancel Ticket
3. View All Tickets
4. Exit
Enter option: 1

Enter passenger name: Ravi
Enter age: 25
✅ Ticket Booked: PassengerID: 1, Name: Ravi, Age: 25, Status: Confirmed
```

---

## 🧠 Internal Logic

| Tier         | Capacity | Data Structure     |
| ------------ | -------- | ------------------ |
| Confirmed    | 3        | ArrayList          |
| RAC          | 1        | Queue (LinkedList) |
| Waiting List | 1        | Queue (LinkedList) |

- When a confirmed ticket is **cancelled**, the first RAC passenger is **promoted to Confirmed**, and the first Waiting List passenger (if any) is **promoted to RAC**.

---
