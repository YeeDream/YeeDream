package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author DreamYee
 * @Create 2019/10/29  18:06
 */
public class sleep {
    //创建一个独占锁
    private static final Lock lock=new ReentrantLock();

    public static void main(String[] args) throws InterruptedException{
        //创建线程A
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try{
                    System.out.println("child threadA is in sleep");

                    Thread.sleep(10000);

                    System.out.println("child threadA is in awaked");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    //释放锁
                    lock.unlock();
                }
            }
        });

        //创建线程B
        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try{
                    System.out.println("child threadB is in sleep");

                    Thread.sleep(10000);

                    System.out.println("child threadB is in awaked");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    //释放锁
                    lock.unlock();
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();
    }
}
