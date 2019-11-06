package LeepCode._191106;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @Author DreamYee
 * @Create 2019/11/06  22:21
 */
/*在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
返回可以通过分割得到的平衡字符串的最大数量。
*/
public class SplitChar {
    public int balancedStringSplit(String s) {
        int sum=0,countL=0,countR=0;
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='L'){
                countL++;
            }else {
                countR++;
            }
            if (countL==countR){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SplitChar sc=new SplitChar();
        String s="RRLLRLLLRR";
        System.out.println(sc.balancedStringSplit(s));
    }
}
