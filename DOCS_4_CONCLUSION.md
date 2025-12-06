# 4. Conclusion

The Smart Library Management System (SLMS) successfully meets all the requirements specified in the coursework assignment. It provides a comprehensive command-line interface for Borrowing, Returning, and Reserving books, while correctly distinguishing between Student, Faculty, and Guest user roles with distinct fine strategies.

## Meeting the Requirements
- **Functional Completeness**: All core modules—Add/Remove Books, User Management, Borrowing Cycle, and Reporting—are fully functional.
- **Design Patterns**: The implementation successfully integrates six design patterns (State, Strategy, Builder, Command, Observer, Decorator) to solve specific problems rather than just for demonstration. For instance, the State pattern cleanly handles the complex availability logic of books.
- **Robustness**: The system handles edge cases like borrowing limits and overlapping reservations gracefully.

## Challenges Faced
One of the main challenges was ensuring the **Observer Pattern** and **State Pattern** worked correctly in tandem. For example, ensuring that a book returning to the "Available" state automatically triggered the "Reservation Available" notification required careful coordination between the `ReservationService` and the `Book` state transitions. This was solved by having the `ReturnCommand` orchestrate the flow.

## Future Improvements
- **Persistence**: Currently, the system uses in-memory `HashMap` storage. Adding a database (SQL/NoSQL) or file-based persistence would allow data to survive application restarts.
- **GUI**: While the CLI is functional, a JavaFX or Swing GUI would improve the user experience for non-technical librarians.
