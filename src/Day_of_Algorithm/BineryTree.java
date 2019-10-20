package Day_of_Algorithm;

/**
 * @Author DreamYee
 * @Create 2019/10/20  9:33
 */

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/
public class BineryTree {
    public static void main(String[] args) {
        binaryTree binaryTree=new binaryTree();
        int[] arr={4,5,2,3,1};

        Node root=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        Node node4=new Node(5);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        binaryTree.setRoot(root);

       binaryTree.postOreder();

        for(int i=0;i<arr.length;i++){
            System.out.println("[no="+arr[i]+"]");
        }

    }
}

class binaryTree{
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    //后序遍历
    public void postOreder(){
        if(this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}

class Node{
    private int no;
    private Node left;
    private Node right;

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }


    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return  "[no="+no+"]" ;
    }

    //后序遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
}
