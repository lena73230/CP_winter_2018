package pl.waw.sgh.threads2;

public class MyThread extends Thread {

    private String name;
    private int iterator;

    private AllThreads allThreads;

    public MyThread(String name, AllThreads allThreads) {
        this.name = name;
        this.allThreads = allThreads;
    }

    @Override
    public void run() {
        try {
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
