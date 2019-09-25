package Day_of_Algorithm;

/**
 * @Author DreamYee
 * @Create 2019/09/25  22:38
 */

//在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 //分析：一个二维数组中找目标数：
 //1.可以从数组的右上角开始，若该位置的数小于目标数，则下移；若该位置的数大于目标数，左移
 //2.也可以从数组的左下角开始遍历，若该位置的数小于目标数，右移；若该位置的数大于目标数，上移
public class TwoArray {
    public static void main(String[] args) {
        int target=9;
        int[][] array={{1,2,3,4},{2,3,4,5},{4,5,6,7},{7,8,9,10}};
        System.out.println(Find1(target,array));
    }

    //从左下角开始
    public static boolean Find1(int target, int [][] array) {
           int row=array.length;//行
           int col=array[0].length;//列
           int i=row-1;
           int j=0;
           while(i>=0 && j<col){
               if(array[i][j]<target){
                   j++;
                   continue;
               }else if(array[i][j]>target){
                   i--;
                   continue;
               }else{
                   return true;
               }
           }
           return false;
    }


    //从右下角开始
    public static boolean Find2(int target, int [][] array) {
        int rows = array.length;   //行
        int cols = array[0].length; //列
        int i = 0;
        int j = cols - 1;
        while( i < rows && j  >= 0)
        {
            if (array[i][j] > target)//从右上角开始
            {
                j--;       //列减一
                continue;
            } else if (array[i][j] < target)
            {
                i++;      //行加一
                continue;
            } else
                return true;
        }
        return false;
    }
}
