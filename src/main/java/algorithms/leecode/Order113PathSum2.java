package algorithms.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

    说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Order113PathSum2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void hasPathSum(TreeNode root, int sum, List<List<Integer>> r, List<Integer> l) {
        if(root==null){
            return;
        }
        l.add(root.val);
        if(root.left ==null && root.right==null && root.val==sum ){
            ArrayList<Integer> mycopy=new ArrayList<Integer>(Arrays.asList(new Integer[l.size()]));
            Collections.copy(mycopy, l);
            r.add(mycopy);
        }
        if(root.left!=null){
            hasPathSum(root.left,sum-root.val,r,l);
            l.remove(l.size()-1);
        }
        if(root.right!=null){
            hasPathSum(root.right,sum-root.val,r,l);
            l.remove(l.size()-1);
        }

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> r = new ArrayList<>();

        hasPathSum(root,sum,r,new ArrayList<>());
        return r;
    }
}
