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
        int[][] path=new int[n+1][m+1];

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
                    if(v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        //把当前的记录记录到path
                        path[i][j]=1;
                    }else {
                        v[i][j]=v[i-1][j];
                    }
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
        System.out.println("==============");
        //输出最后放入的商品
        //遍历path
        /*
        for(int i=0;i<path.length;i++){
            for(int j=0;j<path[i].length;j++){
                if(path[i][j]==1){
                    System.out.printf("第%d个商品放入到背包\n",i);
                }
            }
        }
        */

        int i=path.length-1;
        int j=path[i].length-1;
        while (i>0){//从后往前
            if(path[i][j]==1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }


}
