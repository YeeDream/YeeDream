package Algorithm.dynamic;

/**
 * @Author DreamYee
 * @Create 2019/10/19  9:32
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w={1,4,3};//物品的重量
        int[] val={1500,3000,2000};//物品的价值
        int m=4;//背包的容量
        int n=val.length;//物品的个数

        //为了记录放入商品的情况，定一个二维数组
        int[][] path=new int[][];

        //创建二维数组
        //v[i][j]
        int[][] v=new int[n+1][m+1];

        //初始化第一行与第一列
        for(int i=0;i<v.length;i++){
            v[i][0]=0;//将第一列设置为0
        }
        for(int i=0;i<v[0].length;i++){
            v[0][i]=0;//将第一行设置为0
        }

        //动态规划处理
        for(int i=1;i<v.length;i++){//不处理第一行
            for(int j=1;j<v[0].length;j++){//不处理第一列
                //公式
                if(w[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else {
                   // v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    //为了记录商品存放到背包的情况，我们不能简单地使用上面的公式，使用if-else
                    if()
                }
            }
        }

        //输出v,看看目前的情况
        for(int i=0;i<v.length;i++){
            for(int j=0;j<v[i].length;j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
    }


}
