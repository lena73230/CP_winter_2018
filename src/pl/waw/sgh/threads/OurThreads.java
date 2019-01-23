package pl.waw.sgh.threads;

public class OurThreads {

    public static void main(String[] args) {
        Waiter w1 = new Waiter();
        Waiter w2 = new Waiter();

        Thread t1 = new Thread(w1, "waiter1");
        Thread t2 = new Thread(w2, "waiter2");
        t1.start();
        t2.start();
    }
}
