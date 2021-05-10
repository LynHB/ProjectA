package algorithms.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 *
 * @Date 12:18 2021/5/10
 * @Author Huang Bing
 */
class Order872LeafSimilarTrees {
    private Order872LeafSimilarTrees() {
    }

    public static class TreeNode {
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
    public static class Solution {

        private void dfs(TreeNode root, List<Integer> ret){
            if(root.left!=null){
                dfs(root.left,ret);
            }
            if(root.right!=null){
                dfs(root.right,ret);
            }
            if(root.left==null && root.right==null){
                ret.add(root.val);
            }
        }

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            if(root1==null && root2==null){
                return true;
            }
            if(root1==null || root2==null){
                return false;
            }
            List<Integer> ret1 = new ArrayList<>();
            List<Integer> ret2 = new ArrayList<>();
            dfs(root1,ret1);
            dfs(root2,ret2);
            return ret1.equals(ret2);
        }
    }
}
