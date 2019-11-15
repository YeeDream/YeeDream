package LeepCode._191115;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/11/15  12:04
 */
/*给定一个整数数组，判断是否存在重复元素。
如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。*/
public class ContainsElement {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsElement ce=new ContainsElement();
        int[] nums={1,2,3,4,1};
        System.out.println(ce.containsDuplicate(nums));
    }
}
