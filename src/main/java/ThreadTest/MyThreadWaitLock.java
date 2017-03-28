package ThreadTest;

/**
 * @author chengangw
 * @date 21/2/2017 4:49 PM
 */
public class MyThreadWaitLock extends Thread {
    static class ThreadDomain {
        public void testMethod(Object lock) {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " Begin wait()");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " End wait()");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Object lock;

    public MyThreadWaitLock(Object lock) {
        this.lock = lock;
    }

    public void run() {
        ThreadDomain td = new ThreadDomain();
        td.testMethod(lock);
    }

    public static void main(String[] args) {
        Object lock = new Object();
        MyThreadWaitLock myThreadWaitLock = new MyThreadWaitLock(lock);
        MyThreadWaitLock myThreadWaitLock1 = new MyThreadWaitLock(lock);
        myThreadWaitLock.start();
        myThreadWaitLock1.start();
    }
}
