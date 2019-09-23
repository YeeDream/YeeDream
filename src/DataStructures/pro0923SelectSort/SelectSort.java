package DataStructures.pro0923SelectSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author DreamYee
 * @Create 2019/09/23  14:28
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] arr={101,34,119,1};

        //创建要给80000个数据的数组
        int[] arr=new int[80000];
        for(int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()*8000000);//生成一个[0,8000000)数
        }

        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1Str);

        selectSort(arr);

        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2Str);

        /*
        System.out.println("排序前："Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后："+Arrays.toString(arr));
        */
    }

    //选择排序
    public static void selectSort(int[] arr){

        //在推导过程中，发现了规律，因此，用for循环解决
        //选择排序时间复杂度：O(n^2)
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            int min=arr[i];
            for(int j=i+1;j<arr.length;j++){
                //从小到大排序
                if(min>arr[j]){//说明arr[0]不是最小
                    min=arr[j];//重置min
                    minIndex=j;//重置minIndex
                }
            }
            //将最小值放在arr[0],即交换
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
            //System.out.println("第"+i+"轮后的顺序为："+ Arrays.toString(arr));
        }



        /*
        //使用逐步推导的方式，讲解选择排序
        //第1轮
        //原始数组：101,34,119,1
        //第1轮排序：1,34,119,101
        //算法：先简单-->复杂   就是可以把一个复杂的算法，拆分成简单的问题-》逐步解决

        //第一轮
        int minIndex=0;
        int min=arr[0];
        for(int j=0+1;j<arr.length;j++){
            if(min>arr[j]){//说明arr[0]不是最小
                min=arr[j];//重置min
                minIndex=j;//重置minIndex
            }
        }
        //将最小值放在arr[0],即交换
        if(minIndex!=0){
            arr[minIndex]=arr[0];
            arr[0]=min;
        }
        System.out.println("第一轮后的顺序为："+ Arrays.toString(arr));

        //第2轮
        minIndex=1;
        min=arr[1];
        for(int j=1+1;j<arr.length;j++){
            if(min>arr[j]){//说明arr[0]不是最小
                min=arr[j];//重置min
                minIndex=j;//重置minIndex
            }
        }
        //将最小值放在arr[1],即交换
        if(minIndex!=1){
            arr[minIndex]=arr[1];
            arr[1]=min;
        }
        System.out.println("第2轮后的顺序为："+ Arrays.toString(arr));

        //第3轮
        minIndex=2;
        min=arr[2];
        for(int j=2+1;j<arr.length;j++){
            if(min>arr[j]){//说明arr[0]不是最小
                min=arr[j];//重置min
                minIndex=j;//重置minIndex
            }
        }
        //将最小值放在arr[2],即交换
        if(minIndex!=2){
            arr[minIndex]=arr[2];
            arr[2]=min;
        }
        System.out.println("第3轮后的顺序为："+ Arrays.toString(arr));
        */
    }
}
