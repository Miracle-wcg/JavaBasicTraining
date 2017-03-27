package ThreadDemo;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by chengangw on 27/3/17.
 */
public class CyclicBarrierThread extends Thread {
    private CyclicBarrier cb;
    private int sleepSecond;

    public CyclicBarrierThread(CyclicBarrier cb, int sleepSecond) {
        this.cb = cb;
        this.sleepSecond = sleepSecond;
    }

    public void run() {
        try {
            System.out.println(this.getName() + "运行了..");
            Thread.sleep(sleepSecond * 1000);
            System.out.println(this.getName() + "准备等待了，时间为" + System.currentTimeMillis());
            cb.await();
            System.out.println(this.getName() + "结束等待了，时间为" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("CyclicBarrier的所有线程await()结束了，运行了，时间为" + System.currentTimeMillis());
            }
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, runnable);
        CyclicBarrierThread cyclicBarrierThread = new CyclicBarrierThread(cyclicBarrier, 3);
        CyclicBarrierThread cyclicBarrierThread1 = new CyclicBarrierThread(cyclicBarrier, 6);
        CyclicBarrierThread cyclicBarrierThread2 = new CyclicBarrierThread(cyclicBarrier, 9);
        cyclicBarrierThread.start();
        cyclicBarrierThread1.start();
        cyclicBarrierThread2.start();
    }

}
