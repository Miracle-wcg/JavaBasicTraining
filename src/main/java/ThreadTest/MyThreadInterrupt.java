package ThreadTest;

/**
 * @author chengangw
 * @date 21/2/2017 5:11 PM
 */
public class MyThreadInterrupt {
    static class ThreadDomain {
        public void testMethod(Object lock) {
            try {
                synchronized (lock) {
                    System.out.println("Begin wait()");
                    lock.wait();
                    System.out.println("End wait()");
                }
            } catch (InterruptedException e) {
                System.out.println("wait() was interrupted");
                e.printStackTrace();
            }
        }
    }

    static class MyThread01 extends Thread {
        private Object lock;

        public MyThread01(Object lock) {
            this.lock = lock;
        }

        public void run() {
            ThreadDomain td = new ThreadDomain();
            td.testMethod(lock);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThread01 myThread01 = new MyThread01(lock);
        myThread01.start();
        Thread.sleep(5000);
        myThread01.interrupt();
    }
}
