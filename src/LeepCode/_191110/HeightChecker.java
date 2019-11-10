package LeepCode._191110;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/11/10  17:05
 */
/*学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
*/
/*排序前后位置不一样的返回即可*/
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int count=0;
        int[] temp=heights.clone();
        Arrays.sort(temp);
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=temp[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HeightChecker hc=new HeightChecker();
        int[] heights={1,1,4,2,1,3};
        System.out.println(hc.heightChecker(heights));
    }
}
