# Smart Library Management System - UML Class Diagram Summary (KU00298794)

## 📊 All Classes Overview

| # | Class Name | Type | Package | Pattern |
|---|------------|------|---------|---------|
| 1 | KU00298794_User | Abstract | model | - |
| 2 | KU00298794_Student | Class | model | - |
| 3 | KU00298794_Faculty | Class | model | - |
| 4 | KU00298794_Guest | Class | model | - |
| 5 | KU00298794_Book | Class | model | - |
| 6 | KU00298794_Librarian | Class | model | - |
| 7 | KU00298794_BorrowRecord | Class | model | - |
| 8 | KU00298794_Reservation | Class | model | - |
| 9 | KU00298794_Transaction | Class | model | - |
| 10 | KU00298794_Review | Class | model | - |
| 11 | KU00298794_Library | Class | library | - |
| 12 | KU00298794_Observer | Interface | observer | Observer |
| 13 | KU00298794_NotificationService | Class | observer | Observer (Subject) |
| 14 | KU00298794_EmailNotification | Class | observer | Observer |
| 15 | KU00298794_SMSNotification | Class | observer | Observer |
| 16 | KU00298794_FineCalculationStrategy | Interface | strategy | Strategy |
| 17 | KU00298794_StudentFineStrategy | Class | strategy | Strategy |
| 18 | KU00298794_FacultyFineStrategy | Class | strategy | Strategy |
| 19 | KU00298794_GuestFineStrategy | Class | strategy | Strategy |
| 20 | KU00298794_BookState | Interface | state | State |
| 21 | KU00298794_AvailableState | Class | state | State |
| 22 | KU00298794_BorrowedState | Class | state | State |
| 23 | KU00298794_ReservedState | Class | state | State |
| 24 | KU00298794_BookBuilder | Class | builder | Builder |
| 25 | KU00298794_Command | Interface | command | Command |
| 26 | KU00298794_BorrowCommand | Class | command | Command |
| 27 | KU00298794_ReturnCommand | Class | command | Command |
| 28 | KU00298794_ReserveCommand | Class | command | Command |
| 29 | KU00298794_CancelReservationCommand | Class | command | Command |
| 30 | KU00298794_CommandInvoker | Class | command | Command (Invoker) |
| 31 | KU00298794_BookDecorator | Abstract | decorator | Decorator |
| 32 | KU00298794_FeaturedBookDecorator | Class | decorator | Decorator |
| 33 | KU00298794_RecommendedBookDecorator | Class | decorator | Decorator |
| 34 | KU00298794_SpecialEditionDecorator | Class | decorator | Decorator |
| 35 | KU00298794_BorrowingService | Class | service | - |
| 36 | KU00298794_ReservationService | Class | service | - |
| 37 | KU00298794_ReportService | Class | service | - |
| 38 | KU00298794_LibraryCLI | Class | ui | - |

---

## 🎯 Design Patterns Summary

| # | Pattern | Interface/Abstract | Concrete Classes | Purpose |
|---|---------|-------------------|------------------|---------|
| 1 | **Observer** | KU00298794_Observer | EmailNotification, SMSNotification, NotificationService (Subject) | Notifications |
| 2 | **Strategy** | KU00298794_FineCalculationStrategy | StudentFineStrategy, FacultyFineStrategy, GuestFineStrategy | Fine calculation |
| 3 | **State** | KU00298794_BookState | AvailableState, BorrowedState, ReservedState | Book availability |
| 4 | **Builder** | - | KU00298794_BookBuilder | Book creation |
| 5 | **Command** | KU00298794_Command | BorrowCommand, ReturnCommand, ReserveCommand, CancelReservationCommand, CommandInvoker | User actions |
| 6 | **Decorator** | KU00298794_BookDecorator | FeaturedBookDecorator, RecommendedBookDecorator, SpecialEditionDecorator | Extended features |

---

## 📝 Class Attributes

### Core Domain Classes

| Class | Attributes |
|-------|------------|
| **KU00298794_User** | userId, name, email, contactNumber, membershipType, borrowedBooks, transactionHistory, fineStrategy |
| **KU00298794_Student** | borrowingLimit=3, dueDays=14 |
| **KU00298794_Faculty** | borrowingLimit=5, dueDays=30 |
| **KU00298794_Guest** | borrowingLimit=1, dueDays=7 |
| **KU00298794_Book** | bookId, title, author, category, isbn, currentState, borrowedHistory, reservationQueue, reviews, tags, edition |
| **KU00298794_Librarian** | librarianId, name, email |
| **KU00298794_BorrowRecord** | user, book, borrowDate, dueDate, returnDate, fineAmount |
| **KU00298794_Reservation** | reservationId, user, book, reservationDate, status |
| **KU00298794_Transaction** | transactionId, user, amount, date, type |
| **KU00298794_Review** | reviewerName, rating, comment, date |
| **KU00298794_Library** | books, users, librarians, borrowingService, reservationService, reportService, notificationService, commandInvoker |

### Pattern Classes

| Class | Attributes |
|-------|------------|
| **KU00298794_NotificationService** | observers: List |
| **KU00298794_EmailNotification** | email, userId |
| **KU00298794_SMSNotification** | phoneNumber, userId |
| **KU00298794_StudentFineStrategy** | FINE_RATE = 50.0 |
| **KU00298794_FacultyFineStrategy** | FINE_RATE = 20.0 |
| **KU00298794_GuestFineStrategy** | FINE_RATE = 100.0 |
| **KU00298794_BookBuilder** | bookId, title, author, category, isbn, reviews, tags, edition |
| **KU00298794_BorrowCommand** | user, book, service, executed |
| **KU00298794_CommandInvoker** | commandHistory: List |
| **KU00298794_BookDecorator** | decoratedBook |
| **KU00298794_FeaturedBookDecorator** | featuredReason |
| **KU00298794_RecommendedBookDecorator** | recommendedBy, rating |
| **KU00298794_SpecialEditionDecorator** | editionType, specialFeatures |

### Service Classes

| Class | Attributes |
|-------|------------|
| **KU00298794_BorrowingService** | library, notificationService, activeBorrowings |
| **KU00298794_ReservationService** | library, notificationService, reservations |
| **KU00298794_ReportService** | library |
| **KU00298794_LibraryCLI** | library, scanner, running |

---

## 🔧 Class Methods

### KU00298794_User (Abstract)

| Method | Return Type |
|--------|-------------|
| getId() | String |
| getName() | String |
| getEmail() | String |
| getContactNumber() | String |
| getMembershipType() | String |
| getBorrowedBooks() | List |
| addBorrowRecord(record) | void |
| removeBorrowRecord(record) | void |
| getTransactionHistory() | List |
| payFine(amount) | void |
| getFineStrategy() | FineCalculationStrategy |
| calculateFine(daysOverdue) | double |
| getBorrowingLimit() | int (abstract) |
| getDueDays() | int (abstract) |

### KU00298794_Book

| Method | Return Type |
|--------|-------------|
| getBookId() | String |
| getTitle() | String |
| getAuthor() | String |
| getCategory() | String |
| getIsbn() | String |
| getState() | BookState |
| setState(state) | void |
| getBorrowedHistory() | List |
| addBorrowRecord(record) | void |
| getReservationQueue() | Queue |
| addReservation(user) | void |
| getNextReserver() | User |
| borrow(user) | boolean |
| returnBook() | boolean |
| reserve(user) | boolean |
| getDescription() | String |
| setReviews(reviews) | void |
| getReviews() | List |
| setTags(tags) | void |
| getTags() | List |
| setEdition(edition) | void |
| getEdition() | String |

### KU00298794_Library

| Method | Return Type |
|--------|-------------|
| addBook(book) | void |
| removeBook(bookId) | void |
| getBook(bookId) | Book |
| getAllBooks() | List |
| searchBooks(query) | List |
| addUser(user) | void |
| removeUser(userId) | void |
| getUser(userId) | User |
| getAllUsers() | List |
| addLibrarian(librarian) | void |
| getLibrarian(librarianId) | Librarian |
| getBorrowingService() | BorrowingService |
| getReservationService() | ReservationService |
| getReportService() | ReportService |
| getNotificationService() | NotificationService |
| getCommandInvoker() | CommandInvoker |

### KU00298794_BorrowingService

| Method | Return Type |
|--------|-------------|
| borrowBook(user, book) | boolean |
| returnBook(user, book) | boolean |
| calculateDueDate(user, borrowDate) | Date |
| calculateFine(record) | double |
| checkOverdueBooks() | List |
| getActiveBorrowings() | Map |

### KU00298794_ReservationService

| Method | Return Type |
|--------|-------------|
| reserveBook(user, book) | boolean |
| cancelReservation(user, book) | boolean |
| processReturnedBook(book) | void |
| getNextReserver(book) | User |
| getReservations() | Map |

### KU00298794_ReportService

| Method | Return Type |
|--------|-------------|
| generateMostBorrowedBooks(limit) | List |
| generateActiveBorrowers(limit) | List |
| generateOverdueBooks() | List |
| generateRevenueReport() | double |
| printMostBorrowedBooksReport(limit) | void |
| printActiveBorrowersReport(limit) | void |
| printOverdueBooksReport() | void |

---

## 🔗 Relationships

### Inheritance (extends)

| Parent Class | Child Class |
|--------------|-------------|
| KU00298794_User | KU00298794_Student |
| KU00298794_User | KU00298794_Faculty |
| KU00298794_User | KU00298794_Guest |
| KU00298794_BookDecorator | KU00298794_FeaturedBookDecorator |
| KU00298794_BookDecorator | KU00298794_RecommendedBookDecorator |
| KU00298794_BookDecorator | KU00298794_SpecialEditionDecorator |

### Implementation (implements)

| Interface | Implementing Class |
|-----------|-------------------|
| KU00298794_Observer | KU00298794_EmailNotification |
| KU00298794_Observer | KU00298794_SMSNotification |
| KU00298794_FineCalculationStrategy | KU00298794_StudentFineStrategy |
| KU00298794_FineCalculationStrategy | KU00298794_FacultyFineStrategy |
| KU00298794_FineCalculationStrategy | KU00298794_GuestFineStrategy |
| KU00298794_BookState | KU00298794_AvailableState |
| KU00298794_BookState | KU00298794_BorrowedState |
| KU00298794_BookState | KU00298794_ReservedState |
| KU00298794_Command | KU00298794_BorrowCommand |
| KU00298794_Command | KU00298794_ReturnCommand |
| KU00298794_Command | KU00298794_ReserveCommand |
| KU00298794_Command | KU00298794_CancelReservationCommand |

### Aggregation (has-a)

| Container | Component | Multiplicity | Description |
|-----------|-----------|--------------|-------------|
| KU00298794_User | KU00298794_FineCalculationStrategy | 1 : 1 | User has a fine strategy |
| KU00298794_Book | KU00298794_BookState | 1 : 1 | Book has a state |
| KU00298794_NotificationService | KU00298794_Observer | 1 : 0..* | Subject has observers |
| KU00298794_CommandInvoker | KU00298794_Command | 1 : 0..* | Invoker stores commands |
| KU00298794_BookDecorator | KU00298794_Book | 1 : 1 | Decorator wraps book |

### Composition (contains)

| Container | Component | Multiplicity |
|-----------|-----------|--------------|
| KU00298794_Library | KU00298794_Book | 1 : 0..* |
| KU00298794_Library | KU00298794_User | 1 : 0..* |
| KU00298794_Library | KU00298794_Librarian | 1 : 0..* |

### Association (uses/references)

| From Class | To Class | Relationship |
|------------|----------|--------------|
| KU00298794_User | KU00298794_BorrowRecord | has (1 : 0..*) |
| KU00298794_User | KU00298794_Transaction | pays (1 : 0..*) |
| KU00298794_Book | KU00298794_BorrowRecord | history (1 : 0..*) |
| KU00298794_Book | KU00298794_Reservation | queue (1 : 0..*) |
| KU00298794_Book | KU00298794_Review | reviews (1 : 0..*) |
| KU00298794_BorrowRecord | KU00298794_User | references |
| KU00298794_BorrowRecord | KU00298794_Book | references |
| KU00298794_Reservation | KU00298794_User | references |
| KU00298794_Reservation | KU00298794_Book | references |
| KU00298794_BookBuilder | KU00298794_Book | creates |
| KU00298794_LibraryCLI | KU00298794_Library | uses |
| KU00298794_Librarian | KU00298794_Library | manages |
| KU00298794_BorrowingService | KU00298794_NotificationService | uses |
| KU00298794_ReservationService | KU00298794_NotificationService | uses |
| KU00298794_Library | KU00298794_BorrowingService | uses |
| KU00298794_Library | KU00298794_ReservationService | uses |
| KU00298794_Library | KU00298794_ReportService | uses |
| KU00298794_Library | KU00298794_NotificationService | uses |
| KU00298794_Library | KU00298794_CommandInvoker | uses |

### Command Dependencies

| Command Class | Uses |
|---------------|------|
| KU00298794_BorrowCommand | User, Book, BorrowingService |
| KU00298794_ReturnCommand | User, Book, BorrowingService |
| KU00298794_ReserveCommand | User, Book, ReservationService |
| KU00298794_CancelReservationCommand | User, Book, ReservationService |

---

## 📊 UML Arrow Types Reference

| Arrow | Mermaid Syntax | Meaning |
|-------|----------------|---------|
| Inheritance | `<\|--` | extends (child inherits parent) |
| Implementation | `<\|..` | implements (class implements interface) |
| Composition | `*--` | contains (strong ownership) |
| Aggregation | `o--` | has-a (weak ownership) |
| Association | `-->` | uses/references |
| Dependency | `..>` | creates/depends |

---

## ✅ Summary Statistics

| Category | Count |
|----------|-------|
| Total Classes | 38 |
| Abstract Classes | 2 |
| Interfaces | 4 |
| Concrete Classes | 32 |
| Design Patterns | 6 |
| Inheritance Relationships | 6 |
| Implementation Relationships | 12 |
| Aggregation Relationships | 5 |
| Composition Relationships | 3 |
| Association Relationships | 20+ |
