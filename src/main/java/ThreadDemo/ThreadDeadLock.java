package ThreadDemo;

/**
 * @author chengangw
 * @date 23/2/2017 2:56 PM
 */
public class ThreadDeadLock {

    static class DeadLock {

        private final Object right = new Object();
        private final Object left = new Object();

        public void leftRight() throws InterruptedException {
            synchronized (left) {
                Thread.sleep(2000);
                synchronized (right) {
                    System.out.println("leftRight end");
                }
            }
        }

        public void rightLeft() throws InterruptedException {
            synchronized (right) {
                Thread.sleep(2000);
                synchronized (left) {
                    System.out.println("rightLeft end");
                }
            }
        }
    }

    static class MyThreadDl01 extends Thread {
        private DeadLock deadLock;

        public MyThreadDl01(DeadLock deadLock) {
            this.deadLock = deadLock;
        }

        public void run() {
            try {
                deadLock.leftRight();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThreadDl02 extends Thread {
        private DeadLock deadLock;

        public MyThreadDl02(DeadLock deadLock) {
            this.deadLock = deadLock;
        }

        public void run() {
            try {
                deadLock.rightLeft();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        MyThreadDl01 myThreadDl01 = new MyThreadDl01(dl);
        MyThreadDl02 myThreadDl02 = new MyThreadDl02(dl);
        myThreadDl01.start();
        myThreadDl02.start();
    }
}
