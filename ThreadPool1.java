package 复习.多线程_线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author DreamYee
 * @Create 2020/01/02  16:24
 */
public class ThreadPool1 {
    public static void main(String[] args) {
        //产生一个可缓存的线程池
        ExecutorService cached= Executors.newCachedThreadPool();
        DemoThread1 tp1=new DemoThread1("A");
        DemoThread1 tp2=new DemoThread1("B");
        DemoThread1 tp3=new DemoThread1("C");
        cached.execute(tp1);
        cached.execute(tp2);
        cached.execute(tp3);
    }
}

class DemoThread1 extends Thread{
    private String name;
    public DemoThread1(String name){
        this.name=name;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(name+":"+i+"\t"+Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
