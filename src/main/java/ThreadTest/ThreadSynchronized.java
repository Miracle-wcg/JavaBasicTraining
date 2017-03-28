package ThreadTest;

/**
 * @author chengangw
 * @date 22/2/2017 4:31 PM
 */
public class ThreadSynchronized {
    static class ThreadDomain022 {
        private int num = 0;

        public synchronized void addNum(String name) {
            try {
                if ("a".equals(name)) {
                    num = 100;
                    System.out.println("a set over ");
                    Thread.sleep(2000);
                } else {
                    num = 200;
                    System.out.println("b set over ");
                    Thread.sleep(2000);
                }
                System.out.println(name + " name = " + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class MyThread0222 extends Thread {
        private ThreadDomain022 threadDomain022;

        public MyThread0222(ThreadDomain022 threadDomain022) {
            this.threadDomain022 = threadDomain022;
        }

        public void run() {
            threadDomain022.addNum("a");
        }
    }

    static class MyThread0222_01 extends Thread {
        private ThreadDomain022 threadDomain022;

        public MyThread0222_01(ThreadDomain022 threadDomain022) {
            this.threadDomain022 = threadDomain022;
        }

        public void run() {
            threadDomain022.addNum("b");
        }
    }

    public static void main(String[] args) {
        ThreadDomain022 td = new ThreadDomain022();
        MyThread0222 mt = new MyThread0222(td);
        MyThread0222_01 mt01 = new MyThread0222_01(td);
        mt.start();
        mt01.start();
    }
}
