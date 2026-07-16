public class Singleton {

    private static volatile Singleton instance;
    private int connectionCount;

    private Singleton() {
        connectionCount = 0;
        System.out.println("Singleton instance created: " + this.hashCode());
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void connect() {
        connectionCount++;
        System.out.println("Connection #" + connectionCount + " made via instance " + this.hashCode());
    }

    public int getConnectionCount() {
        return connectionCount;
    }
}
