package thread.exercise.number5;

/**
 * @author wangyadong
 * 2018/11/12 13:00
 */
public class AboutDoubleStart {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t1.start();
        t1.start();
    }
}
