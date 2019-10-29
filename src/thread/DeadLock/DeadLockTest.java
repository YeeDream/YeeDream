package thread.DeadLock;

import sun.awt.windows.ThemeReader;

/**
 * @Author DreamYee
 * @Create 2019/10/29  20:23
 */
public class DeadLockTest {

    //创建资源
    private static Object resourceA=new Object();
    private static Object resourceB=new Object();

    public static void main(String[] args) {
        //创建线程A
        Thread  threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread()+"get ResourceA");

                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread()+"waiting get sourceB");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread()+"get ResourceB");
                    }
                }
            }
        });

        //创建线程B
        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB){
                    System.out.println(Thread.currentThread()+"get ResourceB");
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread()+"waiting get sourceA");
                    synchronized (resourceA){
                        System.out.println(Thread.currentThread()+"get ResourceA");
                    }
                };
            }
        });

        //启动线程
        threadA.start();
        threadB.start();
    }
}
