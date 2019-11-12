package LeepCode._191112;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author DreamYee
 * @Create 2019/11/12  19:35
 */
/*对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。
例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
*/
public class ArrayFormAdd {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int length=A.length;
        int lastNum=K;
        LinkedList<Integer> ret=new LinkedList<>();
        int i=length-1;
        while (i>=0 ||lastNum>0){
            if(i>=0){
                lastNum+=A[i];
            }
            ret.addFirst(lastNum%10);
            lastNum/=10;
            i--;
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayFormAdd af=new ArrayFormAdd();
        int[] A={1,2,0,0};
        int K=34;
        System.out.println(af.addToArrayForm(A,K));
    }
}
