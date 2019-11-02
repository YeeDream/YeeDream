package thread.Thread;

/**
 * @Author DreamYee
 * @Create 2019/11/02  10:00
 */
public class ReadThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            if(ready){
                System.out.println(num+num);
            }
            System.out.println("read thread...");
        }
    }

    public static class Writethread extends Thread{
        @Override
        public void run() {
            num=2;
            ready=true;
            System.out.println("WriteThread set over...");
        }
    }

    private static int num=0;
    private static boolean ready=true;

    public static void main(String[] args) throws InterruptedException{
        ReadThread rt=new ReadThread();
        rt.start();

        Writethread wt=new Writethread();
        wt.start();

        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main exit");
    }


}




