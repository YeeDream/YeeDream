package 平常练习.sort.practice;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/10/23  22:15
 */
public class DemoA {
    public static void main(String[] args) {
        int[] arr={40,8,15,18,12};

        System.out.println("排序前的结果：");
        System.out.println(Arrays.toString(arr));
        //BubbleSort(arr);
        //SelectSort(arr);
        InsertSort(arr);
    }

    //冒泡排序,从小到大排序
    public static void BubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.println("第"+(i+1)+"步排序结果："+Arrays.toString(arr));
        }

    }

    //选择排序
    public static void SelectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            int min=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
            System.out.println("第"+(i+1)+"步排序结果："+Arrays.toString(arr));
        }
    }

    //插入排序
    public static void InsertSort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int a=arr[i];
            int j=i-1;
            while(j>=0 && a<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }

            if(a+1!=i){
                arr[j+1]=a;
            }
            System.out.println("第"+(i+1)+"步排序结果："+Arrays.toString(arr));
        }
    }

}
