package com.library.observer;

/**
 * OBSERVER PATTERN - Email notification observer
 * Student ID: KU00298794
 */
public class KU00298794_EmailNotification implements KU00298794_Observer {
    private String email;
    private String userId;

    public KU00298794_EmailNotification(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    @Override
    public void update(String message) {
        sendEmail(message);
    }

    @Override
    public String getObserverId() {
        return "EMAIL_" + userId;
    }

    private void sendEmail(String message) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("EMAIL NOTIFICATION");
        System.out.println("To: " + email);
        System.out.println("Message: " + message);
        System.out.println("═══════════════════════════════════════");
    }
}
