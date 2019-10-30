package thread.Thread;

/**
 * @Author DreamYee
 * @Create 2019/10/30  18:36
 */
public class thread {
    public static void main(String[] args) {
        Thread daemonThread=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){

                }
            }
        });

        //启动子线程
        thread.start();
        System.out.println("main thread is over");
    }
}
