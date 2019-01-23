package pl.waw.sgh.threads;

public class Notifier implements Runnable {

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
        try {
            // ms to wait
            Thread.sleep(5000);
            synchronized (msg) {
                msg.setMsg("Notifier done");
                // Notify all threads that wait
                msg.notifyAll();
                // Notify only 1 thread
                //msg.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
