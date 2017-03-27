package ThreadDemo;

import java.util.concurrent.*;

/**
 * Created by chengangw on 27/3/17.
 */
public class CallableFutureThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("CallableFutureThread的Call()方法，开始睡觉，睡觉时间为" + System.currentTimeMillis());
        Thread.sleep(10000);
        return "123";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newCachedThreadPool();
        CallableFutureThread ct = new CallableFutureThread();
        Future<String> future = es.submit(ct);
        es.shutdown();

        Thread.sleep(5000);
        System.out.println("主线程等待5s，当前时间" + System.currentTimeMillis());

        String s = future.get();
        System.out.println("Future已拿到数据，str = " + s + "，当前时间" + System.currentTimeMillis());
    }
}
