package ThreadDemo;

/**
 * Copyright: Property of Singapore Prison Service. The contents shall not be reproduced,
 * republished, uploaded, posted, transmitted * or otherwise distributed in any way,
 * without the prior permission of Singapore Prison Service
 *
 * @author chengangw
 * @version 0.0.1
 * @date 3/8/2016 1:24 PM
 */
public class RunnableDemo implements Runnable {
    private int ticket = 5;
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                System.out.println("Ticket = " + ticket--);
            }
        }
    }
    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        new Thread(runnableDemo).start();
        new Thread(runnableDemo).start();
        new Thread(runnableDemo).start();
    }
}
