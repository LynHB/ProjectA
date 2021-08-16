package algorithms.leecode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 *  给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * @Date 10:11 2021/4/13
 * @Author Huang Bing
 */
public class Order783MinimumDistanceBetweenBstNodes {
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
    static class Solution {
        private List<Integer> treeNodes = new ArrayList<>();

        public int minDiffInBST(TreeNode root) {
            /*
             * 遍历数据存放list
             * 排序
             * 查找最小间隔
             */
            treeNodes.clear();
            recursion(root);
            if(treeNodes.size()<=1){
                return 0;
            }
            Integer[] list = treeNodes.toArray(new Integer[0]);
            Arrays.sort(list);
            int ret = Integer.MAX_VALUE;
            for(int i=1;i<list.length;i++){
                ret = Integer.min(ret,list[i]-list[i-1]);
            }
            return ret;
        }

        private void recursion(TreeNode root){
            if(root == null){
                return;
            }
            treeNodes.add(root.val);
            if(root.left!=null){
                recursion(root.left);
            }
            if(root.right!=null){
                recursion(root.right);
            }
        }
    }
}
