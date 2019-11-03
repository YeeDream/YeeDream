package thread.threadLocal.threadLocalRandom;

import sun.misc.Unsafe;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author DreamYee
 * @Create 2019/11/03  20:33
 */
public class RandomTest {
    public static void main(String[] args) {
        //创建一个默认种子的随机数生成器
        Random random=new Random();

        //获取一个随机数生成器
        ThreadLocalRandom random1 =ThreadLocalRandom.current();

        //输出10个0-5之间的随机数（包含0，不包含5）
        for(int i=0;i<10;i++){
            System.out.println(random1.nextInt(5));
        }

    }

}
