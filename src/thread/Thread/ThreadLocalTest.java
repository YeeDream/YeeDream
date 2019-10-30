package thread.Thread;

/**
 * @Author DreamYee
 * @Create 2019/10/30  19:05
 */
public class ThreadLocalTest {

    //print()函数
    static void print(String str){
        //1.1打印当前线程本地内存中localVariable变量的值
        System.out.println(str+":"+localVariable.get());
        //1.2清楚当前线程本地内存中localVariable变量
        localVariable.remove();
    }

    //2.创建localVariable变量
    static ThreadLocal<String> localVariable=new ThreadLocal<>();

    public static void main(String[] args) {
        //3.创建线程one
        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                //3.1设置线程one中本地变量localVariable的值
                localVariable.set("threadOne local variable");
                //3.2调用打印函数
                print("threadOne");
                //3.3打印本地变量值
                System.out.println("threadOne remove after"+":"+localVariable.get());
            }
        });
        //4.创建线程two
        Thread threadTwo=new Thread(new Runnable() {
            @Override
            public void run() {
                //4.1设置变量two中本地变量localVariable的值
                localVariable.set("threadTwo local variable");
                //4.2调用打印函数
                print("threadTwo");
                //4.3打印本地变量值
                System.out.println("threadTwo remove after"+":"+localVariable.get());
            }
        });

        //5.启动线程
        threadOne.start();
        threadTwo.start();
    }



}
