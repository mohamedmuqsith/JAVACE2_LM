# 2.1 Source Code Explanation (Class by Class)

## Core Classes

### **KU00298794_Library**
The central facade of the system. It initializes all services and holds the main data structures (Maps) for books and users.
- **Key Methods**:
  - `addBook(Book)`: Adds to the internal HashMap.
  - `searchBooks(String)`: Iterates through books to find matches by title/author/ISBN.
- **OOP Concepts**: **Encapsulation** (private maps, public accessors).

### **KU00298794_Book**
A model class representing a physical book. It uses the **State Pattern** to manage availability.
- **Key Attributes**: `currentState` (Available/Borrowed/Reserved), `reservationQueue`.
- **Key Methods**: `borrow(User)` delegates to `currentState.borrow()`.

### **KU00298794_User (Abstract)**
Base class for all library members. It uses the **Strategy Pattern** for fine calculation.
- **Key Methods**: `calculateFine(int days)` delegates to the `FineCalculationStrategy`.
- **OOP Concepts**: **Abstraction** (abstract class), **Polymorphism** (subclasses define specific limits).

## Functional Modules

### **Borrowing/Returning**
Handled by `KU00298794_BorrowingService` and `KU00298794_Command` classes.
- **Logic**: When `BorrowCommand` is executed, it calls `service.borrowBook()`, which checks the book's state and user's limit. If successful, it changes the book's state to `BorrowedState` and creates a `BorrowRecord`.

### **Reservations**
Handled by `KU00298794_ReservationService`.
- **Logic**: If a book is borrowed, a user can reserve it. They correspond to a queue in the `Book` object. When returned, the next user in queue is notified (**Observer Pattern**).

### **Fines**
- **Logic**: Calculated based on the `FineCalculationStrategy` (Student: 50/day, Faculty: 20/day) multiplied by overdue days.

## 2.2 Application of OOP Concepts

### **Encapsulation**
All fields in `KU00298794_Book` and `KU00298794_User` are `private`. Access is controlled via public getters/setters (e.g., `getBookId()`, `setTitle()`), protecting the internal state from invalid modifications.

### **Inheritance**
`KU00298794_Student`, `KU00298794_Faculty` extend `KU00298794_User`. They inherit fields like `name` and `id` but implement their own logical constants for limits.

### **Polymorphism**
The `KU00298794_BookState` interface has implementations `AvailableState`, `BorrowedState`. The `Book` class calls `state.borrow()` without knowing the specific implementation, allowing behavior to change dynamically.

### **Abstraction**
Interfaces like `KU00298794_Command` and `KU00298794_Observer` define contracts. The core system relies on these abstractions rather than concrete classes, making it decoupled and extensible.

## 2.3 Use of Data Structures

### **HashMap**
- **Usage**: `Map<String, Book> books`, `Map<String, User> users`.
- **Justification**: Provides **O(1)** average time complexity for lookups. Vital for operations like `getBook(id)` or `getUser(id)` which happen constantly.

### **ArrayList**
- **Usage**: `List<BorrowRecord> history`, `List<Observer> observers`.
- **Justification**: Dynamic resizing allows storing an indefinite number of records. Iteration is fast, which is good for generating reports (`getAllBooks()`).

### **Queue (LinkedList)**
- **Usage**: `Queue<Reservation> reservationQueue` in `Book`.
- **Justification**: Perfectly models a "First-In-First-Out" (FIFO) waiting list for reservations.

### **Entity Classes (New)**
- **Transaction**: Records financial history.
- **Review**: Encapsulates user feedback data.
- **Reservation**: Tracks reservation lifecycle status.
