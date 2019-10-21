package 平常练习.sort;

import java.util.Random;

/**
 * @Author DreamYee
 * @Create 2019/10/21  15:20
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array=new int[SIZE];
        int i;
        for(i=0;i<SIZE;i++){
            array[i]=(int)(100+Math.random()*100+1);//初始化数组
        }
        System.out.print("排序前的数组：\n");//输出排序前的数组
        for(i=0;i<SIZE;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        bubbleSort(array);
        System.out.print("输出排序后的数组：\n");
        for(i=0;i<SIZE;i++){
            System.out.print(array[i]+" ");//输出排序后的数组
        }
        System.out.println();
    }

    static final int SIZE=5;
    public static void bubbleSort(int[] a){//冒泡排序算法
        int temp;
        for(int i=1;i<a.length-1;i++){
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){//将相邻的两个数进行比较，较大的数往后冒泡
                    //交换相邻两个数
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
            System.out.print("第"+i+"步排序结果：");//输出每步排序的结果
            for(int k=0;k<a.length;k++){
                System.out.print(" "+a[k]);//输出
            }
            System.out.println();
        }
    }
}
