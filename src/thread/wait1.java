package thread;

/**
 * @Author DreamYee
 * @Create 2019/10/28  18:45
 */
public class wait1 {
    public final void wait(long timeout,int nanos) throws InterruptedException{
        if(timeout<0){
            throw new IllegalArgumentException("timeout value is negative");
        }

        if(nanos<0 || nanos>999999){
            throw new IllegalArgumentException("nanosecond timeout value out of range");
        }

        if(nanos>0){
            timeout++;
        }

    }
}
