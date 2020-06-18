package algorithms.leecode;

import com.sun.source.tree.Tree;

/**
 * @Author LynHB
 * @Description :
 *      Questions :
 *          We run a preorder depth first search on the root of a binary tree.
 *          At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)
 *          If a node has only one child, that child is guaranteed to be the left child.
 *          Given the output S of this traversal, recover the tree and return its root.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 10:50 2020/6/18
 **/
public class Order1028RecoverATreeFromPreorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void recoverFromPreorder(TreeNode root,String s,int b,int e,int layer){
        if(b >= e){
            return;
        }
        int border = 0,layerCount=0,layerCountTwice = 0;
        String leftStr="",rightStr="";
        // 找到左边的数
        for(int i=b;i<=e;i++){
            if(s.charAt(i)=='-' && layerCount<layer){
                layerCount++;
            }else if(s.charAt(i)=='-'){
                break;
            }else if(s.charAt(i)!='-' && layer == layerCount){
                leftStr += s.charAt(i);
            }else{
                layerCount = 0;
            }
        }
        // 找到右边的树，并找到border
        layerCount = 0;
        for(int i=b;i<=e;i++){
            if(s.charAt(i)=='-'){
                layerCount++;
            }else if(s.charAt(i)!='-'){
                if(layer==layerCount){
                    layerCountTwice++;
                }
                layerCount = 0;
                if(layerCountTwice==2){
                    border = i;
                }
            }

            if(border!=0 && s.charAt(i)!='-'){
                rightStr+=s.charAt(i);
            }else if(border!=0){
                break;
            }

        }

        if(!leftStr.equals("")){
            root.left = new TreeNode(Integer.parseInt(leftStr));
            if(border!=0){
                recoverFromPreorder(root.left,s,b,border,layer+1);
            }else{
                recoverFromPreorder(root.left,s,b,e,layer+1);
                return;
            }

        }
        if(!rightStr.equals("")){
            root.right = new TreeNode(Integer.parseInt(rightStr));
            recoverFromPreorder(root.right,s,border,e,layer+1);
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        if(S.length()==0){
            return null;
        }
        if(!S.contains("-")){
            return new TreeNode(Integer.parseInt(S));
        }
        String rootStr = "";
        int i;
        for(i=0;i<S.length();i++){
            if(S.charAt(i)=='-'){
                break;
            }
            rootStr += S.charAt(i);
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootStr));
        recoverFromPreorder(root,S,i,S.length()-1,1);
        return root;
    }

    public static void main(String[] args){
        Order1028RecoverATreeFromPreorderTraversal order1028RecoverATreeFromPreorderTraversal = new Order1028RecoverATreeFromPreorderTraversal();
        TreeNode treeNode = order1028RecoverATreeFromPreorderTraversal.recoverFromPreorder("1-2--3---4-5--6---7");
        return;

    }
}
