package LeepCode._191107;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/11/07  20:38
 */
/*给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
*/
public class balloon {
    public int maxNumberOfBalloons(String text) {
        int num=0;
        int b=0,a=0,l=0,o=0,n=0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)=='b'){
                b++;
            }else if(text.charAt(i)=='a'){
                a++;
            }else if(text.charAt(i)=='l'){
                l++;
            }else if(text.charAt(i)=='o'){
                o++;
            }else if(text.charAt(i)=='n'){
                n++;
            }
        }
        l/=2;
        o/=2;
        int[] arr={b,a,l,o,n};
        Arrays.sort(arr);
        num=arr[0];
        return num;
    }

    public static void main(String[] args) {
        balloon ba=new balloon();
        String text="loonbalxballpoon";
        System.out.println(ba.maxNumberOfBalloons(text));
    }
}
