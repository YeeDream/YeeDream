package java培训课.pro0316;


public class Day2 {
    public static void main(String[] args) {
        //变量：值可以发生改变的量
        /*
        变量的定义：
        数据类型  变量名[=值];
        1.变量名：就是给变量起一个名字
      （一个）规则：（计算机）字母，数字，_（下划线）以及$,其中数字不能在首位，不能使用关键字和保留字
            规范：（人）首字母小写、名词、驼峰userAge
        2.数据类型
          1）.基本（原始）数据类型：只有八个
              整型：  byte(-128—127)  short（-65534—65535）  int long
                      System.out.println(Integer.MAX_VALUE);
                      System.out.println(Integer.MIN_VALUE);
                      System.out.println(Long.MAX_VALUE);
                      System.out.println(Long.MIN_VALUE);
              浮点型：float double
              字符型：(一个字符）char  ''or ASCII
              布尔型：boolean   true or false
          2）.引用（自定义）数据类型：无数个
         */

        byte a1=8;
        short a2=188;
        int a3=987;
        long a4=6789;

        float f1=9.7f;
        double f2=9.3d;

        char c1='2';
        char c2=99;    //ASCII 97 65 48

        boolean b1=true;
        boolean b2=false;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(b1);
        System.out.println(b2);
    }
}
