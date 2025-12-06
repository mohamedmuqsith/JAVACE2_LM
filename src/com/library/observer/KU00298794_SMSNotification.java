package com.library.observer;

/**
 * OBSERVER PATTERN - SMS notification observer
 * Student ID: KU00298794
 */
public class KU00298794_SMSNotification implements KU00298794_Observer {
    private String phoneNumber;
    private String userId;

    public KU00298794_SMSNotification(String userId, String phoneNumber) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String message) {
        sendSMS(message);
    }

    @Override
    public String getObserverId() {
        return "SMS_" + userId;
    }

    private void sendSMS(String message) {
        System.out.println("───────────────────────────────────────");
        System.out.println("SMS NOTIFICATION");
        System.out.println("To: " + phoneNumber);
        System.out.println("Message: " + message);
        System.out.println("───────────────────────────────────────");
    }
}
