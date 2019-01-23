package pl.waw.sgh.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Waiter implements Runnable {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String getCurTime() {
        //System.currentTimeMillis();
        return sdf.format(new Date());
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " is executing at:" + getCurTime());

        for (int i = 0; i < 10; i++) {
            System.out.println(threadName + " i=" + i);
        }
    }
}
