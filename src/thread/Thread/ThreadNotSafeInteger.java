package thread.Thread;

/**
 * @Author DreamYee
 * @Create 2019/11/01  21:49
 */
//线程不安全
public class ThreadNotSafeInteger {
    private int value;
    public int get(){
        return value;
    }

    public void set(int value){
        this.value=value;
    }
}
