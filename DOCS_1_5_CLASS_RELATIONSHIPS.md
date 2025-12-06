# 1.5 Description of Class Relationships

| Relationship Type | Class A | Class B | Description & Real-World Reflection |
| :--- | :--- | :--- | :--- |
| **Composition** | `KU00298794_Library` | `KU00298794_Book` | The Library *contains* Books. If the Library is destroyed, the collection of Books ceases to exist in that context. This reflects that books "belong" to the library system. |
| **Composition** | `KU00298794_Library` | `KU00298794_User` | The Library maintains a registry of Users. Users are part of the library's membership database. |
| **Aggregation** | `KU00298794_Book` | `KU00298794_BorrowRecord` | A Book has a history of BorrowRecords. The records exist to track history, but the Book exists independently of any single record. |
| **Inheritance** | `KU00298794_User` | `KU00298794_Student` | A Student *is a* User. It inherits common attributes (name, ID) but specializes behaviors like borrowing limits and fine rates. |
| **Association** | `KU00298794_BorrowCommand`| `KU00298794_BorrowingService` | The Command uses the Service to perform the actual business logic. It invokes methods on the Service. |
| **Composition** (Pattern) | `KU00298794_Book` | `KU00298794_BookState` | The Book delegates its state-dependent behavior (borrow/return availability) to a State object. This implements the **State Pattern**. |
| **Composition** (Pattern) | `KU00298794_User` | `KU00298794_FineStrategy` | The User calculates fines by delegating to a Strategy object. This implements the **Strategy Pattern**. |
| **Aggregation** (Pattern)| `KU00298794_NotificationService`| `KU00298794_Observer`| The Service holds a list of Observers (Email/SMS) to notify. The observers can exist independently (e.g., a User's email address). |
| **Association** | `KU00298794_Book` | `KU00298794_Review` | One-to-Many. A book can have multiple user reviews. |
| **Association** | `KU00298794_User` | `KU00298794_Transaction` | One-to-Many. A user has a history of financial transactions. |
| **Composition** | `KU00298794_ReservationService` | `KU00298794_Reservation` | One-to-Many. The service manages the lifecycle of reservation objects. |
