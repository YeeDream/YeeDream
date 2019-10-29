package thread.function;

/**
 * @Author DreamYee
 * @Create 2019/10/28  18:31
 */
public class WaitNotifyInterupt {
    static Object obj=new Object();

    public static void main(String[] args) throws InterruptedException{
        //创建线程
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("---begin---");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        threadA.start();

        Thread.sleep(1000);

        System.out.println("---begin interrupt threadA---");
        threadA.interrupt();
        System.out.println("---end interrupt threadA---");
    }
}
