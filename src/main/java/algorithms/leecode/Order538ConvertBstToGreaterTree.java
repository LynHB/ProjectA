package algorithms.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * @date: 13:46 2020/9/21
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order538ConvertBstToGreaterTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfsTreeGetVal(TreeNode root,List<Integer> res){
         if(root==null){
             return;
         }
         res.add(root.val);
         if(root.left!=null){
             dfsTreeGetVal(root.left,res);
         }
         if(root.right!=null){
             dfsTreeGetVal(root.right,res);
         }
    }

    private void dfsTreeAddVal(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        Integer number  = list.stream().filter($->$>root.val).mapToInt(x->x).sum();
        root.val +=number;
        if(root.left!=null){
            dfsTreeAddVal(root.left,list);
        }
        if(root.right!=null){
            dfsTreeAddVal(root.right,list);
        }
    }

    public TreeNode convertBST(TreeNode root) {
        // 获取全部节点的val列表
        List<Integer> allVal = new ArrayList<>();
        dfsTreeGetVal(root,allVal);
        dfsTreeAddVal(root,allVal);
        return root;

    }
}
