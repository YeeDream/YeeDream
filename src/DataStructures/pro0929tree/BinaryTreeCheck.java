package DataStructures.pro0929tree;

/**
 * @Author DreamYee
 * @Create 2019/09/29  18:06
 */
public class BinaryTreeCheck {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree2 binaryTree2 = new BinaryTree2();
        //创建需要的节点
        HeroNode2 root = new HeroNode2(1, "宋江");
        HeroNode2 node2 = new HeroNode2(2, "吴用");
        HeroNode2 node3 = new HeroNode2(3, "卢俊义");
        HeroNode2 node4 = new HeroNode2(4, "林冲");
        HeroNode2 node5 = new HeroNode2(5, "关胜");

        //说明，我们先手动创建二叉树，后面会学习以递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree2.setRoot(root);

        /*
        System.out.println("前序遍历：");//1 2 3 5 4
        binaryTree.preOrder();

        System.out.println("中序遍历：");//2 1 5 3 4
        binaryTree.infixOrder();

        System.out.println("后序遍历：");//2 5 4 3 1
        binaryTree.postOrder();
        */

        //前序遍历查找
        //前序遍历的次数:4
        System.out.println("前序遍历查找方式：");
        HeroNode2 resNode=binaryTree2.preOrderSearch(2);
        if(resNode!=null){
            System.out.printf("找到了，信息为no=%d, name=%s",resNode.getNo(),resNode.getName());
        }else{
            System.out.printf("没有找到no=%d的英雄！",2);
        }
        System.out.println();

        //中序遍历的次数:3
        System.out.println("中序遍历查找方式：");
        HeroNode2 resNode1=binaryTree2.infixOrderSearch(2);
        if(resNode1!=null){
            System.out.printf("找到了，信息为no=%d, name=%s",resNode.getNo(),resNode.getName());
        }else{
            System.out.printf("没有找到no=%d的英雄！",2);
        }
        System.out.println();

        //后序遍历的次数:2
        System.out.println("后序遍历查找方式：");
        HeroNode2 resNode2=binaryTree2.postOrderSearch(2);
        if(resNode2!=null){
            System.out.printf("找到了，信息为no=%d, name=%s",resNode.getNo(),resNode.getName());
        }else{
            System.out.printf("没有找到no=%d的英雄！",2);
        }

    }
}

//定义BinaryTree二叉树
class BinaryTree2{
    private HeroNode2 root;

    public void setRoot(HeroNode2 root) {
        this.root = root;
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

    //前序查找
    public HeroNode2 preOrderSearch(int no){
        if(root!=null){
           return this.root.preOrderSearch(no);
        }else{
            return null;
        }
    }

    public HeroNode2 infixOrderSearch(int no){
        if(root!=null){
            return this.root.infixOrderSearch(no);
        }else{
            return null;
        }
    }

    public HeroNode2 postOrderSearch(int no){
        if(root!=null){
            return this.root.postOrderSearch(no);
        }else{
            return null;
        }
    }
}

//创建HeroNode节点
class HeroNode2{
    private int no;
    private String name;
    private HeroNode2 left;
    private HeroNode2 right;

    public HeroNode2(int no, String name) {
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

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
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

    //前序遍历查找

    /**
     *
     * @param no  查找no
     * @return  如果找到就返回该node,没有找到就返回null
     */
    public HeroNode2 preOrderSearch(int no){
        System.out.println("进入前序遍历");
        //比较当前节点是不是要查找的
        if(this.no==no){
            return this;
        }
        //1.判断当前节点的左子节点是不是为空，若不为空，则递归前序查找
        //2.如果左递归前序找到，就返回
        HeroNode2 resNode=null;
        if(this.left!=null){
            resNode=this.left.preOrderSearch(no);
        }
        if(resNode!=null){//说明我们左子树找到
            return resNode;
        }
        //1.左递归前序查找，找到节点就返回，否则继续判断
        //2.当前的节点的右子节点是否为空，若不空，继续向右前序递归查找
        if(this.right!=null){
            resNode=this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序查找
    public HeroNode2 infixOrderSearch(int no){
        HeroNode2 resNode=null;
        if(this.left!=null){
            resNode=this.left.infixOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入中序遍历");
        if(this.no==no){
            return this;
        }
        if(this.right!=null){
            resNode=this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序查找
    public HeroNode2 postOrderSearch(int no){
        HeroNode2 resNode=null;
        if(this.left!=null){
            resNode=this.left.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=this.right.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入后序遍历");
        if(this.no==no){
            return this;
        }
        return resNode;
    }
}
