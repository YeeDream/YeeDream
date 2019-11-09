package LeepCode._191109;

/**
 * @Author DreamYee
 * @Create 2019/11/09  18:33
 */
/*请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；
你需要返回可能的方案总数。
让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
*/
public class 质数 {
    public int numPrimeArrangements(int n) {
        int count=0,notcount=0;
        Long sum=1L;
        //计算质数的个数
        for(int i=1;i<=n;i++){
            count+=isPrime(i);
        }
        notcount=n-count;

        for(int i=1;i<=count;i++){
            sum=sum*i%(1000000000+7);
        }
        for(int i=1;i<=notcount;i++){
            sum=sum*i%(1000000000+7);
        }
        return sum.intValue();
    }

    //判断一个数是否是质数
    public int isPrime(int num){
        if(num<2){
            return 0;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        质数 zz=new 质数();
        System.out.println(zz.numPrimeArrangements(5));
    }
}
