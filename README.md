# Smart Library Management System - README

## Student ID: KU00298794

## Overview
A comprehensive Java-based Smart Library Management System implementing six design patterns for managing book borrowing, returns, reservations, fines, and notifications.

## Features
- **Book Management**: Add, update, search, and remove books
- **User Management**: Support for Student, Faculty, and Guest memberships
- **Borrowing & Returning**: Automated due date calculation and fine processing
- **Reservations**: Queue-based reservation system with notifications
- **Notifications**: Real-time Email and SMS notifications for overdue books and reservations
- **Reports**: Most borrowed books, active borrowers, overdue books, revenue reports
- **Command History**: Full audit trail with undo functionality

## Design Patterns Implemented

1. **State Pattern**: Book availability states (Available, Borrowed, Reserved)
2. **Strategy Pattern**: Fine calculation strategies (Student: LKR 50/day, Faculty: LKR 20/day, Guest: LKR 100/day)
3. **Builder Pattern**: Complex book object creation with optional metadata
4. **Command Pattern**: User actions as reversible commands with logging
5. **Observer Pattern**: Notification system for library events
6. **Decorator Pattern**: Dynamic book features (Featured, Recommended, Special Edition)

## Project Structure
```
SmartLibrarySystem/
├── src/com/library/
│   ├── KU00298794_Library.java
│   ├── model/           # Domain entities
│   ├── state/           # State Pattern
│   ├── strategy/        # Strategy Pattern
│   ├── builder/         # Builder Pattern
│   ├── command/         # Command Pattern
│   ├── observer/        # Observer Pattern
│   ├── decorator/       # Decorator Pattern
│   ├── service/         # Business logic
│   └── ui/              # CLI interface
├── bin/                 # Compiled classes
├── class_diagram.puml   # UML class diagram
├── DESIGN_PATTERN_JUSTIFICATION.md
└── README.md
```

## Compilation & Execution

### Compile
```powershell
javac -d bin -sourcepath src src/com/library/ui/KU00298794_LibraryCLI.java
```

### Run
```powershell
java -cp bin com.library.ui.KU00298794_LibraryCLI
```

## Sample Data
The system initializes with:
- 3 Books: Clean Code, The Pragmatic Programmer, Introduction to Algorithms
- 3 Users: John Doe (Student), Dr. Jane Smith (Faculty), Bob Wilson (Guest)
- Notifications enabled for all users

## Main Menu Options
1. **Manage Books** - Add, view, search, remove books
2. **Manage Users** - Register, view, remove users
3. **Borrow Book** - Execute borrow command
4. **Return Book** - Execute return command (with fine calculation)
5. **Reserve Book** - Execute reserve command
6. **View Reports** - Generate various library reports
7. **Demonstrate Design Patterns** - Interactive pattern demonstrations
8. **View Command History** - See all executed commands
9. **Undo Last Action** - Reverse the last command
0. **Exit** - Close the application

## Design Pattern Demonstrations
From the main menu, select option 7 to interactively demonstrate each design pattern:
- State Pattern: See book state transitions
- Strategy Pattern: Compare fine calculations for different user types
- Builder Pattern: Create books with optional metadata
- Command Pattern: View command history and undo functionality
- Observer Pattern: See notification system in action
- Decorator Pattern: Apply dynamic features to books

## Testing
All design patterns have been tested and verified:
- ✅ State transitions (Available → Borrowed → Reserved → Available)
- ✅ Fine calculation for all three user types
- ✅ Complex book creation with Builder
- ✅ Command execution and undo
- ✅ Observer notifications (Email/SMS)
- ✅ Book decoration with multiple features
- ✅ Reports generation
- ✅ Reservation queue management

## Documentation
- **Class Diagram**: `class_diagram.puml` (PlantUML format)
- **Pattern Justification**: `DESIGN_PATTERN_JUSTIFICATION.md`
- **Walkthrough**: Available in brain directory
- **Screenshots**: Included in walkthrough

## Requirements Compliance
✅ All classes prefixed with Kingston University student ID (KU00298794_)  
✅ Six design patterns fully implemented and justified  
✅ Object-oriented programming best practices  
✅ Efficient data structures (HashMap, ArrayList, Queue)  
✅ CLI user interface  
✅ Complete functional requirements  

## Technical Details
- **Language**: Java
- **Interface**: Command Line Interface (CLI)
- **Data Structures**: HashMap (O(1) lookup), ArrayList, LinkedList (Queue)
- **Architecture**: Layered (Model, Service, UI)
- **Design**: Package-by-feature organization

## Author
Student ID: KU00298794  
Kingston University

## License
Educational Project - 2025
