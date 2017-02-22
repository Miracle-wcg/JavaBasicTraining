package ThreadDemo;

/**
 * @author chengangw
 * @date 22/2/2017 4:54 PM
 */
public class ThreadSynchronizedBlock {
    public static class ThreadDomain20 {
        public synchronized void otherMethod() {
            System.out.println("----------run--otherMethod");
        }

        public void doLongTask() {
            synchronized (this) {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("synchronized threadName = " +
                            Thread.currentThread().getName() + ", i = " + (i + 1));
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class MyThread20_0 extends Thread {
        private ThreadDomain20 td;

        public MyThread20_0(ThreadDomain20 td) {
            this.td = td;
        }

        public void run() {
            td.doLongTask();
        }
    }

    public static class MyThread20_1 extends Thread {
        private ThreadDomain20 td;

        public MyThread20_1(ThreadDomain20 td) {
            this.td = td;
        }

        public void run() {
            td.otherMethod();
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadDomain20 td = new ThreadDomain20();
        MyThread20_0 mt0 = new MyThread20_0(td);
        MyThread20_1 mt1 = new MyThread20_1(td);
        mt0.start();
        Thread.sleep(100);
        mt1.start();
    }
}
