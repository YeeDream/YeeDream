package DataStructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
        int n=8;//节点的个数
        //String Vertex[]={"A","B","C","D","E"};
        String Vertex[]= {"1","2","3","4","5","6","7","8"};
        //创建图对象
       Graph graph=new Graph(n);
        //循环添加结点
        for(String vertex:Vertex){
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B,A-C,B-C,B-D,B-E
        /*
        graph.insertEdge(0,1,1);//A-B
        graph.insertEdge(0,2,1);//
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        */

        //更新边的关系
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.insertEdge(3,7,1);
        graph.insertEdge(4,7,1);
        graph.insertEdge(2,5,1);
        graph.insertEdge(2,6,1);
        graph.insertEdge(5,6,1);

        //显示邻接矩阵
        graph.showGraph();

        //测试深度遍历是否可行
        System.out.println("深度优先遍历：");
        graph.dfs();//1->2->4->8->5->3->6->7

        //测试广度遍历是否可行
        System.out.println("广度优先遍历：");
        graph.bfs();//1->2->3->4->5->6->7->8


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
        isVisited=new boolean[vertexList.size()];
        //遍历所有的节点进行dfs
        for(int i=0;i<getNumofVertex();i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //对一个节点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited,int i){
        int u;//表示队列头节点对应的下标
        int w;//邻接节点w
        //队列，记录节点访问的顺序
        LinkedList queue=new LinkedList<>();
        //访问节点，输出节点信息
        System.out.print(getValueByIndex(i)+"->");
        //标记为已访问
        isVisited[i]=true;
        //将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()){
            //取出队列的头节点下标
            u=(Integer)queue.removeFirst();
            //得到第一个邻接结点的下标w
            w=getFirstNeighbor(u);
            while (w!=-1){//找到
                //是否访问过
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"->");
                    //标记已经访问
                    isVisited[w]=true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻接点
                w=getNextNeighbor(u,w);//体现出广度优先
            }
        }
    }

    //遍历所有的节点，都进行广度优先搜索
    public void bfs(){
        isVisited=new boolean[vertexList.size()];
        for(int i=0;i<getNumofVertex();i++){
            if(!isVisited[i]){
                bfs(isVisited,i);
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
