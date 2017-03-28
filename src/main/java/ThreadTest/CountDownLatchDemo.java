package ThreadTest;

import java.util.concurrent.CountDownLatch;

/**
 * Created by chengangw on 27/3/17.
 */
public class CountDownLatchDemo {
    private static class WorkThread extends Thread {
        private CountDownLatch countDownLatch;
        private int sleepSec;

        public WorkThread(String name, CountDownLatch cdl, int sleepSec) {
            super(name);
            this.countDownLatch = cdl;
            this.sleepSec = sleepSec;
        }

        public void run() {
            try {
                System.out.println(this.getName() + "启动了，时间为" + System.currentTimeMillis());
                Thread.sleep(sleepSec * 1000);
                countDownLatch.countDown();
                System.out.println(this.getName() + "执行结束了，时间为" + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class DoneThread extends Thread {
        private CountDownLatch cdl;

        public DoneThread(String name, CountDownLatch cdl) {
            super(name);
            this.cdl = cdl;
        }

        public void run() {
            try {
                System.out.println(this.getName() + "要等待了，时间为" + System.currentTimeMillis());
                cdl.await();
                System.out.println(this.getName() + "等待结束了，时间为" + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            CountDownLatch cdl = new CountDownLatch(3);
            DoneThread d1 = new DoneThread("Ds1", cdl);
            DoneThread d2 = new DoneThread("Ds2", cdl);
            d1.start();
            d2.start();
            WorkThread w1 = new WorkThread("Wd1", cdl, 2);
            WorkThread w2 = new WorkThread("Wd2", cdl, 3);
            WorkThread w3 = new WorkThread("Wd3", cdl, 4);
            w1.start();
            w2.start();
            w3.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
