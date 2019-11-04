package list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author DreamYee
 * @Create 2019/11/04  15:11
 */
public class aaa {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrayList=new CopyOnWriteArrayList<>();
        arrayList.add("hello");
        arrayList.add("alibaba");

        Iterator<String> itr=arrayList.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
