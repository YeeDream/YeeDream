package LeepCode._191125;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/11/25  15:38
 */
/*给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
注意：请不要在超过该数组长度的位置写入元素。
要求：请对输入的数组就地进行上述修改，不要从函数返回任何东西。
*/
public class Zeros {
    public void duplicateZeros(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                move(arr,i,arr.length);
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void move(int[] arr,int i,int len){
        //已经到末尾了，不能再移动了
        if(i>=len){
            return;
        }
        //从最后一位移动
        for(int j=len-1;j>i;j--){
            arr[j]=arr[j-1];
        }
    }

    public static void main(String[] args) {
        Zeros zz=new Zeros();
        int[] arr={1,2,0,3,0,4,5};
        zz.duplicateZeros(arr);
    }
}
