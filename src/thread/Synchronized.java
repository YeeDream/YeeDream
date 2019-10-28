package thread;

/**
 * @Author DreamYee
 * @Create 2019/10/28  17:41
 */
public class Synchronized {
    //创建资源
    private static volatile Object resourceA=new Object();
    private static volatile Object resourceB=new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA){
                        System.out.println("threadA get resourceA lock");
                        //获取resourceB共享资源的监听器锁
                        synchronized (resourceB){
                            System.out.println("threadA get resourceB lock");

                            //线程A阻塞，并释放获取到的resourceA的锁
                            System.out.println("threadA release resourceA lock");
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //创建线程
        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    //休眠1s
                    Thread.sleep(1000);

                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA){
                        System.out.println("threadB get resourceA lock");

                        System.out.println("threadB try get resourceA lock...");

                        //获取resourceB共享资源的监听器锁
                        synchronized (resourceB){
                            System.out.println("threadB get resourceB lock");
                            //线程B阻塞，并释放获取到的resourceA的锁
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();

        //等待两个线程结束
        threadA.join();
        threadB.join();

        System.out.println("main over");
    }


}
