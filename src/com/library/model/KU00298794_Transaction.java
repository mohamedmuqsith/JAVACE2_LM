package com.library.model;

import java.util.Date;

/**
 * Represents a financial transaction (e.g., fine payment).
 * Student ID: KU00298794
 */
public class KU00298794_Transaction {
    private String transactionId;
    private KU00298794_User user;
    private double amount;
    private Date date;
    private String type; // "FINE_PAYMENT", "REFUND"

    public KU00298794_Transaction(String transactionId, KU00298794_User user, double amount, String type) {
        this.transactionId = transactionId;
        this.user = user;
        this.amount = amount;
        this.date = new Date();
        this.type = type;
    }

    public void process() {
        System.out.println("Processing transaction " + transactionId + " for LKR " + amount);
    }

    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public Date getDate() { return date; }
}
