package LeepCode._191116;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/11/16  13:59
 */
/*给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
如果 S[i] == "I"，那么 A[i] < A[i+1]
如果 S[i] == "D"，那么 A[i] > A[i+1]
*/
public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int[] res=new int[S.length()+1];
        int max=S.length();
        int min=0;
        //相当于递减与递增一同赋值
        for(int i=0;i<S.length();i++){
            if('I'==S.charAt(i)){
                res[i]=min++;
            }else {
                res[i]=max--;
            }
        }
        res[S.length()]=max;
        return res;
    }

    public static void main(String[] args) {
        DIStringMatch dm=new DIStringMatch();
        String S="IDID";

    }
}
