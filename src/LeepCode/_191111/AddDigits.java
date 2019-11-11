package LeepCode._191111;

/**
 * @Author DreamYee
 * @Create 2019/11/11  14:46
 */
/*给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。*/
public class AddDigits {
    public int addDigits(int num) {
        return (num-1)%9+1;
    }

    public static void main(String[] args) {
        AddDigits ad=new AddDigits();
        int num=1234;
        System.out.println(ad.addDigits(num));
    }
}
