interface Notification {
    void notifyUser(String message);
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("[Email] Sending message: \"" + message + "\"");
    }
}

class SmsNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("[SMS] Sending message: \"" + message + "\"");
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("[Push] Sending message: \"" + message + "\"");
    }
}

abstract class NotificationFactory {

    public abstract Notification createNotification();

    public void send(String message) {
        Notification notification = createNotification();
        notification.notifyUser(message);
    }
}

class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SmsNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}

class PushNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

class NotificationFactoryProvider {
    public static NotificationFactory getFactory(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotificationFactory();
            case "sms":
                return new SmsNotificationFactory();
            case "push":
                return new PushNotificationFactory();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}
