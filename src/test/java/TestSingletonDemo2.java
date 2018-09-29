import GOF.pattern.*;

import java.util.concurrent.CountDownLatch;

/**
 * 测试我们讲述的4种单例模式的多线程性能
 */
public class TestSingletonDemo2 {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        int threadNum = 10;

        /*
            1.CountDownLatch：
                一个同步辅助类，在完成一组正在其他线中执行操作之前，他允许一个或多个线程一直在等待.
                1.countDown():当一个线程调用此方法，则计数值减一（建议放在finally中执行）
                2.await():调用此方法的线程一直会出于阻塞状态，直到计数器为0。
            2.CountDownLatch应该是final的，这样其他线程才可以使用：
                因为CountDownLatch创建在main线程中，main线程一旦执行完，countDownLatch这个局部
                变量会随着方法出栈而销毁，所以导致其他线程不能使用会出现空指针异常。如果加了final过后，
                其他线程调用该变量，会将一个副本复制过去，保证不会出现空指针异常。

         */
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for(int j = 0;j<threadNum;j++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000000; i++) {
                        //将SingletonDemo1到SingletonDemo4一次改变进行测试。
                        //Object o = SingletonDemo1.getInstance();
                        Object o = SingletonDemo5.Instace;
                    }
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }

        countDownLatch.await();//main线程阻塞，直到计数器变为0

        long end = System.currentTimeMillis();
        System.out.println(end -start);
    }

}


