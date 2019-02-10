package pl.waw.sgh.threads;

public class OurThreads {

    public static void main(String[] args) {
        Message msg = new Message("Process");
        Waiter w1 = new Waiter(msg);
        Waiter w2 = new Waiter(msg);

        Thread t1 = new Thread(w1, "waiter1");
        Thread t2 = new Thread(w2, "waiter2");
        t1.start();
        t2.start();

        Notifier notifier = new Notifier(msg);
        Thread t3 = new Thread(notifier, "notifier");
        t3.start();
    }
}
