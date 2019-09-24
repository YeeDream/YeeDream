package DataStructures.pro0924Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author DreamYee
 * @Create 2019/09/24  14:18
 */
public class QuickSort {
    public static void main(String[] args) {
        //int[] arr={-9,78,0,23,-567,70,900,4561};

        //创建要给800000个数据的数组
        int[] arr=new int[800000];
        for(int i=0;i<800000;i++){
            arr[i]=(int)(Math.random()*8000000);//生成一个[0,8000000)数
        }

        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1Str);

        quickSort(arr,0,arr.length-1);

        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2Str);



        //System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int l=left;//左下标
        int r=right;//右下标
        //pivot 中轴值
        int pivot=arr[(left+right)/2];
        int temp=0;//临时变量，交换时使用
        //while循环的目的是让比pivot小的值放到左边
        //比pivot大的放在右边
        while (l<r){
            //在pivot左边一直找，直到找到大于等于pivot的值，才退出
            while (arr[l]<pivot){
                l+=1;
            }//在pivot右边一直找，直到找到小于等于pivot的值，才退出
            while (arr[r]>pivot){
                r-=1;
            }
            //如果l>=r成立，说明pivot的左右的值，已经按照左边小于等于pivot的值，而右边全部是大于等于pivot的值
            if(l>=r){
               break;
            }
            //交换
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            //如果交换完后，发现arr[l]==pivot值相等 r--，前移
            if(arr[l]==pivot){
                r-=1;
            }
            //如果交换完后，发现arr[r]==pivot值相等 l++，后移
            if(arr[r]==pivot){
                l+=1;
            }
        }

        //如果l==r,必须l++,r--.否则表现为栈溢出
        if(l==r){
            l+=1;
            r-=1;
        }
        //向左递归
        if(left<r){
            quickSort(arr,left,r);
        }

        //向右递归
        if(right>l){
            quickSort(arr,l,right);
        }
    }
}
