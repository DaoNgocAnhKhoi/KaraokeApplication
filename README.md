# Karaoke Management System

## Overview
This application is a **comprehensive Karaoke Management System** written entirely in **Java**. It is designed to streamline operations in karaoke businesses. The system includes features for managing room bookings, additional services, generating invoices, and processing payments. It enables staff to efficiently manage room statuses (e.g., in use, booked, or available) through an intuitive interface.

---

## Features
### For Customers
- **Room Booking**: Browse and reserve karaoke rooms in real-time.
- **Service Selection**: Add additional services like snacks, drinks, or extra time.
- **Invoice and Payment**: View detailed invoices and complete payments easily.

### For Staff/Administrators
- **Room Management**:
  - Track room statuses: "In Use," "Available," or "Booked."
  - Update room availability and assignments in real-time.
- **Service Management**:
  - Add, edit, or remove services from the system.
  - Manage pricing and service categories.
- **Billing and Payments**:
  - Generate invoices for bookings and additional services.
  - Process payments through various methods (cash, card, or online).
- **Analytics Dashboard**:
  - View insights on room utilization, revenue, and booking trends.
- **User Roles**:
  - Role-based access for staff and administrators.

---

## Tech Stack
- **Java**: Core programming language for the application.
- **Java Swing/JavaFX**: For building the graphical user interface (GUI).
- **JDBC**: For database connectivity.
- **MySQL**: Relational database for managing data.

---

## Installation and Setup

### Prerequisites
- **Java Development Kit (JDK)** (v11+)
- **MySQL Server** (v8+)
- **Maven** (optional for dependency management)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/karaoke-management-system.git
   cd karaoke-management-system
   ```

2. Configure the database:
   - Create a MySQL database for the application.
   - Import the database schema using the provided SQL file (e.g., `database/schema.sql`).

3. Update database connection settings:
   - Open the `connectDB` package.
   - Modify the database connection credentials (e.g., URL, username, password).

4. Compile and run the application:
   ```bash
   javac -d bin src/**/*.java
   java -cp bin gui.MainApp
   ```

---

## File Structure
```
├── connectDB          # Database connection logic
├── dao                # Data Access Objects for CRUD operations
├── entity             # Entity classes representing database tables
├── gui                # Graphical User Interface classes
├── resources          # Additional resources (e.g., images, styles)
└── README.md          # Project documentation
```

---

## Usage
1. **Book a Room**:
   - Use the booking interface to select and reserve a room.
   - Add additional services to the booking.
2. **Manage Rooms**:
   - View and update the status of rooms (e.g., in use, available, or booked).
3. **Generate Invoice**:
   - Automatically calculate and generate invoices for customers.
4. **Analytics**:
   - Access detailed insights on room usage and revenue trends through admin tools.

---

## License
This project is open-source and free to use under the MIT License.

---

## Contact
For any questions or suggestions, feel free to contact [daongocanhkhoi@gmail.com].
