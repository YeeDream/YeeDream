package DataStructures.pro0922Sort;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/09/22  20:01
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={3,9,-1,10,-2};

        //容易理解，展示冒泡排序过程

        //冒泡排序：时间复杂度：O(n^2)

        int temp=0;//临时变量
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                //如果前面的数大于后面的就交换
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后的数组：");
            System.out.println(Arrays.toString(arr));
        }

        /*
        //2.第二趟：把第二大的数排在倒数第二位
        for(int j=0;j<arr.length-1-1;j++){
            //如果前面的数大于后面的就交换
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
        System.out.println("第二趟排序后的数组：");
        System.out.println(Arrays.toString(arr));

        //3.排第三大的数在倒数第三位
        for(int j=0;j<arr.length-1-2;j++){
            //如果前面的数大于后面的就交换
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
        System.out.println("第三趟排序后的数组：");
        System.out.println(Arrays.toString(arr));

        //4.
        for(int j=0;j<arr.length-1-3;j++){
            //如果前面的数大于后面的就交换
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
        System.out.println("第四趟排序后的数组：");
        System.out.println(Arrays.toString(arr));
        */
    }
}
