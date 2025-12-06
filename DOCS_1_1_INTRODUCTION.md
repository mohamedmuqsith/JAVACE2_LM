# 1.1 Introduction to the System

## Brief Description
The **Smart Library Management System (SLMS)** is a comprehensive software solution designed to modernize traditional library operations. It acts as a central hub for managing the library's catalog, user database, and borrowing transactions.

### Key Users
- **Students**: Can borrow books (limit 3) with standard fine rates.
- **Faculty**: Can borrow books (limit 5) with reduced fine rates and extended due dates.
- **Librarians**: Have administrative privileges to add/remove books and users.
- **Guests**: Limited privileges with higher fine rates.

### Main Operations
- **Book Management**: Adding, removing, and searching for books.
- **Borrowing Cycle**: Borrowing, returning, and reserving books.
- **Fine Calculation**: Automated calculation based on user type and overdue duration.
- **Notifications**: Automated alerts for due dates and reservations.

## Technical Details
- **Programming Language**: Java (JDK 17+)
- **Interface Type**: Command Line Interface (CLI)
- **Architecture**: Modular object-oriented design emphasizing loose coupling.

## Design Patterns Applied
The system demonstrates advanced software design capabilities by integrating six key design patterns:
1.  **Observer Pattern**: For real-time notifications (Email/SMS).
2.  **Strategy Pattern**: For flexible fine calculation logic.
3.  **Builder Pattern**: For constructing complex Book objects.
4.  **Command Pattern**: For encapsulating user actions (Borrow/Return) to enable undo/audit features.
5.  **State Pattern**: For managing book availability (Available -> Borrowed -> Reserved).
6.  **Decorator Pattern**: For dynamically adding features to books (Featured, Recommended).
