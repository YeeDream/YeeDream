package LeepCode._191107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author DreamYee
 * @Create 2019/11/07  20:11
 */
/*给你个整数数组 arr，其中每个元素都不相同。
请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
*/
public class 绝对差 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list=new ArrayList<>();
        //排序
        Arrays.sort(arr);
        //求前两个数的绝对值
        int min=Math.abs(arr[1]-arr[0]);
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])==min){
                List<Integer> list1=new ArrayList<>();
                list1.add(arr[i-1]);
                list1.add(arr[i]);
                list.add(list1);
            }else if(Math.abs(arr[i]-arr[i-1])<min){
                list.clear();
                List<Integer> list1=new ArrayList<>();
                list1.add(arr[i-1]);
                list1.add(arr[i]);
                list.add(list1);
                min=arr[i]-arr[i-1];
            }
        }
        return list;
    }

    public static void main(String[] args) {
        绝对差 jj=new 绝对差();
        int[] arr={3,8,-10,23,19,-4,-14,27};
        System.out.println(jj.minimumAbsDifference(arr));
    }
}
