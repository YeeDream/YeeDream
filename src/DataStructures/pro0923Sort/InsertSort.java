package DataStructures.pro0923Sort;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/09/23  15:10
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={101,34,119,1,-1,89};
        insertSort(arr);
    }

    //插入排序
    public static void insertSort(int[] arr){

        //使用for循环，代码简化
        for(int i=1;i<arr.length;i++){
            //定义待插入的数
            int insertVal=arr[i];
            int insertIndex=i-1;//arr[1]的前面这个数的下标
            //给insetVal找到插入的一个位置
            //1.insertIndex>=0 保证在给insertVal找插入位置，不越界
            //2.insertVal<arr[insertIndex]说明待插入的数还没有找到插入位置
            //3.就需要将insertIndex后移
            while(insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，insertIndex+1
            arr[insertIndex+1]=insertVal;
            System.out.println("第"+i+"轮后：");
            System.out.println(Arrays.toString(arr));
        }


        //使用逐步推导，便于理解

        /*
        //第1轮  {101,34,119,1}=>{34,101，119,1}
        //{101,34,119,1}=>{101,101,119,1}
        //定义待插入的数
        int insertVal=arr[1];
        int insertIndex=1-1;//arr[1]的前面这个数的下标
        //给insetVal找到插入的一个位置
        //1.insertIndex>=0 保证在给insertVal找插入位置，不越界
        //2.insertVal<arr[insertIndex]说明待插入的数还没有找到插入位置
        //3.就需要将insertIndex后移
        while(insertIndex>=0 && insertVal<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex+1]=insertVal;
        System.out.println("第1轮后：");
        System.out.println(Arrays.toString(arr));


        //第2轮
        //定义待插入的数
        insertVal=arr[2];
        insertIndex=2-1;
        while(insertIndex>=0 && insertVal<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1]=insertVal;
        System.out.println("第2轮后：");
        System.out.println(Arrays.toString(arr));

        //第3轮
        //定义待插入的数
        insertVal=arr[3];
        insertIndex=3-1;
        while(insertIndex>=0 && insertVal<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1]=insertVal;
        System.out.println("第3轮后：");
        System.out.println(Arrays.toString(arr));
        */
    }
}
