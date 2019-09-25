package DataStructures.pro0925Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author DreamYee
 * @Create 2019/09/25  18:15
 */
public class RadixSort {
    public static void main(String[] args) {
        //int[] arr={53,3,542,748,14,214};

        //创建要给80000个数据的数组
        int[] arr=new int[800000];
        for(int i=0;i<800000;i++){
            arr[i]=(int)(Math.random()*8000000);//生成一个[0,8000000)数
        }

        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+date1Str);

        radixSort(arr);

        Date date2=new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+date2Str);

    }

    //基数排序方法
    public static void radixSort(int[] arr){

        //根据前面的推导，可以得到最终的基数排序代码

        //1.得到数组中最大的数的位数
        int max = arr[0];//假设第一个数为最大数
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength=(max+"").length();


        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //1.说明：二维数组包含10个一维数组
        //2.为了防止在放数的时候溢出，则每个一维数组大小为arr.length
        //3.明确：基数排序是使用空间换时间的经典算法
        int[][] bucket=new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //bucketElementCounts[0]记录的就是 bucket[0]的每次放入的数据的个数
        int[] bucketElementCounts=new int[10];

        //这里使用循环将代码处理
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            //针对每个元素的对应位数进行排序处理
            for(int j=0;j<arr.length;j++){
                //取出每个元素的个位的值
                int digitOfElement=arr[j]/n%10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照桶的顺序（一维数组的下标依次取出数据，放入原数组）
            int index=0;
            //遍历每一个桶，并将桶中数据放入原数组
            for(int k=0;k<bucketElementCounts.length;k++){
                //如果桶中有数据，我们才放入原数组
                if(bucketElementCounts[k]!=0){
                    //循环该桶即第k个桶（即第k个一维数组），放入
                    for(int l=0;l<bucketElementCounts[k];l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后需要将每个bucketElementCounts[k]=0  !!!!
                bucketElementCounts[k]=0;
            }

            //System.out.println("第"+(i+1)+"轮，对个位的排序处理："+ Arrays.toString(arr));
        }


        /*
        //第一轮排序：针对每个元素的个位进行排序处理
        for(int j=0;j<arr.length;j++){
            //取出每个元素的个位的值
            int digitOfElement=arr[j]%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照桶的顺序（一维数组的下标依次取出数据，放入原数组）
        int index=0;
        //遍历每一个桶，并将桶中数据放入原数组
        for(int k=0;k<bucketElementCounts.length;k++){
            //如果桶中有数据，我们才放入原数组
            if(bucketElementCounts[k]!=0){
                //循环该桶即第k个桶（即第k个一维数组），放入
                for(int l=0;l<bucketElementCounts[k];l++) {
                    //取出元素放入到arr
                    arr[index++] = bucket[k][l];
                }
            }
            //第一轮处理后需要将每个bucketElementCounts[k]=0  !!!!
            bucketElementCounts[k]=0;
        }

        System.out.println("第一轮，对个位的排序处理："+ Arrays.toString(arr));

        //=====================================================

        //第2轮排序：针对每个元素的十位进行排序处理
        for(int j=0;j<arr.length;j++){
            //取出每个元素的十位的值
            int digitOfElement=arr[j]/10%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照桶的顺序（一维数组的下标依次取出数据，放入原数组）
        index=0;
        //遍历每一个桶，并将桶中数据放入原数组
        for(int k=0;k<bucketElementCounts.length;k++){
            //如果桶中有数据，我们才放入原数组
            if(bucketElementCounts[k]!=0){
                //循环该桶即第k个桶（即第k个一维数组），放入
                for(int l=0;l<bucketElementCounts[k];l++) {
                    //取出元素放入到arr
                    arr[index++] = bucket[k][l];
                }
            }
        }

        System.out.println("第2轮，对十位的排序处理："+ Arrays.toString(arr));


        //=======================================
        //第3轮排序：针对每个元素的百位进行排序处理
        for(int j=0;j<arr.length;j++){
            //取出每个元素的百位的值
            int digitOfElement=arr[j]/100%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照桶的顺序（一维数组的下标依次取出数据，放入原数组）
        index=0;
        //遍历每一个桶，并将桶中数据放入原数组
        for(int k=0;k<bucketElementCounts.length;k++){
            //如果桶中有数据，我们才放入原数组
            if(bucketElementCounts[k]!=0){
                //循环该桶即第k个桶（即第k个一维数组），放入
                for(int l=0;l<bucketElementCounts[k];l++) {
                    //取出元素放入到arr
                    arr[index++] = bucket[k][l];
                }
            }
            bucketElementCounts[k]=0;
        }

        System.out.println("第3轮，对百位的排序处理："+ Arrays.toString(arr));
        */

    }
}
