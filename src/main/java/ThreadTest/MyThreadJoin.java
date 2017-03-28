package ThreadTest;

/**
 * @author chengangw
 * @date 22/2/2017 11:03 AM
 */
public class MyThreadJoin {
    static class MyThreadJoin01 extends Thread {
        public void run() {
            try {
                int secondValue = (int) (Math.random() * 10000);
                System.out.println(secondValue);
                Thread.sleep(secondValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadJoin01 myThreadJoin01 = new MyThreadJoin01();
        /*Causes this thread to begin execution;the Java Virtual Machine calls the run method of this thread.
        * The result is that two threads are running concurrently:
        * the current thread(which returns from the call to the start method)
        * and the other thread(which executes its run method).
        * It is never legal to start a thread more than once.
        * In particular, a thread may not be restarted once it has completed execution.*/
        myThreadJoin01.start();
        /*Waits for this thread to die.*/
        myThreadJoin01.join();
        System.out.println("Main Thread end");
    }
}
