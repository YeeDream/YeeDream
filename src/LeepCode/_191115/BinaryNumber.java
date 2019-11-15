package LeepCode._191115;

/**
 * @Author DreamYee
 * @Create 2019/11/15  11:35
 */
/*给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。*/
public class BinaryNumber {
    public boolean hasAlternatingBits(int n) {
        String s=Integer.toBinaryString(n);
        char num='2';
        for(char c:s.toCharArray()){
            if(num!=c){
                num=c;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryNumber bn=new BinaryNumber();
        int n=5;
        System.out.println(bn.hasAlternatingBits(n));
    }
}
