package Algorithm.binarySearchNoRecursion;

/**
 * @Author DreamYee
 * @Create 2019/10/19  8:21
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr={1,3,8,10,11,67,100};
        int index=binarySearch(arr,100);
        System.out.println("index="+index);
    }

    //二分查找的非递归

    /**
     *
     * @param arr 待查找的数组,默认升序
     * @param target 需要找的数
     * @return  返回对应下标，否则返回-1
     */
    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){//说明继续查找
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;//需要向右查找
            }
        }
        return -1;
    }
}
