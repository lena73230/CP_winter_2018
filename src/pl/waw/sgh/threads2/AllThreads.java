package pl.waw.sgh.threads2;

public class AllThreads {

    static final int NUM_THREADS = 5;

    private int allIterator = 0;

    // Try also without synchronized - race condition
    public synchronized void increase(String threadName) {
        allIterator++;
        System.out.println("Thread " + threadName + " all iter: " + allIterator);
    }

    public static void main(String[] args) {
        AllThreads allThreads = new AllThreads();
        MyThread[] myThreads = new MyThread[NUM_THREADS];
        Thread prevThread = null;
        for (int i = 0; i < NUM_THREADS; i++) {
            myThreads[i] = new MyThread("T_" + i, allThreads, prevThread);
            prevThread = myThreads[i];
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            myThreads[i].start();
        }

    }
}
