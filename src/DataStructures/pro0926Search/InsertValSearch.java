package DataStructures.pro0926Search;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/09/26  15:39
 */
public class InsertValSearch {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for(int i=0;i<100;i++){
            arr[i]=i+1;
        }

        int resIndex=insertValSearch(arr,0,arr.length-1,55);
        System.out.println("resIndex="+resIndex);
    }

    //编写插值查找算法
    //说明插值查找算法要求数组是有序的
    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 查找的值
     * @return 如果找到就返回对应的下标，如果没有找到就返回-1
     */
    public static int insertValSearch(int[] arr,int left,int right,int findVal){
        System.out.println("hello");

        //注意：findVal<arr[0]和 findVal>arr[arr.length-1]必须要
        if(left>right || findVal<arr[0] || findVal>arr[arr.length-1]){
            return -1;
        }
        //求出mid
        int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];
        if(findVal>midVal){//说明向右递归查找
            return insertValSearch(arr,mid+1,right,findVal);
        }else if(findVal<midVal){//说明向左递归查找
            return insertValSearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }
}
