package DataStructures.pro0914SingleLinkedList;

import java.util.Stack;

/**
 * @Author DreamYee
 * @Create 2019/09/15  17:49
 */
//演示Stack的基本使用
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        //出栈
        while(stack.size()>0){
            System.out.println(stack.pop());//pop()就是将栈顶的数据取出
        }
    }
}
