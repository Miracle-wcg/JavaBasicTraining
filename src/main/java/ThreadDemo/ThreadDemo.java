package ThreadDemo;

/**
 * Copyright: Property of Singapore Prison Service. The contents shall not be reproduced,
 * republished, uploaded, posted, transmitted * or otherwise distributed in any way,
 * without the prior permission of Singapore Prison Service
 *
 * @author chengangw
 * @version 0.0.1
 * @date 3/8/2016 11:53 AM
 */
public class ThreadDemo extends Thread {
    private int ticket = 5;

    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                System.out.println("Ticket = " + ticket--);
            }
        }
    }

    public static void main(String[] args) {
        new ThreadDemo().start();
        new ThreadDemo().start();
        new ThreadDemo().start();
    }
}
