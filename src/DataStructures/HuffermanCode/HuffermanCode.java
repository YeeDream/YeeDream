package DataStructures.HuffermanCode;

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

        //测试是否生成对应的赫夫曼编码
        getCodes(huffermanTreeRoot);
        System.out.println("生成的赫夫曼编码表："+huffermanCodes);
    }

    //生成赫夫曼树对应的哈夫曼编码
    //思路：
    //1.将赫夫曼编码表存放在Map<Byte,String>形式
    //32->01  97->100  100->11000等等
    static Map<Byte,String> huffermanCodes=new HashMap<Byte,String>();
    //2.在生成赫夫曼编码表示，需要去拼接路径，定义一个StringBuilder存储某个叶子节点的路径
    static StringBuilder stringBuilder=new StringBuilder();

    //重载getCodes
    private static Map<Byte,String> getCodes(Node root){
        if(root==null){
            return null;
        }
        //处理root左子树
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right,"1",stringBuilder);
        return huffermanCodes;
    }

    /*
    //编写一个方法，将字符串对应的byte[]数组，通过生成的赫夫曼编码，返回一个赫夫曼编码压缩后的byte[]

    /**
     *
     * @param bytes  原始的字符串对应的byte[]
     * @param huffermanCodes   生成的赫夫曼编码
     * @return  返回赫夫曼编码处理后的byte[]
     * huffermanCodeBytes[0] = 10101000(补码) ==> byte[推导10101000 =>10101000(反码)-1 =>10100111]

    private static byte[] zip(byte[] bytes,Map<Byte,String> huffermanCodes){

    }
    */

    //生成赫夫曼对应的赫夫曼编码
    /**
     * 功能：将传入的node节点的所有叶子结点的赫夫曼编码得到，并放入到huffermanCodes集合
     * @param node  传入节点
     * @param code  路径，左子节点是0，右子节点是1
     * @param stringBuilder  用于拼接路径
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2=new StringBuilder(stringBuilder);
        //将code加入到stringBuilder2
        stringBuilder2.append(code);
        if(node!=null){//如果node==null不处理
            //判断当前node是叶子节点还是非叶子节点
            if(node.data==null){//非叶子节点
                //递归
                //向左递归
                getCodes(node.left,"0",stringBuilder2);
                //向右递归
                getCodes(node.right,"1",stringBuilder2);
            }else{//说明是一个叶子节点
                //表示找到某个叶子节点的最后
                huffermanCodes.put(node.data,stringBuilder2.toString());
            }
        }
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
