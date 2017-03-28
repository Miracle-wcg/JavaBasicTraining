package ThreadTest;

/**
 * @author chengangw
 * @date 21/2/2017 4:00 PM
 */
public class MyThread8 extends Thread {
    private Object lock;

    public MyThread8(Object lock) {
        this.lock = lock;
    }

    public void run() {
        try {
            synchronized (lock) {
                System.out.println("Start +++ wait time:" + System.currentTimeMillis());
                lock.wait();
                System.out.println("End +++ wait time:" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread8_1 extends Thread {
        private Object lock;

        public MyThread8_1(Object lock) {
            this.lock = lock;
        }

        public void run() {
            synchronized (lock) {
                System.out.println("Start ++ notify time:" + System.currentTimeMillis());
                lock.notify();
                System.out.println("End ++ notify time:" + System.currentTimeMillis());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThread8 myThread8 = new MyThread8(lock);
        myThread8.start();
        Thread.sleep(3000);
        MyThread8_1 myThread8_1 = new MyThread8_1(lock);
        myThread8_1.start();

    }
}
