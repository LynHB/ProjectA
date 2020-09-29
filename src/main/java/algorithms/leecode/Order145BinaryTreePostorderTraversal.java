package algorithms.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 给定一个二叉树，返回它的 后序 遍历。
 * @date: 17:17 2020/9/29
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order145BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        if(root==null){
            return postOrder;
        }
        if(root.left!=null){
            postOrder.addAll(postorderTraversal(root.left));
        }
        if(root.right!=null){
            postOrder.addAll(postorderTraversal(root.right));
        }
        postOrder.add(root.val);
        return postOrder;
    }
}
