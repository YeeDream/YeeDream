package DataStructures.pro0927Search;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/09/27  19:44
 */
public class FibonacciSearch {

    public static int maxSize=20;
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1234};

        System.out.println("index="+fibSearch(arr,1));
    }

    //因为后面我们mid=low+F(k-1)-1,需要用到斐波那切数列，我们就需要先获取到一个斐波那切数列
    //非递归方法得到一个斐波那切数列
    public static int[] fib(){
        int[] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for(int i=2;i<maxSize;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    //编写斐波那切数列查找算法
    //使用非递归的方式编写算法
    /**
     *
     * @param a  数组
     * @param key 我们需要查找的关键码（值）
     * @return  返回对应的下标，如果没有返回-1
     */
    public static int fibSearch(int[] a,int key){
        int low=0;
        int high=a.length-1;
        int k=0;//表示斐波那切分割数值的下标
        int mid=0;//存放mid的值
        int f[]=fib();//获取斐波那切数列
        //获取到斐波那切分割数值的下标
        while (high>(f[k]-1)){
            k++;
        }
        //因为f[k]的值可能大于a的长度，因此需要使用Arrsys类，构造一个新的数组，并指向a[]
        //不足的部分会使用0填充
        int[] temp= Arrays.copyOf(a,f[k]);
        //实际上需要使用a数组最后的数填充temp
        //temp={1,8,10,89,1000,1234,0,0,0}==>{1,8,10,89,1000,1234,1234,1234,1234}
        for(int i=high+1;i<temp.length;i++){
            temp[i]=a[high];
        }
        //使用while来循环处理，找到我们的数key
        while(low<=high) {//只要这个条件满足，就可以找
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {//说明应该继续向数组的前部分查找（左边）
                high = mid - 1;
                //为什么是k--?
                //1.全部元素=前面的元素+后面的元素
                //2.f[k]=f[k-1]+f[k-2]
                //因为前面有f[k-1]个元素，所以我们可以继续拆分f[k-1]=f[k-2]+f[k-3]
                //即在f[k-1]的前面继续查找k--
                //即下次循环mid=f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) {//说明应该继续向数组的后面查找（右边）
                low = mid + 1;
                //为什么是k-=2
                //1.全部元素=前面的元素+后边元素
                //2.f[k]=f[k-1]+f[k-2]
                //3.因为后面我们有f[k-2]个元素，所以继续拆分f[k-1]=f[k-3]+f[k-4]
                //4.即在f[k-2]的前面继续查找
                //5.即下次循环mid=f[k-1-2]-1
                k -= 2;
            } else {//找到
                //需要确定返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
