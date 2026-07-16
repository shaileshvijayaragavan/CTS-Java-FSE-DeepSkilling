public class FactoryMethodDemo {

    public static void main(String[] args) {
        NotificationFactory emailFactory = new EmailNotificationFactory();
        emailFactory.send("Your order has shipped!");

        NotificationFactory smsFactory = new SmsNotificationFactory();
        smsFactory.send("Your OTP is 482913.");

        NotificationFactory pushFactory = new PushNotificationFactory();
        pushFactory.send("You have a new follower.");

        String[] types = {"email", "sms", "push"};
        for (String type : types) {
            NotificationFactory factory = NotificationFactoryProvider.getFactory(type);
            factory.send("Reminder: your appointment is tomorrow.");
        }
    }
}
