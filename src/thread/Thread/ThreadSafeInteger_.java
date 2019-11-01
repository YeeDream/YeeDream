package thread.Thread;

/**
 * @Author DreamYee
 * @Create 2019/11/01  21:52
 */

//使用volatile进行同步
public class ThreadSafeInteger_ {
    private   volatile int value;

    public int get(){
        return value;
    }

    public void set(int value){
        this.value=value;
    }
}
