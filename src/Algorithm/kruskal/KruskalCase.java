package Algorithm.kruskal;

import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/10/22  15:07
 */
public class KruskalCase {

    private int edgeNum;//边的个数
    private char[] vertexs;//顶点数组
    private int[][] matrix;//邻接矩阵
    //使用inf表示两个顶点不能连通
    private static final int INF=Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G'};
        int[][] matrix={
            {0,12,INF,INF,INF,16,14},
            {12,0,10,INF,INF,7,INF},
            {INF,10,0,3,5,6,INF},
            {INF,INF,3,0,4,INF,INF},
            {INF,INF,5,4,0,2,8},
            {16,7,6,INF,2,0,9},
            {14,INF,INF,INF,8,9,0}
        };
        //创建Kruskal
        KruskalCase kruskalCase=new KruskalCase(vertexs,matrix);
        //输出构建的
        kruskalCase.print();
        EData[] edges=kruskalCase.getEdges();
        System.out.println(Arrays.toString(edges));//没有排序
        System.out.println();
        kruskalCase.sortEdges(edges);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(edges));
    }

    //构造器
    public KruskalCase(char[] vertexs,int[][] matrix){
        //初始化顶点数和边的个数
        int vlen=vertexs.length;

        //初始化顶点,复制拷贝
        this.vertexs=new char[vlen];
        for(int i=0;i<vertexs.length;i++){
            this.vertexs[i]=vertexs[i];
        }

        //初始化边,使用复制拷贝
        this.matrix=new int[vlen][vlen];
        for(int i=0;i<vlen;i++){
            for(int j=0;j<vlen;j++){
                this.matrix[i][j]=matrix[i][j];
            }
        }
        //统计边的条数
        for(int i=0;i<vlen;i++){
            for(int j=i+1;j<vlen;j++){
                if(this.matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }
    //测试，打印邻接矩阵
    public void print(){
        System.out.println("邻接矩阵为：\n");
        for(int i=0;i<vertexs.length;i++){
            for(int j=0;j<vertexs.length;j++){
                System.out.printf("%12d\t",matrix[i][j]);
            }
            System.out.println();//换行
        }
    }

    //对边进行排序处理
    //冒泡

    /**
     * 功能：对边进行排序
     * @param edges  边的集合
     */
    public void sortEdges(EData[] edges){
        for(int i=0;i<edges.length-1;i++){
            for (int j=0;j<edges.length-1;j++){
                if(edges[j].weight>edges[j+1].weight){
                    EData tmp=edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=tmp;
                }
            }
        }
    }

    /**
     *
     * @param ch  顶点的值，比如：'A','B'
     * @return  返回ch顶点对应的下标，如果找不到，返回-1
     */
    private int getPosition(char ch){
        for(int i=0;i<vertexs.length;i++){
            if(vertexs[i]==ch){
                return i;
            }
        }
        //找不到，返回-1
        return -1;
    }

    /**
     * 功能：获取图中的边，放到EData[]中，后面我们需要遍历该数组
     * 是通过matrix邻接矩阵来获取
     * EData[]形式[['A','B',12],['B','F',7]……]
     * @return
     */
    private EData[] getEdges(){
        int index=0;
        EData[] edges=new EData[edgeNum];
        for(int i=0;i<vertexs.length;i++){
            for(int j=i+1;j<vertexs.length;j++){
                if(matrix[i][j]!=INF){
                    edges[index++]=new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 功能：获取下标为i的顶点的终点，用于后面判断两个顶点的终点是数组在遍历过程中，逐步形成否相同
     * @param ends  数组记录了各个顶点对应的终点是哪个，ends
     * @param i  传入的顶点对应的下标
     * @return   返回的就是下标为i的这个顶点对应的终点的下标
     */
    private int getEnd(int[] ends,int i){
        while(ends[i]!=0){
            i=ends[i];
        }
        return i;
    }

}

//创建一个类Data,它的对象实例就表示一条边
class EData{
    char start;//边的一个点
    char end;//边的另外一个点
    int weight;//边的权值
    public EData(char start,char end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    //重写toString，便于输出边的信息
    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

