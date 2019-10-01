package DataStructures.pro1001binaryTree;

/**
 * @Author DreamYee
 * @Create 2019/09/29  11:53
 */
public class BinaryTree {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        binaryTreeDemo binaryTree=new binaryTreeDemo();
        //创建需要的节点
        HeroNode root=new HeroNode(1,"宋江");
        HeroNode node2=new HeroNode(2,"吴用");
        HeroNode node3=new HeroNode(3,"卢俊义");
        HeroNode node4=new HeroNode(4,"林冲");
        HeroNode node5=new HeroNode(5,"关胜");


        //说明，我们先手动创建二叉树，后面会学习以递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        /*
        System.out.println("前序遍历：");//1 2 3 5 4
        binaryTree.preOrder();

        System.out.println("中序遍历：");//2 1 5 3 4
        binaryTree.infixOrder();

        System.out.println("后序遍历：");//2 5 4 3 1
        binaryTree.postOrder();
        */

        System.out.println("删除前,前序遍历：");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("删除后，前序遍历：");
        binaryTree.preOrder();
    }
}

//定义BinaryTree二叉树
class binaryTreeDemo{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int no){
        if(root!=null){
            //如果只有一个root节点，应该立即判断root是不是就是要删除的节点
            if (root.getNo() == no) {
                root=null;
            }else{
                //递归删除
                root.delNode(no);
            }
        }else{
            System.out.println("空树，不能删除");
        }
    }

    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历");
        }
    }


}

//创建HeroNode节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归删除节点
    //1.叶子结点，删除该节点
    //2.非叶子节点，删除该子树
    public void delNode(int no){
        //思路：
        /*
        1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
			2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
			3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
			4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
			5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.
         */

        if(this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        //向左子树递归删除
        if(this.left!=null){
            this.left.delNode(no);
        }
        //5.向右子树递归删除
        if(this.right!=null){
            this.right.delNode(no);
        }
    }

    //编写前序遍历
    public void preOrder(){
        System.out.println(this);//先输出父节点
        //递归向左子树前序遍历
        if(this.left!=null){
            this.left.preOrder();
        }
        //递归此向右子树前序遍历
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        //递归向左子树中序遍历
        if(this.left!=null){
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树中序遍历
        if(this.right!=null){
            this.right.infixOrder();
        }
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