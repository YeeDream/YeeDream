package thread;

import sun.misc.Unsafe;
import sun.misc.VMSupport;

/**
 * @Author DreamYee
 * @Create 2019/11/03  21:01
 */
public class AtomicLong extends Number implements java.io.Serializable {
    private static final long serialVersionUID=1927816293512124184L;

    //获取Unsafe实例
    private static final Unsafe unsafe=Unsafe.getUnsafe();

    //存放变量value的偏移量
    private static final long valueOffest;

    //判断JVM是否支持long类型无锁cas
    static final boolean VM_SUPPORTS_LONG_CAS= VMSupportsCS8();
    private static native boolean VMSupportsCS8();

    static {
        try{
            //获取value在AtomicLong中的偏移量
            valueOffest=unsafe.objectFieldOffset(AtomicLong.class.getDeclaredField("value"));
        }catch (Exception e){
            throw new Error(e);
        }
    }

    //实际变量值
    private volatile long value;

    public AtomicLong(long initialValue){
        value=initialValue;
    }
}
