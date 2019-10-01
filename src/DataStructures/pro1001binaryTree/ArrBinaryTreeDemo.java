package DataStructures.pro1001binaryTree;

/**
 * @Author DreamYee
 * @Create 2019/10/01  19:34
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        //创建一个ArrayBinaryTree
        ArrBinaryTree arrBinaryTree=new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);//1,2,4,5,3,6,7
        arrBinaryTree.infixOrder(6);//4,2,5,1,6,3,7
        arrBinaryTree.postOrder(3);//4,5,2,6,7,3,1
    }
}

//编写一个ArrayBinaryTree类，实现顺序存储二叉树遍历
class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /*
    //重载preOrder
    public void preOrder(){
        this.preOrder(0);
    }
    */

    //编写一个方法，完成顺序存储二叉树的前序遍历

    /**
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        //如果数组为空，或者arr.length=0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
            //输出当前这个元素
            System.out.print(arr[index]+"\t");
            //向右递归遍历
            if ((index * 2 + 2) < arr.length) {
                preOrder(2 * index + 2);
            }
        }
    }

    //编写一个方法，完成顺序存储二叉树的中序遍历

    /**
     * @param index 数组的下标
     */
    public void infixOrder(int index) {
        //如果数组为空，或者arr.length=0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的中序遍历");
        }
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //输出当前这个元素
        System.out.print(arr[index]+"\t");
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }


    //编写一个方法，完成顺序存储二叉树的后序遍历

    /**
     * @param index   数组的下标
     */
    public void postOrder(int index){
        //如果数组为空，或者arr.length=0
        if(arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树的后序遍历");
        }

        //向左递归遍历
        if((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
        //向右递归遍历
        if((index*2+2)<arr.length){
            preOrder(2*index+2);
        }
        //输出当前这个元素
        System.out.print(arr[index]+"\t");
    }
}
