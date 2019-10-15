package DataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author DreamYee
 * @Create 2019/10/15  21:40
 */
public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numofEdges;//表示边的数目

    //定义给数组boolean[],记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        //测试
        int n=5;//节点的个数
        String Vertex[]={"A","B","C","D","E"};
        //创建图对象
        Graph graph=new Graph(n);
        //循环添加结点
        for(String vertex:Vertex){
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B,A-C,B-C,B-D,B-E
        graph.insertEdge(0,1,1);//A-B
        graph.insertEdge(0,2,1);//
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        //显示邻接矩阵
        graph.showGraph();

        //测试深度遍历是否可行
        System.out.println("深度优先遍历：");
        graph.dfs();
    }

    //构造器
    public Graph(int n){
        //初始化矩阵vertexList
        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        numofEdges=0;
        isVisited =new boolean[5];
    }

    //得到第一个邻接结点的下标

    /**
     *
     * @param index
     * @return  如果存在，就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index){
        for(int j=0;j<vertexList.size();j++){
            if(edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for(int j=v2+1;j<vertexList.size();j++){
            if(edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    //i 第一次是0
    private void dfs(boolean[] isVisited,int i){
        //首先我们访问该节点，输出
        System.out.print(getValueByIndex(i)+"->");
        //将该节点设置为已经访问过
        isVisited[i]=true;

        //查找节点i的第一个邻接结点w
        int w=getFirstNeighbor(i);
        while(w!=-1){//说明有
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w结点已经被访问过
            w=getNextNeighbor(i,w);
        }
    }

    //对dfs进行重载,遍历所有的节点，并进行dfs
    public void dfs(){
        //遍历所有的节点进行dfs
        for(int i=0;i<getNumofVertex();i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //图中常用的方法
    //返回节点的个数
    public int getNumofVertex(){
        return vertexList.size();
    }

    //显示图对应的矩阵
    public void showGraph(){
        for(int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //得到边的数目
    public int getNumofEdges(){
        return numofEdges;
    }

    //返回结点i（下标）对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1,v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }


    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边

    /**
     *
     * @param v1  点的下标及是第几个顶点 “A”-“B”  “A”-0  “B”-1
     * @param v2  第二个顶点对应的下标
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numofEdges++;
    }
}
