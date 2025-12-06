# 3. Test Cases

## 3.1 Test Case Table

| Test Case ID | Function Tested | Input | Expected Output | Actual Output | Result |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **TC001** | **Add Book** | ID: `B001`, Title: `Java 101`, Author: `Doe` | "Book added: Java 101" | "✓ Book added: Java 101" | **Pass** |
| **TC002** | **Borrow Book** | User: `U001`, Book: `B001` | "Book borrowed successfully" | "✓ Book borrowed successfully" | **Pass** |
| **TC003** | **Borrow (Over Limit)** | User: `Student` (Limit 3), Borrow 4th book | "Borrowing limit reached" | "❌ Borrowing limit reached" | **Pass** |
| **TC004** | **Return Book** | User: `U001`, Book: `B001` | "Book returned successfully" | "✓ Book returned successfully" | **Pass** |
| **TC005** | **Reserve Book** | User: `U002`, Book: `B001` (Currently Borrowed) | "Book reserved. Position: 1" | "✓ Book reserved. Position: 1" | **Pass** |
| **TC006** | **Calculate Fine** | User: `Student`, Overdue: 5 days | "Fine: LKR 250.00" | "Fine: LKR 250.00" | **Pass** |
| **TC007** | **Search Book** | Query: "Java" | Returns `B001` | Returns list containing `B001` | **Pass** |
| **TC008** | **Notification** | Return book `B001` (Reserved by `U002`) | "Notification sent to U002" | "✓ Notification sent to U002" | **Pass** |

## 3.2 Discussion of Testing Results
All test cases passed successfully. The system correctly handles state transitions (Available -> Borrowed -> Reserved). Boundary conditions, such as borrowing limits and invalid IDs, are handled gracefully with appropriate error messages.
**Limitation**: The current CLI implementation stores data in memory. Restarting the application resets the data. A future improvement would be to add file-based or database persistence.
