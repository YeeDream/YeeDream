package DataStructures.pro0921Recursion;

/**
 * @Author DreamYee
 * @Create 2019/09/21  20:49
 */
public class Queue8 {
    //先定义一个max,表示共有多少个皇后
    int max=8;
    //定义数组array,保存皇后放置位置的结果
    int[] array=new int[max];
    static int count=0;
    public static void main(String[] args) {
        Queue8 queue8=new Queue8();
        queue8.check(0);
        System.out.println("一共有"+count+"种解法");

    }

    //编写一个方法，放置第n个皇后
    private void check(int n){
        if(n == max){//n=8   放置第九个皇后
            print();
            return;
        }
        //依次放入皇后并判断是否冲突
        for(int i=0;i<max;i++){
            //先把当前皇后n放入该行的第一列
            array[n]=i;
            //判断当放置第n个皇后到i列时，是否冲突
            if(judge(n)){//说明不冲突
                //接着放第n+1个皇后，开始递归
                check(n+1);
            }
            //如果冲突，就继续执行aray[n]=i,将第n个皇后放置在本行的后移的一个位置

        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    /**
     *
     * @param n  表示第n个皇后
     * @return
     */
    private boolean judge(int n){//n表示第n个皇后
        for(int i=0;i<n;i++){
            //说明
            //array[i]==array[n]：这句话表示判断第n个皇后是否和前面的n-1个皇后是否在同一列
            //Math.abs(n-i)==Math.abs(array[n]-array[i]：这句话表示判断第n个皇后是否和前面的n-1个皇后是否在同一斜线
            //为什么没有判断两个皇后在同一行：n每次都在递增
            if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    //写一个方法，将皇后摆放的位置输出
    private void print(){
        count++;
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
