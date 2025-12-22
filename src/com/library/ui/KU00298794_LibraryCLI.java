package com.library.ui;

import com.library.KU00298794_Library;
import com.library.builder.KU00298794_BookBuilder;
import com.library.command.*;
import com.library.decorator.*;
import com.library.model.*;
import com.library.observer.*;
import java.util.*;

/**
 * Command Line Interface for the Smart Library Management System
 * Student ID: KU00298794
 */
public class KU00298794_LibraryCLI {
    private KU00298794_Library library;
    private Scanner scanner;
    private boolean running;

    public KU00298794_LibraryCLI() {
        this.library = new KU00298794_Library();
        this.scanner = new Scanner(System.in);
        this.running = true;
        initializeSampleData();
    }

    public void start() {
        displayWelcomeBanner();

        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter choice", 0, 10);

            switch (choice) {
                case 1:
                    manageBooks();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    reserveBook();
                    break;
                case 6:
                    viewReports();
                    break;
                case 7:
                    demonstrateDesignPatterns();
                    break;
                case 8:
                    library.getCommandInvoker().printHistory();
                    break;
                case 9:
                    undoLastAction();
                    break;
                case 0:
                    running = false;
                    System.out.println("\n👋 Thank you for using Smart Library Management System!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void displayWelcomeBanner() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                  ║");
        System.out.println("║        SMART LIBRARY MANAGEMENT SYSTEM (SLMS)                    ║");
        System.out.println("║                                                                  ║");
        System.out.println("║        Student ID: KU00298794                                    ║");
        System.out.println("║                                                                  ║");
        System.out.println("║        Design Patterns Implemented:                              ║");
        System.out.println("║        • State Pattern (Book Availability)                       ║");
        System.out.println("║        • Strategy Pattern (Fine Calculation)                     ║");
        System.out.println("║        • Builder Pattern (Book Creation)                         ║");
        System.out.println("║        • Command Pattern (User Actions)                          ║");
        System.out.println("║        • Observer Pattern (Notifications)                        ║");
        System.out.println("║        • Decorator Pattern (Book Features)                       ║");
        System.out.println("║                                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");
    }

    private void displayMainMenu() {
        System.out.println("\n╔════════════════════════ MAIN MENU ═══════════════════════════════╗");
        System.out.println("║  1. Manage Books                                                 ║");
        System.out.println("║  2. Manage Users                                                 ║");
        System.out.println("║  3. Borrow Book                                                  ║");
        System.out.println("║  4. Return Book                                                  ║");
        System.out.println("║  5. Reserve Book                                                 ║");
        System.out.println("║  6. View Reports                                                 ║");
        System.out.println("║  7. Demonstrate Design Patterns                                  ║");
        System.out.println("║  8. View Command History                                         ║");
        System.out.println("║  9. Undo Last Action                                             ║");
        System.out.println("║  0. Exit                                                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    private void manageBooks() {
        System.out.println("\n═══ BOOK MANAGEMENT ═══");
        System.out.println("1. Add Book (using Builder Pattern)");
        System.out.println("2. View All Books");
        System.out.println("3. Search Books");
        System.out.println("4. Remove Book");
        System.out.println("0. Back");

        int choice = getIntInput("Enter choice", 0, 4);

        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                viewAllBooks();
                break;
            case 3:
                searchBooks();
                break;
            case 4:
                removeBook();
                break;
        }
    }

    private void addBook() {
        System.out.println("\n─── Add New Book (Builder Pattern) ───");

        String bookId = getStringInput("Book ID");
        String title = getStringInput("Title");
        String author = getStringInput("Author");
        String category = getStringInput("Category");
        String isbn = getStringInput("ISBN");

        // Using Builder Pattern
        KU00298794_BookBuilder builder = new KU00298794_BookBuilder();
        builder.setBookId(bookId)
                .setTitle(title)
                .setAuthor(author)
                .setCategory(category)
                .setIsbn(isbn);

        // Optional metadata
        System.out.print("Add review? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            String reviewer = getStringInput("Reviewer Name");
            double rating = (double) getIntInput("Rating (1-5)", 1, 5);
            String comment = getStringInput("Comment");
            builder.addReview(reviewer, rating, comment);
        }

        System.out.print("Add tag? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            String tag = getStringInput("Tag");
            builder.addTag(tag);
        }

        System.out.print("Set edition? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            String edition = getStringInput("Edition");
            builder.setEdition(edition);
        }

        KU00298794_Book book = builder.build();
        library.addBook(book);
    }

    private void viewAllBooks() {
        System.out.println("\n═══ ALL BOOKS ═══");
        List<KU00298794_Book> books = library.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            for (KU00298794_Book book : books) {
                System.out.println("\n- " + book);
                System.out.println("  Category: " + book.getCategory());
                System.out.println("  State: " + book.getState().getStateName());
            }
        }
    }

    private void searchBooks() {
        String query = getStringInput("Search query");
        List<KU00298794_Book> results = library.searchBooks(query);

        System.out.println("\n═══ SEARCH RESULTS ═══");
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (KU00298794_Book book : results) {
                System.out.println("- " + book);
            }
        }
    }

    private void removeBook() {
        String bookId = getStringInput("Book ID to remove");
        library.removeBook(bookId);
    }

    private void manageUsers() {
        System.out.println("\n═══ USER MANAGEMENT ═══");
        System.out.println("1. Register User");
        System.out.println("2. View All Users");
        System.out.println("3. Remove User");
        System.out.println("0. Back");

        int choice = getIntInput("Enter choice", 0, 3);

        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                viewAllUsers();
                break;
            case 3:
                removeUser();
                break;
        }
    }

    private void registerUser() {
        System.out.println("\n─── Register New User ───");

        String userId = getStringInput("User ID");
        String name = getStringInput("Name");
        String email = getStringInput("Email");
        String contact = getStringInput("Contact Number");

        System.out.println("Select Membership Type:");
        System.out.println("1. Student (Strategy Pattern: LKR 50/day fine)");
        System.out.println("2. Faculty (Strategy Pattern: LKR 20/day fine)");
        System.out.println("3. Guest (Strategy Pattern: LKR 100/day fine)");

        int type = getIntInput("Choice", 1, 3);

        KU00298794_User user;
        switch (type) {
            case 1:
                user = new KU00298794_Student(userId, name, email, contact);
                break;
            case 2:
                user = new KU00298794_Faculty(userId, name, email, contact);
                break;
            case 3:
                user = new KU00298794_Guest(userId, name, email, contact);
                break;
            default:
                user = new KU00298794_Student(userId, name, email, contact);
        }

        library.addUser(user);

        // Attach observers for notifications
        library.getNotificationService().attach(new KU00298794_EmailNotification(userId, email));
        library.getNotificationService().attach(new KU00298794_SMSNotification(userId, contact));

        System.out.println("Notifications enabled: Email and SMS");
    }

    private void viewAllUsers() {
        System.out.println("\n═══ ALL USERS ═══");
        List<KU00298794_User> users = library.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            for (KU00298794_User user : users) {
                System.out.println("\n- " + user);
                System.out.println("  Borrowing Limit: " + user.getBorrowingLimit());
                System.out.println("  Due Days: " + user.getDueDays());
                System.out.println("  Fine Rate: LKR " + user.getFineStrategy().getFineRate() + "/day");
                System.out.println("  Currently Borrowed: " + user.getBorrowedBooks().size());
            }
        }
    }

    private void removeUser() {
        String userId = getStringInput("User ID to remove");
        library.removeUser(userId);
    }

    private void borrowBook() {
        String userId = getStringInput("User ID");
        String bookId = getStringInput("Book ID");

        KU00298794_User user = library.getUser(userId);
        KU00298794_Book book = library.getBook(bookId);

        if (user == null || book == null) {
            System.out.println("Invalid user or book ID.");
            return;
        }

        // Using Command Pattern
        KU00298794_Command borrowCmd = new KU00298794_BorrowCommand(
                user, book, library.getBorrowingService());

        library.getCommandInvoker().executeCommand(borrowCmd);
    }

    private void returnBook() {
        String userId = getStringInput("User ID");
        String bookId = getStringInput("Book ID");

        KU00298794_User user = library.getUser(userId);
        KU00298794_Book book = library.getBook(bookId);

        if (user == null || book == null) {
            System.out.println("Invalid user or book ID.");
            return;
        }

        // Using Command Pattern
        KU00298794_Command returnCmd = new KU00298794_ReturnCommand(
                user, book, library.getBorrowingService());

        library.getCommandInvoker().executeCommand(returnCmd);
    }

    private void reserveBook() {
        String userId = getStringInput("User ID");
        String bookId = getStringInput("Book ID");

        KU00298794_User user = library.getUser(userId);
        KU00298794_Book book = library.getBook(bookId);

        if (user == null || book == null) {
            System.out.println("Invalid user or book ID.");
            return;
        }

        // Using Command Pattern
        KU00298794_Command reserveCmd = new KU00298794_ReserveCommand(
                user, book, library.getReservationService());

        library.getCommandInvoker().executeCommand(reserveCmd);
    }

    private void viewReports() {
        System.out.println("\n═══ REPORTS ═══");
        System.out.println("1. Most Borrowed Books");
        System.out.println("2. Active Borrowers");
        System.out.println("3. Overdue Books");
        System.out.println("4. Revenue Report");
        System.out.println("0. Back");

        int choice = getIntInput("Enter choice", 0, 4);

        switch (choice) {
            case 1:
                library.getReportService().printMostBorrowedBooksReport(5);
                break;
            case 2:
                library.getReportService().printActiveBorrowersReport(5);
                break;
            case 3:
                library.getReportService().printOverdueBooksReport();
                break;
            case 4:
                double revenue = library.getReportService().generateRevenueReport();
                System.out.println("\n═══ REVENUE REPORT ═══");
                System.out.println("Total Fine Revenue: LKR " + String.format("%.2f", revenue));
                break;
        }
    }

    private void demonstrateDesignPatterns() {
        System.out.println("\n╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║              DESIGN PATTERNS DEMONSTRATION                      ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println("\n1. State Pattern (Book States)");
        System.out.println("2. Strategy Pattern (Fine Calculation)");
        System.out.println("3. Builder Pattern (Book Creation)");
        System.out.println("4. Command Pattern (Undo/Redo)");
        System.out.println("5. Observer Pattern (Notifications)");
        System.out.println("6. Decorator Pattern (Book Features)");
        System.out.println("0. Back");

        int choice = getIntInput("Enter choice", 0, 6);

        switch (choice) {
            case 1:
                demonstrateStatePattern();
                break;
            case 2:
                demonstrateStrategyPattern();
                break;
            case 3:
                demonstrateBuilderPattern();
                break;
            case 4:
                demonstrateCommandPattern();
                break;
            case 5:
                demonstrateObserverPattern();
                break;
            case 6:
                demonstrateDecoratorPattern();
                break;
        }
    }

    private void demonstrateStatePattern() {
        System.out.println("\n╔══════════ STATE PATTERN DEMONSTRATION ══════════════╗");
        System.out.println("Books transition between Available → Borrowed → Reserved → Available");

        KU00298794_Book demoBook = library.getBook("B001");
        if (demoBook != null) {
            System.out.println("\nInitial State: " + demoBook.getState().getStateName());
            System.out.println("Attempting to borrow...");
            demoBook.borrow(library.getAllUsers().get(0));
            System.out.println("New State: " + demoBook.getState().getStateName());
        }
    }

    private void demonstrateStrategyPattern() {
        System.out.println("\n╔══════════ STRATEGY PATTERN DEMONSTRATION ══════════════╗");
        System.out.println("Different fine calculation strategies for each user type:\n");

        int overdueDays = 5;
        System.out.println("For " + overdueDays + " overdue days:");

        KU00298794_Student student = new KU00298794_Student("DEMO", "Demo Student", "demo@uni.edu", "123");
        KU00298794_Faculty faculty = new KU00298794_Faculty("DEMO", "Demo Faculty", "demo@uni.edu", "123");
        KU00298794_Guest guest = new KU00298794_Guest("DEMO", "Demo Guest", "demo@uni.edu", "123");

        System.out.println("- Student (LKR 50/day):  LKR " + student.calculateFine(overdueDays));
        System.out.println("- Faculty (LKR 20/day):  LKR " + faculty.calculateFine(overdueDays));
        System.out.println("- Guest (LKR 100/day):   LKR " + guest.calculateFine(overdueDays));
    }

    private void demonstrateBuilderPattern() {
        System.out.println("\n╔══════════ BUILDER PATTERN DEMONSTRATION ══════════════╗");
        System.out.println("Creating a complex book with optional metadata:\n");

        KU00298794_Book book = new KU00298794_BookBuilder()
                .setBookId("DEMO")
                .setTitle("Design Patterns: Elements of Reusable OO Software")
                .setAuthor("Gang of Four")
                .setCategory("Computer Science")
                .setIsbn("978-0201633610")
                .addReview("John Doe", 5.0, "Excellent book on design patterns!")
                .addReview("Jane Smith", 4.5, "A must-read for software engineers.")
                .addTag("design-patterns")
                .addTag("software-engineering")
                .setEdition("Anniversary Edition")
                .build();

        System.out.println("Book Created: " + book.getTitle());
        System.out.println("Edition: " + book.getEdition());
        System.out.println("Reviews: " + book.getReviews().size());
        System.out.println("Tags: " + book.getTags());
    }

    private void demonstrateCommandPattern() {
        System.out.println("\n╔══════════ COMMAND PATTERN DEMONSTRATION ══════════════╗");
        System.out.println("Commands can be executed and undone:\n");
        library.getCommandInvoker().printHistory();
        System.out.println("Try borrowing/returning books and use 'Undo Last Action' to see undo functionality!");
    }

    private void demonstrateObserverPattern() {
        System.out.println("\n╔══════════ OBSERVER PATTERN DEMONSTRATION ══════════════╗");
        System.out.println("Users are automatically notified via Email and SMS:");
        System.out.println("- When books are overdue");
        System.out.println("- When reserved books become available");
        System.out.println("- Due date reminders\n");
        System.out.println("Try returning a book to see notifications in action!");
    }

    private void demonstrateDecoratorPattern() {
        System.out.println("\n╔══════════ DECORATOR PATTERN DEMONSTRATION ══════════════╗");
        System.out.println("Books can be decorated with additional features:\n");

        KU00298794_Book book = library.getBook("B001");
        if (book != null) {
            System.out.println("Original: " + book.getDescription());

            KU00298794_FeaturedBookDecorator featured = new KU00298794_FeaturedBookDecorator(book,
                    "Bestseller of the month!");
            System.out.println("\n" + featured.getDescription());
            System.out.println("   " + featured.getAdditionalInfo());

            KU00298794_RecommendedBookDecorator recommended = new KU00298794_RecommendedBookDecorator(book, "Librarian",
                    4.8);
            System.out.println("\n" + recommended.getDescription());
            System.out.println("   " + recommended.getAdditionalInfo());

            KU00298794_SpecialEditionDecorator special = new KU00298794_SpecialEditionDecorator(book, "Collector's",
                    "Signed by author");
            System.out.println("\n" + special.getDescription());
            System.out.println("   " + special.getAdditionalInfo());
        }
    }

    private void undoLastAction() {
        library.getCommandInvoker().undoLastCommand();
    }

    private void initializeSampleData() {
        System.out.println("Loading sample data...\n");

        // Add sample books
        library.addBook(new KU00298794_BookBuilder()
                .setBookId("B001")
                .setTitle("Clean Code")
                .setAuthor("Robert C. Martin")
                .setCategory("Programming")
                .setIsbn("978-0132350884")
                .addTag("best-practices")
                .build());

        library.addBook(new KU00298794_BookBuilder()
                .setBookId("B002")
                .setTitle("The Pragmatic Programmer")
                .setAuthor("Andrew Hunt")
                .setCategory("Programming")
                .setIsbn("978-0135957059")
                .build());

        library.addBook(new KU00298794_BookBuilder()
                .setBookId("B003")
                .setTitle("Introduction to Algorithms")
                .setAuthor("Thomas H. Cormen")
                .setCategory("Computer Science")
                .setIsbn("978-0262033848")
                .build());

        // Add sample users
        KU00298794_Student student = new KU00298794_Student("U001", "John Doe", "john@uni.edu", "+94771234567");
        library.addUser(student);
        library.getNotificationService().attach(new KU00298794_EmailNotification("U001", "john@uni.edu"));
        library.getNotificationService().attach(new KU00298794_SMSNotification("U001", "+94771234567"));

        KU00298794_Faculty faculty = new KU00298794_Faculty("U002", "Dr. Jane Smith", "jane@uni.edu", "+94777654321");
        library.addUser(faculty);
        library.getNotificationService().attach(new KU00298794_EmailNotification("U002", "jane@uni.edu"));

        KU00298794_Guest guest = new KU00298794_Guest("U003", "Bob Wilson", "bob@email.com", "+94778888888");
        library.addUser(guest);

        System.out.println("Sample data loaded successfully!\n");
    }

    // Helper methods
    private String getStringInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }

    private int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt + " (" + min + "-" + max + "): ");
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        KU00298794_LibraryCLI cli = new KU00298794_LibraryCLI();
        cli.start();
    }
}
