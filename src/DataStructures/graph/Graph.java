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
    }

    //构造器
    public Graph(int n){
        //初始化矩阵vertexList
        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        numofEdges=0;
    }

    //图中常用的方法
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
