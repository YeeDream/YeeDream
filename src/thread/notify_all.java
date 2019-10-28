package thread;

/**
 * @Author DreamYee
 * @Create 2019/10/28  19:02
 */
public class notify_all {
    private static volatile Object resourceA=new Object();

    public static void main(String[] args) throws InterruptedException{
        //创建线程
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                //获取resourceA共享资源的监听器锁
                synchronized (resourceA){
                    System.out.println("threadA get resourceA lock");
                    try{
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        //创建线程
        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadB get resourceA lock");
                    try{
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        //创建线程
        Thread threadC=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadC begin notify");
                    //resourceA.notifyAll();
                    resourceA.notify();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        //等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();
    }
}
