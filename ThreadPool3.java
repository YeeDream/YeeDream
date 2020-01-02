package 复习.多线程_线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author DreamYee
 * @Create 2020/01/02  16:44
 */
public class ThreadPool3 {
    public static void main(String[] args) {
        ExecutorService sin= Executors.newSingleThreadExecutor();
        DemoThread3 tp1=new DemoThread3("A");
        DemoThread3 tp2=new DemoThread3("B");
        DemoThread3 tp3=new DemoThread3("C");
        sin.execute(tp1);
        sin.execute(tp2);
        sin.execute(tp3);
    }
}

class DemoThread3 extends Thread{
    private String name;
    public DemoThread3(String name){
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
