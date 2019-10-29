package thread;

/**
 * @Author DreamYee
 * @Create 2019/10/29  17:59
 */
public class join2 {
    public static void main(String[] args) throws InterruptedException{
        //线程one
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin run!");
                for(;;){
                }
            }
        });

        //获取主线程
        final Thread mainThread=Thread.currentThread();

        //线程two
        Thread threadTwo=new Thread(new Runnable() {
            @Override
            public void run() {
                //休眠1s
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                //中断主线程
                mainThread.interrupt();
            }
        });

        //启动子线程
        threadOne.start();

        //延迟1s启动线程
        threadTwo.start();

        try{
            //等待线程one执行结束
            threadOne.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
