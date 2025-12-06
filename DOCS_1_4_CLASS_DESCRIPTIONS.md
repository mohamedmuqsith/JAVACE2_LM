# 1.4 Detailed Class Descriptions

| Class Name | Responsibility | Attributes (Type & Explanation) | Methods (Parameters & Purpose) | Access Modifiers |
| :--- | :--- | :--- | :--- | :--- |
| **KU00298794_Library** | Central management system, Facade for services | `books` (Map): Stores book objects<br>`users` (Map): Stores user objects<br>`librarians` (Map): Stores librarian objects<br>`borrowingService` (Service): Handles borrowing<br>`reservationService` (Service): Handles reservations | `addBook(Book)`: Adds book to system<br>`addUser(User)`: Registers user<br>`getBorrowingService()`: Access service<br>`searchBooks(String)`: Finds books | `public` |
| **KU00298794_Book** | Represents a library book | `bookId` (String): Unique ID<br>`title` (String): Book title<br>`currentState` (BookState): Current availability<br>`borrowedHistory` (List): History of loans | `borrow(User)`: Attempts to borrow<br>`returnBook()`: Returns book<br>`setState(BookState)`: Changes state<br>`getDescription()`: Returns details | `public` |
| **KU00298794_User** | Abstract base class for library users | `userId` (String): Unique ID<br>`name` (String): User's name<br>`fineStrategy` (Strategy): Fine calculation logic | `calculateFine(days)`: Calculates fine<br>`getBorrowingLimit()`: Abstract method | `public abstract` |
| **KU00298794_Student** | Represents a student user | `borrowingLimit` (int): 3 books<br>`fineRate` (double): LKR 50/day | `getBorrowingLimit()`: Returns 3<br>`getDueDays()`: Returns 14 | `public` |
| **KU00298794_Faculty** | Represents a faculty user | `borrowingLimit` (int): 5 books<br>`fineRate` (double): LKR 20/day | `getBorrowingLimit()`: Returns 5<br>`getDueDays()`: Returns 30 | `public` |
| **KU00298794_BorrowRecord** | Tracks a single borrowing instance | `user` (User): Who borrowed<br>`book` (Book): What was borrowed<br>`borrowDate` (Date): When borrowed<br>`dueDate` (Date): When due | `isOverdue()`: Checks if late<br>`getFineAmount()`: Calculates fine | `public` |
| **KU00298794_BookBuilder** | Builder for creating Book objects | `bookId` (String): ID to set<br>`title` (String): Title to set<br>`reviews` (List): Optional reviews | `setTitle(String)`: Chainable setter<br>`addReview(String)`: Adds review<br>`build()`: Returns new Book | `public` |
| **KU00298794_BorrowCommand** | Command to borrow a book | `user` (User): Target user<br>`book` (Book): Target book | `execute()`: Performs borrow<br>`undo()`: Reverses borrow (returns) | `public` |
| **KU00298794_NotificationService**| Subject in Observer pattern | `observers` (List): List of listeners | `attach(Observer)`: Add listener<br>`notifyObservers(msg)`: Send alert | `public` |
| **KU00298794_Reservation** | Represents a book reservation | `user`: Reserver<br>`book`: Reserved book<br>`status`: Active/Fulfilled | `cancel()`: Cancel<br>`fulfill()`: Mark complete | `public` |
| **KU00298794_Transaction** | Financial record | `amount`: Value<br>`type`: Payment/Refund | `process()`: Execute payment logic | `public` |
| **KU00298794_Review** | Book rating and comment | `rating`: 1-5 stars<br>`comment`: Text | `toString()`: Display format | `public` |
| **KU00298794_LibraryCLI** | Command Line Interface | `library` (Library): System instance<br>`scanner` (Scanner): Input reader | `start()`: Main loop<br>`manageBooks()`: Book menu<br>`demonstratePatterns()`: Demo menu | `public` |
