package algorithms.leecode;
/**
  @Author LynHB
 * @Description :
 *      Given a non-empty binary tree, find the maximum path sum.
 *      For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 8:26 2020/6/21
 **/
public class Order124BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    private int max = Integer.MIN_VALUE;

    private int recursionAlgorithm(TreeNode root){
        if(root==null){
            return 0;
        }
        int lv = 0,rv = 0;
        if(root.left != null){
            lv = Math.max(lv,recursionAlgorithm(root.left));
        }
        if(root.right != null){
            rv = Math.max(rv,recursionAlgorithm(root.right));
        }
        int val = lv + rv + root.val;

        max = Math.max(val,max);
        return val+Math.max(lv,rv);
    }

    public int maxPathSum(TreeNode root) {
        recursionAlgorithm(root);
        return max;
    }


}
