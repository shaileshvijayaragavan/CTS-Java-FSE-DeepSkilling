public class SingletonDemo {

    public static void main(String[] args) throws InterruptedException {
        Singleton first = Singleton.getInstance();
        Singleton second = Singleton.getInstance();

        first.connect();
        second.connect();

        System.out.println("first == second? " + (first == second));
        System.out.println("Total connections recorded: " + first.getConnectionCount());

        Runnable task = () -> {
            Singleton s = Singleton.getInstance();
            s.connect();
        };

        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");
        Thread t3 = new Thread(task, "Thread-C");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final connection count: " + Singleton.getInstance().getConnectionCount());
    }
}
