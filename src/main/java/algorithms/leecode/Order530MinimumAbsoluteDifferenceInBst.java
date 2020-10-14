package algorithms.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 9:48 2020/10/12
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order530MinimumAbsoluteDifferenceInBst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void dfsGetNode(TreeNode root, List<Integer> vals){
        if(root==null){
            return ;
        }
        vals.add(root.val);
        dfsGetNode(root.left,vals);
        dfsGetNode(root.right,vals);
    }
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        if(root==null){
            return 0;
        }
        List<Integer> vals = new ArrayList<>();
        dfsGetNode(root,vals);
        if(vals.size()<=1){
            return 0;
        }
        Collections.sort(vals);
        for(int i=1;i<vals.size();i++){
            res = Integer.min(vals.get(i)-vals.get(i-1),res);
        }
        return res;
    }
}
