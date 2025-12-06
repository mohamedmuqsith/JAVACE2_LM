package com.library.model;

/**
 * Librarian who manages books and users
 * Student ID: KU00298794
 */
public class KU00298794_Librarian {
    private String librarianId;
    private String name;
    private String email;

    public KU00298794_Librarian(String librarianId, String name, String email) {
        this.librarianId = librarianId;
        this.name = name;
        this.email = email;
    }

    public String getLibrarianId() {
        return librarianId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean verifyMember(String userId) {
        // Logic to verify member exists (in real app would check DB)
        return userId != null && !userId.isEmpty();
    }

    public void collectFine(KU00298794_User user, double amount) {
        user.payFine(amount);
        System.out.println("Payment of LKR " + amount + " collected from " + user.getName());
    }

    @Override
    public String toString() {
        return String.format("Librarian[ID=%s, Name=%s, Email=%s]",
                librarianId, name, email);
    }
}
