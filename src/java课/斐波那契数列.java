package java课;
import java.util.Scanner;
public class 斐波那契数列 {
    public static int  F(int i){
        if(i<3){
            return 1;
        }else{
            return F(i-1)+F(i-2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你要获取到第几个数：");
        int n=scanner.nextInt();
        for(int i=1;i<=n;i++){
            new 斐波那契数列().F(i);
            System.out.println(F(i));
        }
    }
}
