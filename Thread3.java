package 复习.多线程_线程池;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author DreamYee
 * @Create 2020/01/02  16:15
 */
public class Thread3 implements Callable {
    @Override
    public Object call() throws Exception {
        for(int i=0;i<10;i++){
            System.out.println(i);
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Thread3 td=new Thread3();
        FutureTask ft=new FutureTask(td);
        Thread tt=new Thread(ft);
        tt.start();
    }

}
