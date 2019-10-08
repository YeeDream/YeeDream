package DataStructures.pro1008HuffermanCode;

import java.util.*;

/**
 * @Author DreamYee
 * @Create 2019/10/08  21:24
 */
public class HuffermanCode {
    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] contentBytes= content.getBytes();
        System.out.println(contentBytes.length);//40

        List<Node> nodes=getNodes(contentBytes);
        System.out.println("nodes="+nodes);

        //创建的二叉树
        System.out.println("哈夫曼树");
        Node huffermanTreeRoot=createHuffermanTree(nodes);
        System.out.println("前序遍历");
        huffermanTreeRoot.preOrder();
    }

    //前序遍历
    private static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else {
            System.out.println("哈夫曼树为空！");
        }
    }

    /**
     *
     * @param bytes  接收字节数组
     * @return  返回的就是List形式
     */
    private static List<Node> getNodes(byte[] bytes){
        //1.创建ArrayList
        ArrayList<Node> nodes=new ArrayList<Node>();

        //存储，统计每一个byte出现的次数->map[key,value]
        Map<Byte,Integer> counts=new HashMap<>();
        for(byte b: bytes){
            Integer count=counts.get(b);
            if(count==null){//map还没有这个字符数据
                counts.put(b,1);
            }else{
                counts.put(b,count+1);
            }
        }
        //把每个键值对转成一个node对象，并加入到node集合
        for(Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    //通过list创建哈夫曼树
    private static Node createHuffermanTree(List<Node> nodes){
        while (nodes.size()>1){
            //排序：从小到大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node leftNode=nodes.get(0);
            //取出第二颗二叉树
            Node rightNode=nodes.get(1);
            //创建一颗新的二叉树，根节点没有data,只有权值
            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left=leftNode;
            parent.right=rightNode;

            //将已经处理过的二叉树移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树加入到nodes
            nodes.add(parent);
        }
        // nodes 最后的节点，就是哈夫曼树的根节点
        return nodes.get(0);
    }
}
//创建Node,放数据和权值
class Node implements Comparable<Node>{
    Byte data;//存放数据本身 a==>97  ' '==>32
    int weight;//权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}
