package DataStructures.pro0925Sort;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/09/25  17:15
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];//归并排序需要额外的空间
        mergeSort(arr,0,arr.length-1,temp);

        System.out.println("归并排序后："+ Arrays.toString(arr));
    }

    //分+合的方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;  //中间索引
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //向右递归进行分解
            mergeSort(arr,mid+1,right,temp);
            //每分解一次就合并一次
            merge(arr,left,right,mid,temp);

        }
    }

    //合并的方法

    /**
     *
     * @param arr  排序的数组
     * @param left 左边有序序列的开始索引
     * @param right 右边索引
     * @param mid   中间索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr,int left,int right,int mid,int[] temp){
        System.out.println("×××××");//合并的次数
        int i = left;//初始化i,左边有序序列的初始索引
        int j=mid+1;//初始化j,右边有序序列的初始索引
        int t=0;//指向temp数组的当前索引

        //1.先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列有一方处理完毕为止
        while(i<=mid && j<=right){//继续
            //如果左边的有序序列当前元素小于等于右边有序序列的当前元素
            //就将左边的元素填充到temp数组中
            //然后t后移，i后移
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }else{//反之右边的小于等于左边的，将右边的填充到temp中
                temp[t]=arr[j];
                t+=1;
                j+=1;
            }
        }

        //2.把有剩余数据的一边的数据依次全部填充到temp
        while(i<=mid){//说明左边的有序序列还有剩余的，就全部填充到temp
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while(j<=right){//说明右边的有序序列还有剩余的，就全部填充到temp
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }

        //3.将temp数组的元素copy到arr
        //注意并不是每次都拷贝所有
        t=0;
        int tempLeft=left;//
        //第一次合并时tempLeft=0，right=1  //tempLeft=2，right=3
        // tempLeft=0，right=3  //tempLeft=0，right=7
        System.out.println("tempLeft="+tempLeft+"\t"+"right="+right);
        while(tempLeft<=right){
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }

    }
}
