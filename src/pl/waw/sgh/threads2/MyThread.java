package pl.waw.sgh.threads2;

public class MyThread extends Thread {

    private String name;
    private int iterator;

    private AllThreads allThreads;
    private Thread prevThread;

    public MyThread(String name, AllThreads allThreads) {
        this.name = name;
        this.allThreads = allThreads;
    }

    public MyThread(String name, AllThreads allThreads, Thread prevThread) {
        this.name = name;
        this.allThreads = allThreads;
        this.prevThread = prevThread;
    }

    @Override
    public void run() {
        try {
            // Wait for the previous thread to finish - SEQUENTIAL execution
            //if (prevThread !=null) prevThread.join();
            while (iterator < 10) {
                iterator++;
                System.out.println(name + " it=" + iterator);
                allThreads.increase(name);
                this.sleep(500);
            }
        } catch (InterruptedException ie) {
            System.out.println("Thread " + name + " interrupted");
        }
    }
}
