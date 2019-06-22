package join;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by HP on 2019/6/22.
 * 实现线程顺序执行的两种方式
 * 1.join方法
 * 2.利用线程池Executors.newSingleThreadExecutor();
 */
public class JoinTest {

    static Thread t1 = new Thread(new Runnable() {
        public void run() {
            System.out.println("这是一号线程");
        }
    });
    static Thread t2 = new Thread(new Runnable() {
        public void run() {
            System.out.println("这是二号线程");
        }
    });
    static Thread t3 = new Thread(new Runnable() {
        public void run() {
            System.out.println("这是三号线程");
        }
    });


    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();

        ExecutorService singleService = Executors.newSingleThreadExecutor();
        singleService.submit(t1);
        singleService.submit(t2);
        singleService.submit(t3);
        singleService.shutdown();
    }
}
