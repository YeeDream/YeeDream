package DataStructures.pro1007huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author DreamYee
 * @Create 2019/10/07  20:45
 */
public class HuffermanTree {
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        Node root=createHuffmanTree(arr);

        //测试
        preOrder(root);
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("该树是空树");
        }
    }

    //创建哈夫曼树的方法

    /**
     *
     * @param arr  需要创建的哈夫曼树
     * @return  创建好后的哈夫曼树的root节点
     */
    public static Node createHuffmanTree(int[] arr){
        //1.遍历arr数组

        //2.将arr的每个元素构建成一个node
        //3.将node放入到ArrayList中
        List<Node> nodes=new ArrayList<Node>();
        for(int value:arr){
            nodes.add(new Node(value));
        }

        //处理过程是循环过程
        while (nodes.size()>1){
            //排序  从小到大
            Collections.sort(nodes);
            System.out.println("nodes="+nodes);

            //输出根节点权值最小的两颗二叉树
            //(1)取出权值最小的节点（二叉树）
            Node leftNode=nodes.get(0);
            //(2)取出权值次小的节点（二叉树）
            Node rightNode=nodes.get(1);
            //(3)构成一颗新的二叉树
            Node parent=new Node(leftNode.value+rightNode.value);
            parent.left=leftNode;
            parent.right=rightNode;

            //(4)从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到node
            nodes.add(parent);
        }
        //返回huffmantree的root节点
        return nodes.get(0);
    }
}

//创建节点类
//为了让node对象支持排序Collections集合排序
//让node实现Comparable接口
class Node implements Comparable<Node>{
    int value;//节点权值
    Node left;//指向左子节点
    Node right;//指向右子节点

    //写一个前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    public Node(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        return this.value-o.value;
    }
}
