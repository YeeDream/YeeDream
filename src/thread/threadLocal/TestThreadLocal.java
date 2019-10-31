package thread.threadLocal;

/**
 * @Author DreamYee
 * @Create 2019/10/31  21:36
 */
public class TestThreadLocal {
    //创建线程变量
    public static ThreadLocal<String> threadLocal=new ThreadLocal<String>();
    public static void main(String[] args){
        //设置线程变量
        threadLocal.set("hello world");
        //启动子线程
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程输出线程变量的值
                System.out.println("thread:"+threadLocal.get());
            }
        });
        thread.start();

        //主线程输出线程变量的值
        System.out.println("main:"+threadLocal.get());
    }
}
