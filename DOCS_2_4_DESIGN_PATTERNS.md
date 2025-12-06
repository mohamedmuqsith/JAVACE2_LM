# Design Pattern Justification
## Smart Library Management System (SLMS)
### Student ID: KU00298794

---

## Table of Contents
1. [State Pattern](#state-pattern)
2. [Strategy Pattern](#strategy-pattern)
3. [Builder Pattern](#builder-pattern)
4. [Command Pattern](#command-pattern)
5. [Observer Pattern](#observer-pattern)
6. [Decorator Pattern](#decorator-pattern)

---

## State Pattern

### Purpose
The State pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

### Application in SLMS
Books in the library can be in one of three states:
- **Available**: Book can be borrowed
- **Borrowed**: Book is currently checked out
- **Reserved**: Book is reserved for a specific user

### Why This Pattern?
**Requirement**: "Each book has Availability Status (Available, Borrowed, Reserved)"

**Benefits**:
1. **Encapsulates state-specific behavior**: Each state class handles its own logic for borrowing, returning, and reserving
2. **Easy to add new states**: Adding a "Lost" or "Under Maintenance" state requires only adding a new class
3. **Eliminates conditional statements**: No need for complex if-else chains based on status
4. **Type-safe**: Compile-time checking of valid state transitions

### Implementation Classes
- `KU00298794_BookState` (interface)
- `KU00298794_AvailableState`
- `KU00298794_BorrowedState`
- `KU00298794_ReservedState`

### Code Example
```java
// In AvailableState:
public boolean borrow(KU00298794_Book book, KU00298794_User user) {
    book.setState(new KU00298794_BorrowedState());
    return true;
}

// In BorrowedState:
public boolean returnBook(KU00298794_Book book) {
    if (!book.getReservationQueue().isEmpty()) {
        book.setState(new KU00298794_ReservedState());
    } else {
        book.setState(new KU00298794_AvailableState());
    }
    return true;
}
```

### Trade-offs
- **Pros**: Clean code, easy maintenance, extensible
- **Cons**: More classes to manage (acceptable trade-off for this system)

---

## Strategy Pattern

### Purpose
The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

### Application in SLMS
Different user types have different fine calculation strategies:
- **Student**: LKR 50 per day
- **Faculty**: LKR 20 per day
- **Guest**: LKR 100 per day

### Why This Pattern?
**Requirement**: "Membership type affects borrowing limits and overdue fines"

**Benefits**:
1. **Open/Closed Principle**: New membership types can be added without modifying existing code
2. **Single Responsibility**: Each strategy class has one job - calculate fines for its user type
3. **Runtime flexibility**: Strategies can be swapped at runtime if needed
4. **Eliminates conditional logic**: No need for switch statements based on user type

### Implementation Classes
- `KU00298794_FineCalculationStrategy` (interface)
- `KU00298794_StudentFineStrategy` (LKR 50/day)
- `KU00298794_FacultyFineStrategy` (LKR 20/day)
- `KU00298794_GuestFineStrategy` (LKR 100/day)

### Code Example
```java
public class KU00298794_User {
    private KU00298794_FineCalculationStrategy fineStrategy;
    
    public double calculateFine(int daysOverdue) {
        return fineStrategy.calculateFine(daysOverdue);
    }
}

// Student gets StudentFineStrategy injected
KU00298794_Student student = new KU00298794_Student(...);
// Automatically uses StudentFineStrategy: 50 * daysOverdue
double fine = student.calculateFine(5); // LKR 250
```

### Trade-offs
- **Pros**: Highly extensible, clean separation of concerns
- **Cons**: Slightly more complex initial setup (well worth it for maintainability)

---

## Builder Pattern

### Purpose
The Builder pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

### Application in SLMS
Books can have optional metadata:
- Reviews
- Tags
- Edition information
- Multiple other attributes

### Why This Pattern?
**Requirement**: "Create complex book objects with optional metadata such as reviews, tags, or editions"

**Benefits**:
1. **Fluent API**: Chainable method calls make code readable
2. **Immutability**: Can create immutable objects step by step
3. **Validation**: Build() method can validate all required fields are present
4. **Flexibility**: Optional parameters are easy to handle without telescoping constructors

### Implementation Classes
- `KU00298794_BookBuilder`

### Code Example
```java
KU00298794_Book book = new KU00298794_BookBuilder()
    .setBookId("B001")
    .setTitle("Clean Code")
    .setAuthor("Robert C. Martin")
    .setCategory("Programming")
    .setIsbn("978-0132350884")
    .addReview("Excellent for learning best practices")
    .addTag("software-engineering")
    .addTag("best-practices")
    .setEdition("2nd Edition")
    .build();
```

### Trade-offs
- **Pros**: Highly readable, flexible, prevents constructor explosion
- **Cons**: Requires additional builder class (minimal overhead)

---

## Command Pattern

### Purpose
The Command pattern encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

### Application in SLMS
User actions (borrow, return, reserve, cancel) are encapsulated as command objects that can be:
- Executed
- Undone
- Logged for audit trail

### Why This Pattern?
**Requirement**: "Represent user actions like borrow, return, reserve, and cancel reservation as commands that can be logged or undone"

**Benefits**:
1. **Undo/Redo support**: Critical for fixing user mistakes
2. **Logging**: Complete audit trail of all library transactions
3. **Macro commands**: Can combine multiple commands into one
4. **Separation of concerns**: Request logic separated from execution logic
5. **Queueing**: Commands can be queued for later execution

### Implementation Classes
- `KU00298794_Command` (interface)
- `KU00298794_BorrowCommand`
- `KU00298794_ReturnCommand`
- `KU00298794_ReserveCommand`
- `KU00298794_CancelReservationCommand`
- `KU00298794_CommandInvoker`

### Code Example
```java
// Create command
KU00298794_Command borrowCmd = new KU00298794_BorrowCommand(user, book, borrowingService);

// Execute through invoker
library.getCommandInvoker().executeCommand(borrowCmd);

// Later, undo if needed
library.getCommandInvoker().undoLastCommand();
```

### Trade-offs
- **Pros**: Powerful undo mechanism, excellent audit trail, highly flexible
- **Cons**: More classes and indirection (justified by the functionality gained)

---

## Observer Pattern

### Purpose
The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

### Application in SLMS
Users need to be notified about:
- Overdue books and fines
- Reserved books becoming available
- Due date reminders

### Why This Pattern?
**Requirement**: "Notify users about due dates, overdue books, and reserved book availability"

**Benefits**:
1. **Loose coupling**: Notification service doesn't need to know about concrete observer implementations
2. **Dynamic subscription**: Users can be added/removed from notifications at runtime
3. **Multiple notification channels**: Email, SMS, Push notifications can all coexist
4. **Broadcast communication**: One event can notify multiple observers

### Implementation Classes
- `KU00298794_Observer` (interface)
- `KU00298794_NotificationService` (Subject)
- `KU00298794_EmailNotification`
- `KU00298794_SMSNotification`

### Code Example
```java
// Subject
KU00298794_NotificationService notificationService = new KU00298794_NotificationService();

// Attach observers
notificationService.attach(new KU00298794_EmailNotification(userId, email));
notificationService.attach(new KU00298794_SMSNotification(userId, phone));

// Notify all observers
notificationService.notifyOverdue(user, book, fine);
// Both email and SMS notifications are sent automatically
```

### Trade-offs
- **Pros**: Highly decoupled, easy to add new notification types, scalable
- **Cons**: Memory leaks possible if observers not detached (handled properly in implementation)

---

## Decorator Pattern

### Purpose
The Decorator pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

### Application in SLMS
Books can have optional features added dynamically:
- **Featured** (e.g., "Bestseller of the month")
- **Recommended** (with recommender and rating)
- **Special Edition** (with edition type and special features)

### Why This Pattern?
**Requirement**: "Add optional features to book objects, such as 'Featured,' 'Recommended,' or 'Special Edition'"

**Benefits**:
1. **Single Responsibility**: Each decorator adds one specific feature
2. **Open/Closed Principle**: New decorators can be added without modifying existing code
3. **Runtime composition**: Features can be added dynamically
4. **Combination flexibility**: Multiple decorators can be stacked

### Implementation Classes
- `KU00298794_BookDecorator` (abstract base)
- `KU00298794_FeaturedBookDecorator`
- `KU00298794_RecommendedBookDecorator`
- `KU00298794_SpecialEditionDecorator`

### Code Example
```java
KU00298794_Book book = library.getBook("B001");

// Add Featured status
KU00298794_FeaturedBookDecorator featured = 
    new KU00298794_FeaturedBookDecorator(book, "Bestseller!");

// Can stack decorators
KU00298794_RecommendedBookDecorator recommended = 
    new KU00298794_RecommendedBookDecorator(book, "Dr. Smith", 4.8);

// Get enhanced description
System.out.println(featured.getDescription());
// Output: "⭐ FEATURED: 'Clean Code' by Robert C. Martin"
```

### Trade-offs
- **Pros**: Very flexible, avoids class explosion from subclassing
- **Cons**: Can create many small objects (acceptable for this use case)

---

## Summary

All six design patterns work together to create a robust Smart Library Management System:

1. **State Pattern**: Manages book availability lifecycle
2. **Strategy Pattern**: Handles variable fine calculations
3. **Builder Pattern**: Creates complex book objects elegantly
4. **Command Pattern**: Enables undo/redo and audit logging
5. **Observer Pattern**: Implements notification system
6. **Decorator Pattern**: Adds optional book features dynamically

Each pattern was chosen specifically to address requirements in the most maintainable, extensible, and object-oriented way possible.

### Overall Benefits
- **Maintainability**: Changes are isolated to specific classes
- **Extensibility**: New features can be added with minimal changes
- **Testability**: Each pattern can be unit tested independently
- **Readability**: Clear separation of concerns makes code self-documenting
- **Professional Quality**: Follows industry best practices and SOLID principles
