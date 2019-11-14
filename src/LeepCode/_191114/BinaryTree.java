package LeepCode._191114;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author DreamYee
 * @Create 2019/11/14  20:27
 */
/*给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.*/
public class BinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> doubles=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            double ave=0;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                ave+=node.val;
            }
            ave=ave*1.0/size;
            doubles.add(ave);
        }
        return doubles;
    }

    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();


    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
