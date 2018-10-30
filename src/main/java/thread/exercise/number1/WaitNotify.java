package thread.exercise.number1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 测试多线程wait/notify模型
 * wangyadong
 */
public class WaitNotify {

    List<String> list = new ArrayList<>();

    final Object lock = new Object();
    public void put() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        synchronized (lock){
            System.out.println("向list中放入数据。。");
            for(int i=0;i<10;i++){
                list.add("对象"+i);
                if(i==5){
                    //当放入第5个元素的时候，通知阻塞的方法。开始运行。
                    //notify不会释放对象锁，因此，需要等待该线程执行完成之后，阻塞的线程才会执行。
                    lock.notify();
                    System.out.println("t1发出通知。。");
                }
            }
        }
        System.out.println("put运行完成。。");

    }

    /**
     * 获取第i个元素的值，如果不存在，则阻塞
     * @param i
     */
    public String get(int i) throws InterruptedException {
        synchronized (lock){
            System.out.println("get启动。。");
            lock.wait();
        }
        System.out.println("t2收到通知开始运行。。");
        return list.get(i);
    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotify wn = new WaitNotify();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(wn.get(4));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2.start();//注意保证t2比t1早启动
        t1.start();
    }
}
