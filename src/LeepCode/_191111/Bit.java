package LeepCode._191111;

/**
 * @Author DreamYee
 * @Create 2019/11/11  14:17
 */
/*有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10或11)来表示。
现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
*/
public class Bit {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i=0;i<bits.length;i++){
            if(i==bits.length-1){
                return true;
            }
            if(bits[i]==1){
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Bit bit=new Bit();
        int[] bits={1,0,0,1,0};
        System.out.println(bit.isOneBitCharacter(bits));
    }
}
