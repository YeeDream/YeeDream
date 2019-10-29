package thread.function;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author DreamYee
 * @Create 2019/10/28  17:16
 */
public class ThreadTest {
    //继承Thread类并重写run方法
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("I am a child Thread thread");
        }
    }

    public static class RunnableTask implements Runnable{
        @Override
        public void run() {
            System.out.println("I am a child runnable thread");
        }
    }

    //创建任务类，类似Runnable
    public static class CallerTask implements Callable{
        @Override
        public Object call() throws Exception {
            for(int i=0;i<10;i++){
                System.out.println("hello"+i);
                Thread.sleep(1000);
            }
            return "hello";
        }
    }

    public static void main(String[] args) throws InterruptedException {
       /*
        //创建线程
        Thread thread=new MyThread();
        //启动线程
        thread.start();

        RunnableTask runnableTask=new RunnableTask();
        new Thread(runnableTask).start();
        */

       /*
        //创建异步任务
        FutureTask<String> futureTask=new FutureTask<>(new CallerTask());
        //启动线程
        try{
            CallerTask callerTask=new CallerTask();
            callerTask.call();
            //等待任务执行完毕，并返回结果
            String result=futureTask.get();
            System.out.println(result);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        */

        CallerTask c1=new CallerTask();
        FutureTask f1=new FutureTask(c1);
        Thread t1=new Thread(f1);
        t1.start();
//        Object o1=new Object();
//        Object o2=new Object();
//        System.out.println(o1);
//        System.out.println(o2);

    }
}
