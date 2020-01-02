package 复习.多线程_线程池;

/**
 * @Author DreamYee
 * @Create 2020/01/02  16:08
 */
public class Thread2 implements Runnable {
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
        Thread2 td=new Thread2();
        Thread tt=new Thread(td);
        tt.start();
    }
}
