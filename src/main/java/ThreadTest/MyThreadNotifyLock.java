package ThreadTest;

/**
 * @author chengangw
 * @date 21/2/2017 4:58 PM
 */
public class MyThreadNotifyLock {
    static class ThreadDomain1 {
        public void testMethod1(Object lock) {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "  Begin wait()");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "  End wait()");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void synNotifyMethod(Object lock) {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "  Begin Notify()");
                    lock.notify();
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + "  End Notify()");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThreadNotify01 extends Thread {

        private Object lock;

        public MyThreadNotify01(Object lock) {
            this.lock = lock;
        }

        public void run() {
            ThreadDomain1 td = new ThreadDomain1();
            td.testMethod1(lock);
        }
    }

    static class MyThreadNotify02 extends Thread {

        private Object lock;

        public MyThreadNotify02(Object lock) {
            this.lock = lock;
        }

        public void run() {
            ThreadDomain1 td = new ThreadDomain1();
            td.synNotifyMethod(lock);
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        MyThreadNotify01 mt = new MyThreadNotify01(lock);
        mt.start();
        MyThreadNotify02 mt1 = new MyThreadNotify02(lock);
        mt1.start();
        MyThreadNotify02 mt2 = new MyThreadNotify02(lock);
        mt2.start();
    }

}
