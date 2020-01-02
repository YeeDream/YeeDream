package 复习.多线程_线程池;

/**
 * @Author DreamYee
 * @Create 2020/01/02  15:35
 */
public class Thread1 extends Thread {

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(i);
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Thread1 th=new Thread1();
        th.start();
    }
}
