package DataStructures.pro0926Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DreamYee
 * @Create 2019/09/26  14:51
 */

//注意：二分查找的前提是该数组是有序的
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1000,1000,1234};
        //int resIndex=binarySearch(arr,0,arr.length-1,22);
        //System.out.println("resIndex="+resIndex);

        List resIndexList=binarySearch2(arr,0,arr.length-1,1000);
        System.out.println("resIndexList="+resIndexList);
    }

    //二分查找算法
    /**
     *
     * @param arr  数组
     * @param left 左边的索引
     * @param right  右边的索引,
     * @param findVal  要查找的值
     * @return  如果找到就返回下标，如果没有找到就返回-1
     */
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        //当left>right时，说明递归整个数组，但是没有找到
        if(left>right){
            return -1;
        }

        int mid=(left+right)/2;
        int midVal=arr[mid];

        if(findVal>midVal){//向右递归
             return binarySearch(arr,mid+1,right,findVal);
        }else if(findVal<midVal){//向左递归
            return binarySearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }

    //完成一个思考题
    /**
     * 当一个有序数组中有多个重复的值时，怎么将它们的下标都返回
     *
     * 思路分析：
     * 1.在找到mid索引值，不要马上返回
     * 2.向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到ArrayList
     * 3.向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到ArrayList
     * 4.将ArrayList返回
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        //当left>right时，说明递归整个数组，但是没有找到
        if(left>right){
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];

        if(findVal>midVal){//向右递归
            return binarySearch2(arr,mid+1,right,findVal);
        }else if(findVal<midVal){//向左递归
            return binarySearch2(arr,left,mid-1,findVal);
        }else{
            /*
            思路分析：
                    1.在找到mid索引值，不要马上返回
                    2.向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到ArrayList
                    3.向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到ArrayList
                    4.将ArrayList返回
           */
            List<Integer> resIndexList=new ArrayList<Integer>();
            //向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到ArrayList
            int temp=mid-1;
            while (true){
                if(temp<0 || arr[temp]!=findVal){//退出
                    break;
                }
                //否则，就将temp放入到resIndexList
                resIndexList.add(temp);
                temp-=1;
            }
            resIndexList.add(mid);

            //向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到ArrayList
            temp=mid+1;
            while(true){
                if(temp>arr.length-1 || arr[temp]!=findVal){//退出
                    break;
                }
                //否则，就将temp放入到resIndexList
                resIndexList.add(temp);
                temp+=1;
            }
            return resIndexList;
        }
    }

}
