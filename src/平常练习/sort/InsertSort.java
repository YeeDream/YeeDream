package 平常练习.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author DreamYee
 * @Create 2019/10/22  09:00
 */
public class InsertSort {
    static final int SIZE=5;

    public static void main(String[] args) {
        /*
        int[] array = new int[SIZE];

        for(int i=0;i<SIZE;i++){
            array[i]=(int)(100+Math.random()*100+1);//初始化数组
        }
        System.out.println("排序前的数组：");
        for(int i=0;i<array.length;i++){
            System.out.print(" "+array[i]);
        }
        System.out.println();

        insertSort(array);

        System.out.println("排序后的数组：");
        for(int i=0;i<array.length;i++){
            System.out.print(" "+array[i]);
        }
        System.out.println();
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

        insertSort(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间：" + date2Str);


    }

    public static void insertSort(int[] a){//插入排序
        for(int i=1;i<a.length;i++){//循环遍历数组
            //定义要插入的数
            int t=a[i];
            int j=i-1;//a[i]前面数的下标
            while (j>=0 && t<a[j]){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=t;

            /*
            System.out.print("第"+i+"步排序的结果：");
            for(int h=0;h<a.length;h++){
                System.out.print(" "+a[h]);
            }
            System.out.println();
            */
        }
    }
}
