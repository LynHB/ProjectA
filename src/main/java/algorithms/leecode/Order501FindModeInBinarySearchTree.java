package algorithms.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 *
 * @date: 12:36 2020/9/24
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order501FindModeInBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfs(TreeNode tree,Map<Integer,Integer> map){
        if(tree==null){
            return;
        }
        map.computeIfAbsent(tree.val, k -> 0);
        map.put(tree.val,map.get(tree.val)+1);
        dfs(tree.left,map);
        dfs(tree.right,map);
    }

    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        dfs(root,map);
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(max < entry.getValue()){
                max = entry.getValue();
            }
        }
        if(max==Integer.MIN_VALUE){
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(max == entry.getValue()){
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
