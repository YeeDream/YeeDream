package 复习.多线程_线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author DreamYee
 * @Create 2020/01/02  16:35
 */
public class ThreadPool2 {
    public static void main(String[] args) {
        //定长线程池
        ExecutorService fixed = Executors.newFixedThreadPool(2);
        DemoThread2 tp1 = new DemoThread2("A");
        DemoThread2 tp2 = new DemoThread2("B");
        DemoThread2 tp3 = new DemoThread2("C");
        DemoThread2 tp4 = new DemoThread2("D");
        fixed.execute(tp1);
        fixed.execute(tp2);
        fixed.execute(tp3);
        fixed.execute(tp4);
    }


}

class DemoThread2 extends Thread{
    private String name;
    public DemoThread2(String name){
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
