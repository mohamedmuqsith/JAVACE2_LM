Smart Library Management System

Student ID: KU00298794
University: Kingston University
Year: 2025

Overview

The Smart Library Management System is a Java-based console application designed to efficiently manage library operations such as book borrowing, returning, reservations, fine calculation, and user notifications.
The system is built using Object-Oriented Programming principles and demonstrates the practical implementation of six software design patterns.

This project was developed as an academic submission to showcase clean architecture, design pattern usage, and real-world problem solving in software engineering.

Key Features

Book Management

Add, update, search, and remove books

User Management

Supports Student, Faculty, and Guest users

Borrowing & Returning

Automatic due date handling and fine calculation

Reservation System

Queue-based book reservations

Notification System

Email and SMS alerts for reservations and overdue books

Reports

Most borrowed books

Active users

Overdue books

Revenue and fine reports

Command History

Tracks all user actions with undo support

Design Patterns Used

The following six design patterns are fully implemented and demonstrated:

State Pattern

Manages book states such as Available, Borrowed, and Reserved

Strategy Pattern

Different fine calculation strategies:

Student: LKR 50 per day

Faculty: LKR 20 per day

Guest: LKR 100 per day

Builder Pattern

Used to create complex Book objects with optional attributes

Command Pattern

Encapsulates user actions and supports undo functionality

Observer Pattern

Sends Email and SMS notifications for library events

Decorator Pattern

Dynamically adds features like Featured, Recommended, and Special Edition to books

Project Structure
SmartLibrarySystem/
├── src/com/library/
│   ├── KU00298794_Library.java
│   ├── model/           # Core domain models
│   ├── state/           # State Pattern implementation
│   ├── strategy/        # Strategy Pattern implementation
│   ├── builder/         # Builder Pattern implementation
│   ├── command/         # Command Pattern implementation
│   ├── observer/        # Observer Pattern implementation
│   ├── decorator/       # Decorator Pattern implementation
│   ├── service/         # Business logic layer
│   └── ui/              # Command Line Interface
├── bin/                 # Compiled class files
├── class_diagram.puml   # UML Class Diagram
├── DESIGN_PATTERN_JUSTIFICATION.md
└── README.md

How to Compile and Run
Compile the Project
javac -d bin -sourcepath src src/com/library/ui/KU00298794_LibraryCLI.java

Run the Application
java -cp bin com.library.ui.KU00298794_LibraryCLI

Sample Data

When the application starts, the following data is pre-loaded:

Books

Clean Code

The Pragmatic Programmer

Introduction to Algorithms

Users

John Doe – Student

Dr. Jane Smith – Faculty

Bob Wilson – Guest

Notifications are enabled for all users

Main Menu Options

Manage Books

Manage Users

Borrow a Book

Return a Book (with fine calculation)

Reserve a Book

View Reports

Demonstrate Design Patterns

View Command History

Undo Last Action

Exit Application

Design Pattern Demonstration

Option 7 in the main menu allows interactive demonstrations of each design pattern:

Book state transitions (State Pattern)

Fine calculation comparison (Strategy Pattern)

Book creation with optional fields (Builder Pattern)

Command execution and undo (Command Pattern)

Notification alerts (Observer Pattern)

Dynamic book enhancements (Decorator Pattern)

Testing Summary

All system features and design patterns have been tested successfully:

✔ Book state transitions

✔ Fine calculation for all user types

✔ Builder-based book creation

✔ Command execution and undo

✔ Email and SMS notifications

✔ Multiple book decorations

✔ Report generation

✔ Reservation queue handling

Documentation

UML Class Diagram: class_diagram.puml

Design Pattern Justification: DESIGN_PATTERN_JUSTIFICATION.md

System Walkthrough: Included in the project directory

Screenshots: Provided as part of the walkthrough

Requirement Compliance

✔ All classes prefixed with student ID (KU00298794_)
✔ Six design patterns implemented and justified
✔ Strong OOP principles applied
✔ Efficient data structures used (HashMap, ArrayList, Queue)
✔ Command Line Interface implemented
✔ All functional requirements satisfied

Technical Information

Programming Language: Java

Interface: Command Line Interface (CLI)

Data Structures: HashMap, ArrayList, LinkedList

Architecture: Layered architecture (Model, Service, UI)

Design Approach: Package-by-feature

Author

Student ID: KU00298794
University: Kingston University

License

Educational Project – 2025