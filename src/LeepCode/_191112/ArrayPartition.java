package LeepCode._191112;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/11/12  20:27
 */
/*给定长度为 2n 的数组, 你的任务是将这些数分成 n 对,
例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
*/
public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2){
            sum+=nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayPartition ap=new ArrayPartition();
        int[] nums={1,4,3,2};
        System.out.println(ap.arrayPairSum(nums));
    }
}
