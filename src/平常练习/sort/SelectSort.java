package 平常练习.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author DreamYee
 * @Create 2019/10/21  19:34
 */
public class SelectSort {
    public static void main(String[] args) {
        /*
        int[] array=new int[SIZE];
        int i;
        for(i=0;i<SIZE;i++){
            array[i]=(int)(100+Math.random()*100+1);//初始化数组
        }
        System.out.print("排序前的数组：\n");
        //输出排序前的数组
        for(i=0;i<SIZE;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        selectSort(array);
        System.out.print("排序后的数组：\n");
        //输出排序后的数组
        for(i=0;i<SIZE;i++){
            System.out.print(array[i]+" ");
        }
        */

        //测试效率
        int[] array=new int[80000];
        for(int i=0;i<80000;i++){
            array[i]=(int)(Math.random()*8000000);//生成一个[0,8000000)数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间：" + date1Str);

        selectSort(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间：" + date2Str);
    }

    static final int SIZE=5;
    public static void selectSort(int[] a){//选择排序法
        int index,temp;//交换临时变量
        for(int i=0;i<a.length;i++){
            index=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[index]){
                    index=j;
                }
            }
            //交换两个数
            if(index!=i){
                temp=a[i];
                a[i]=a[index];
                a[index]=temp;
            }
            /*
            System.out.print("第"+i+"步排序结果：");//输出每步排序的结果
            for(int h=0;h<a.length;h++){
                System.out.print(" "+a[h]); //输出
            }
            System.out.println();
            */
        }
    }
}
