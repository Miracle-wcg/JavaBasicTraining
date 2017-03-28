package ThreadTest;

/**
 * @author chengangw
 * @date 21/2/2017 5:45 PM
 */
public class MyThreadNotifyAll {
    static class ThreadDomain3 {
        public void testMethod(Object lock) {
            try {
                synchronized (lock) {
                    System.out.println("Begin wait(), Thread Name:" + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("End wait(), Thread Name:" + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThreadNotifyAll0 extends Thread {
        private Object lock;

        public MyThreadNotifyAll0(Object lock) {
            this.lock = lock;
        }

        public void run() {
            ThreadDomain3 td = new ThreadDomain3();
            td.testMethod(lock);
        }
    }

    static class MyThreadNotifyAll1 extends Thread {
        private Object lock;

        public MyThreadNotifyAll1(Object lock) {
            this.lock = lock;
        }

        public void run() {
            synchronized (lock) {
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThreadNotifyAll0 mtd = new MyThreadNotifyAll0(lock);
        MyThreadNotifyAll0 mtd1 = new MyThreadNotifyAll0(lock);
        MyThreadNotifyAll0 mtd2 = new MyThreadNotifyAll0(lock);
        mtd.start();
        mtd1.start();
        mtd2.start();
        Thread.sleep(5000);
        MyThreadNotifyAll1 myThreadNotifyAll1 = new MyThreadNotifyAll1(lock);
        myThreadNotifyAll1.start();
    }
}
