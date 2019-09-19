package DataStructures.pro0919PolanNotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author DreamYee
 * @Create 2019/09/19  19:13
 */
public class PolanNotation {



    public static void main(String[] args) {

        //要完成将中缀表达式转化为后缀表达式的功能
        //说明
        //1. 1+((2+3)*4-5   =>1 2 3 + 4 * + 5 -
        //2.直接对一个字符串进行操作不方便，先将1+((2+3)*4-5转为中缀表达式的List
        //即把1+((2+3)*4-5转为ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
        String expression="1+((2+3)*4-5";
        List<String> infixExpressionList=toInfixExpressionList(expression);
        System.out.println(infixExpressionList);

        /**
        //先定义一个逆波兰表达式
        //(3+4)*5-6  =>  3 4 + 5 * 6 -
        //为了表达方便，数字跟符号用空格隔开
        //(30+4)*20-21  =>   30 4 + 20 * 21 -
        //4*5-8+60+8/2  =>  4 5 * 8 - 60 + 8 2 / +
         String suffixExpression="4 5 * 8 - 60 + 8 2 / +";
      //思路
        //1.先将3 4 + 5 * 6 -放到ArrayList中
        //2.将ArrayList传递给一个方法，遍历ArrayList，配合栈完成计算
        List<String> rpnList=getListString(suffixExpression);
        System.out.println("rpnList="+rpnList);

        int res=calculate(rpnList);
        System.out.println("计算的结果是："+res);
         */
    }

    //方法：将中缀表达式转化为对应的List
    //s = "1+((2+3)*4-5"
    public static List<String> toInfixExpressionList(String s){
        //定义一个List，存放中缀表达式对应的内容
        List<String> ls=new ArrayList<String>();
        int i=0;//这是一个变量，用于遍历中缀表达式字符串
        String str;//做对多位数的拼接
        char c;//每遍历到一个字符，就放入c
        do{
            //如果c是一个非数字，就需要加入到ls中
            if((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                ls.add(""+c);
                i++;//i需要后移
            }else{//如果是一个数，需要考虑多位数
                str="";//先将str置成"" '0'[48]->'9'[57]
                while(i<s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57){
                    str+=c;//拼接
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
    }

    //将一个逆波兰表达式，依次将数据跟运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] split=suffixExpression.split(" ");
        List<String> list=new ArrayList<>();
        for(String ele:split){
            list.add(ele);
        }
        return list;
    }

    //计算完成对逆波兰表达式的运算
    public static int calculate(List<String> ls){
        //只需要一个栈即可
        Stack<String> stack=new Stack<String>();
        //遍历ls
        for(String  item:ls){
            //使用正则表达式来取出数
            if(item.matches("\\d+")){//匹配多位数
                //入栈
                stack.push(item);
            }else {
                //pop出两个数并运算，再入栈
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1+num2;
                }else if(item.equals("-")){
                    res= num1-num2;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if(item.equals("/")){
                    res=num1/num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res+"");
            }
        }
        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
}
