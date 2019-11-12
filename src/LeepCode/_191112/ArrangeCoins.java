package LeepCode._191112;

/**
 * @Author DreamYee
 * @Create 2019/11/12  19:50
 */
/*你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
给定一个数字 n，找出可形成完整阶梯行的总行数。
n 是一个非负整数，并且在32位有符号整型的范围内。
*/
public class ArrangeCoins {
    public int arrangeCoins(int n) {
        int res=0;
        int i=1;
        while (n>0){
            n-=i;
            if(n<i+1){
                res=i;
                break;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrangeCoins ac=new ArrangeCoins();
        int n=8;
        System.out.println(ac.arrangeCoins(n));
    }
}
