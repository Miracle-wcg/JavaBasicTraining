package ThreadTest;

/**
 * @author chengangw
 * @date 22/2/2017 5:27 PM
 */
public class ThreadVolatile {
    public static class MyThread28 extends Thread {
        private volatile boolean isRunning = true;

        public boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }

        public void run() {
            System.out.println("start run");
            while (isRunning == true) {
            }
            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) {
        try {
            MyThread28 mt = new MyThread28();
            mt.start();
            Thread.sleep(1000);
            mt.setRunning(false);
            System.out.println("Set false already");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
