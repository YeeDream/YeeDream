package thread.safe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author DreamYee
 * @Create 2019/11/02  8:47
 */
public class TestSafe {

    /**

    //获取Unsafe的实例
    static final Unsafe unsafe = Unsafe.getUnsafe();

    //记录变量state在类TestSafe中的偏移值
    static final long stateOffset ;

    //变量
    private volatile long state = 0;

    static {
        try {
            //获取state变量在类TestUnSafe中的偏移值
            stateOffset=unsafe.objectFieldOffset(TestSafe.class.getDeclaredField("state"));
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

     */

    static final Unsafe unsafe;
    static final long stateOffset;
    private volatile long state=0;

    static {
        try{
            //使用反射获取Unsafe的成员变量theUnsafe
            Field field=Unsafe.class.getDeclaredField("theUnsafe");

            //设置为可存取
            field.setAccessible(true);

            //获取该变量的值
            unsafe=(Unsafe) field.get(null);

            //获取state在TestUnsafe中的偏移量
            stateOffset=unsafe.objectFieldOffset(TestSafe.class.getDeclaredField("state"));
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestSafe testSafe=new TestSafe();
        Boolean success=unsafe.compareAndSwapInt(testSafe,stateOffset,0,1);
        System.out.println(success);
    }
}
