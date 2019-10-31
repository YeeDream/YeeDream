package DataStructures.pro0924Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author DreamYee
 * @Create 2019/09/24  8:55
 */
public class ShellSort {
    public static void main(String[] args) {
        //int[] arr={8,9,1,7,2,3,5,4,6,0};
        //shellSort2(arr);


        //创建要给80000个数据的数组
        int[] arr=new int[80000];
        for(int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()*8000000);//生成一个[0,8000000)数
        }

        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1Str);

        shellSort2(arr);

        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2Str);


    }

    //交换法
    //希尔排序，逐步推导
    public static void shellSort(int[] arr){

        //根据前面的逐步分析，使用循环处理
        for(int gap=arr.length/2;gap>0;gap/=2){
            int temp=0;
            int count=0;
            for(int i=gap;i<arr.length;i++){
                //遍历各组中所有的元素（共有gap组，每组有2个元素）,步长gap
                for(int j=i-gap;j>=0;j-=gap){
                    //如果当前元素大于加上步长后的元素，说明交换
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
            System.out.println("希尔排序第"+(++count)+"轮后:"+Arrays.toString(arr));
        }

        /*
        int temp=0;
        //希尔排序的第1轮
        //是将个数据分为5组
        for(int i=5;i<arr.length;i++){
            //遍历各组中所有的元素（共有5组，每组有2个元素）,步长5
            for(int j=i-5;j>=0;j-=5){
                //如果当前元素大于加上步长后的元素，说明交换
                if(arr[j]>arr[j+5]){
                    temp=arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }
        System.out.println("希尔排序1轮后："+Arrays.toString(arr));

        //第2轮
        for(int i=2;i<arr.length;i++){
            //遍历各组中所有的元素（共有5组，每组有2个元素）,步长5
            for(int j=i-2;j>=0;j-=2){
                //如果当前元素大于加上步长后的元素，说明交换
                if(arr[j]>arr[j+2]){
                    temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
            }
        }
        System.out.println("希尔排序2轮后："+Arrays.toString(arr));

        //第3轮
        for(int i=1;i<arr.length;i++){
            //遍历各组中所有的元素（共有5组，每组有2个元素）,步长5
            for(int j=i-1;j>=0;j-=1){
                //如果当前元素大于加上步长后的元素，说明交换
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("希尔排序3轮后："+Arrays.toString(arr));
        */
    }

    //对交换式的希尔排序改成移位法
    public static void shellSort2(int[] arr){
        int count=0;
        //增量gap,并逐步的缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for(int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0 && temp<arr[j-gap]){
                        //移动
                        arr[j]=arr[j-gap];
                        j -= gap;
                    }
                    //当退出while循环时，就给gap找到了插入的位置
                    arr[j]=temp;
                }
            }
        }
        //System.out.println("希尔排序第"+(++count)+"轮后:"+Arrays.toString(arr));

    }

}
