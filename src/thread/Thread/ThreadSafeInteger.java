package thread.Thread;

/**
 * @Author DreamYee
 * @Create 2019/11/01  21:51
 */

//使用synchronized关键字进行同步
public class ThreadSafeInteger {
    private int value;

    public synchronized int get(){
        return value;
    }

    public synchronized void set(int value){
        this.value=value;
    }
}
