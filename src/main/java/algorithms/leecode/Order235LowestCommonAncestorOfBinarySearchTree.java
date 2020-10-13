package algorithms.leecode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 9:36 2020/9/27
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order235LowestCommonAncestorOfBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
       如果p包含q，则返回true
     */
    private boolean containTree(TreeNode p, TreeNode q){
        if(p==null){
            return false;
        }

        if(p.val==q.val){
            return true;
        }
        return containTree(p.left,q) || containTree(p.right,q);
    }

    /**
     * 当root的左子树或者右子树包含p或者q,则root为返回值
     */
    private boolean getPath(TreeNode root, TreeNode p,List<TreeNode> treeNodes){
        if(root==null){
            return false;
        }
        if(root.val==p.val){
            treeNodes.add(root);
            return true;
        }
        if(root.left!=null){
            treeNodes.add(root);
            boolean isPath = getPath(root.left,p,treeNodes);
            if(!isPath){
                treeNodes.remove(root);
            }else{
                return true;
            }
        }

        if(root.right!=null){
            treeNodes.add(root);
            boolean isPath = getPath(root.right,p,treeNodes);
            if(!isPath){
                treeNodes.remove(root);
            }else{
                return true;
            }
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 除去极限值
        if(root.val==p.val || root.val==q.val){
            return root;
        }

        // 是否存在包含关系
        if(containTree(p,q)){
            return p;
        }else if(containTree(q,p)){
            return q;
        }
        // 获取两个节点的path
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        getPath(root,p,pPath);
        getPath(root,q,qPath);
        int pSize = pPath.size();
        int qSize = qPath.size();
        TreeNode res = root;
        for(int i=0;i<Math.min(pSize,qSize);i++){
            if(pPath.get(i)==qPath.get(i)){
                res = pPath.get(i);
            }else{
                break;
            }
        }
        return res;
    }
}
