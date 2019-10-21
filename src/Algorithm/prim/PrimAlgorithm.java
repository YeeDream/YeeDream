package Algorithm.prim;

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

        //
        minTree.prim(graph,0);
    }
}

//创建最小生成树
class MinTree {
    //创建图的邻接矩阵

    /**
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {//遍历顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树

    /**
     * @param graph 图
     * @param v     表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph, int v) {
        //visited[]标记顶点是否被访问过
        int visited[] = new int[graph.verxs];
        //visited[]默认为0，没有访问过
        /*
        for(int i=0;i<graph.verxs;i++){
            visited[i]=0;
        }
        */

        //把当前节点标记为已访问
        visited[v] = 1;
        //h1与h2记录两个定点的下标
        int h1 = -1;
        int h2 = -1;
        int minweight = 10000;//将minweight初始化为一个大值，后在遍历过程中会替换
        for (int k = 0; k < graph.verxs; k++) {
            {//因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边
                //这个是确定每一次生成的子图 ，和哪个结点的距离最近
                for (int i = 0; i < graph.verxs; i++) {// i结点表示被访问过的结点
                    for (int j = 0; j < graph.verxs; j++) {//j结点表示还没有访问过的结点
                        if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minweight) {
                            //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                            minweight = graph.weight[i][j];
                            h1 = i;
                            h2 = j;
                        }
                    }
                }
            }
            //找到一条边最小
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">权值："+minweight);
            //将当前这个结点标记为已经访问
            visited[h2]=1;
            //minWeight 重新设置为最大值 10000
            minweight=10000;
        }
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
