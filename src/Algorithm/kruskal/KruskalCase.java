package Algorithm.kruskal;

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
            {0,12,INF,INF,16,14},
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
        //统计边
        for(int i=0;i<vlen;i++){
            for(int j=0;j<vlen;j++){
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
                System.out.printf("%10d\t",matrix[i][j]);
            }
            System.out.println();//换行
        }
    }
}

