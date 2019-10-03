package DataStructures.pro1003tree;

/**
 * @Author DreamYee
 * @Create 2019/10/03  19:30
 */
public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序
        int[] arr={4,6,8,5,9};

    }

    //编写一个堆排序的方法
    public static void heapSort(int arr[]){
        System.out.println("堆排序！");
    }

    //将一个数组（二叉树），调整成一个大顶堆

    /**
     * 功能：完成将以i对应的非叶子节点的树调整成大顶堆
     * 举例：int[] arr={4,6,8,5,9}===》i=1==>adjustHeap==>{4，9，8,5,6}
     * adjustHeap==>i=0===>大顶堆{9,6,8,5,4}
     * @param arr  待调整的数组
     * @param i    表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整,逐渐减少
     */
    public static void adjustHeap(int arr[],int i,int length){
        int temp=arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //k指向的是i节点的左子节点
        for(int k=i*2+1;k<length;k=k*2+1){
            if(arr[k]<arr[k+1]){//说明左子节点的值小于右子节点的值
                k++;//k指向右子节点
            }
            if(arr[k]>temp){//如果子节点大于父节点
                arr[i]=arr[k];//把较大的值赋给当前节点
                i=k;//将i指向k，继续循环比较
            }else{
                break;
            }
        }
        //当for循环结束后，已经将i为父节点的树的最大值放在了最顶
        arr[i]=temp;//将temp值放在调整后的位置
    }
}
