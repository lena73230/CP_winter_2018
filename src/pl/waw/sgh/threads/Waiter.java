package pl.waw.sgh.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Waiter implements Runnable {

    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String getCurTime() {
        //System.currentTimeMillis();
        return sdf.format(new Date());
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " is executing at:" + getCurTime());
        synchronized (msg) {
            try {
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + "got notified at: " + getCurTime());
        System.out.println(threadName + "get msg: " + msg.getMsg());
        for (int i = 0; i < 10; i++) {
            System.out.println(threadName + " i=" + i);
        }

    }
}
