package LeepCode._191110;

/**
 * @Author DreamYee
 * @Create 2019/11/10  16:46
 */
/*泰波那契序列 Tn 定义如下： 
T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
*/
public class Triboonacci {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1);
    }

    public int tribonacci1(int n){
        int n1 = 0;
        int n2 = 0;
        int n3 = 1;
        int ret = n;

        for(int i = 1; i < n; i++)
        {
            ret = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = ret;
        }

        return ret;
    }

    public static void main(String[] args) {
        Triboonacci tt=new Triboonacci();
        int n=4;
        System.out.println(tt.tribonacci1(n));
    }
}
