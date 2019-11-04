package list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author DreamYee
 * @Create 2019/11/04  15:28
 */
public class copylist {
    private static volatile CopyOnWriteArrayList<String> arrayList=new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException{
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                //修改list中下标为1的元素baba
                arrayList.set(1,"baba");

                //删除元素
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });

        //保证在修改线程启动前获取迭代器
        Iterator<String> iterator=arrayList.iterator();

        //启动线程
        threadOne.start();

        //等待线程执行完毕
        threadOne.join();

        //迭代元素
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
