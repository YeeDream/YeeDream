package DataStructures.pro0921Recursion;

/**
 * @Author DreamYee
 * @Create 2019/09/21  17:54
 */
public class RecursionTest {
    public static void main(String[] args) {
        //通过打印问题回归递归机制
        test(4);
        System.out.println("---------------------");
        int res=factorial(4);
        System.out.println("res="+res);
    }

    //打印问题
    public static void test(int n){
        if(n>2){
            test(n-1);
        }//else {
            System.out.println("n=" + n);
       // }
    }

    //阶乘问题
    public static int factorial(int n){
        if(n==1){
            return 1;
        }else {
            return factorial(n-1)*n;
        }
    }

}
