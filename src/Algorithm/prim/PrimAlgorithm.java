package Algorithm.prim;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/10/21  16:13
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        //测试看图是否创建成功
        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int verxs=data.length;
        //邻接矩阵的关系使用二维数组表示，10000这个大数，表示两个点不连通
        int [][] weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        //创建一个MGraph对象
        MGraph graph=new MGraph(verxs);
        //创建一个mintree对象
        MinTree minTree=new MinTree();
        minTree.createGraph(graph,verxs,data,weight);
        //输出
        minTree.showGraph(graph);
    }
}

//创建最小生成树
class MinTree{
    //创建图的邻接矩阵

    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data  图的各个顶点的值
     * @param weight  图的邻接矩阵
     */
    public void createGraph(MGraph graph,int verxs,char[] data,int[][] weight){
        int i,j;
        for(i=0;i<verxs;i++){//遍历顶点
            graph.data[i]=data[i];
            for(j=0;j<verxs;j++){
                graph.weight[i][j]=weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph){
        for (int[] link:graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树

    /**
     *
     * @param graph   图
     * @param v  表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph,int v){
        //visited[]标记顶点是否被访问过
        int visited[] = new int[graph.verxs];
        //visited[]默认为0，没有访问过
        for
    }
}

class MGraph{
    int verxs;//表示图的节点个数
    char[] data;//存放节点数据
    int[][] weight;//存放边，就是邻接矩阵

    public MGraph(int verxs){
        this.verxs=verxs;
        data=new char[verxs];
        weight=new int[verxs][verxs];

    }
}
