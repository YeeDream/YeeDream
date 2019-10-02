package DataStructures.pro1002tree;

/**
 * @Author DreamYee
 * @Create 2019/10/02  17:45
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试中序线索化二叉树
        HeroNode root=new HeroNode(1,"tom");
        HeroNode node2=new HeroNode(3,"jack");
        HeroNode node3=new HeroNode(6,"smith");
        HeroNode node4=new HeroNode(8,"mary");
        HeroNode node5=new HeroNode(10,"king");
        HeroNode node6=new HeroNode(14,"jim");

        //二叉树，递归创建，使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);


        //中序线索化
        ThreadedBinaryTree threadedBinaryTree=new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNode();

        //10节点测试
        HeroNode leftNode=node5.getLeft();
        System.out.println("10号节点的前驱节点：");
        System.out.println(leftNode);

        HeroNode rightNode=node5.getRight();
        System.out.println("10号节点的后继节点：");
        System.out.println(rightNode);

        System.out.println("使用线索化的方式遍历线索化二叉树:");
        threadedBinaryTree.threadedList();
    }
}

//定义ThreadedBinaryTree实现了线索化功能的二叉树
class ThreadedBinaryTree {
    private HeroNode root;

    //为了实现线索化，需要创建要给指向当前节点的前驱节点的操作
    //在递归进行线索化时，pre总是保留前一个节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载
    public void threadedNode() {
        this.threadedNode(root);
    }

    //遍历线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;
        while (node!=null){
            //后面随着遍历而变化，因为当leftType==1时，说明该节点是按照线索化处理后的有效节点
            // 处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前这个节点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                //获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node = node.getRight();
        }

    }


    //编写对二叉树进行中序线索化的方法

    /**
     *
     * @param node  就是当前需要线索化的节点
     */
    public void threadedNode(HeroNode node){
        //如果node==null,不能线索化
        if(node==null){
            return;
        }
        //1.先线索化左子树
        threadedNode(node.getLeft());
        //2.线索化当前节点(有难度)

        //处理当前节点的前驱节点
        //以8节点理解
        //8节点的.left=null,leftType=1
        if(node.getLeft()==null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针的类型
            node.setLeftType(1);
        }
        //处理后继节点
        if(pre!=null && pre.getRight()==null){
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre=node;

        //3.线索化右子树
        threadedNode(node.getRight());
    }
}

//创建HeroNode节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //说明：
    //1.如果leftType==0表示指向的是左子树，如果1则表示指向的是前驱节点
    //2.如果rightType==0表示指向的是右子树，如果1就是后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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
}
