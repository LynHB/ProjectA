package algorithms.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author LynHB
 * @Description :
 *      Questions :
 *          Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *          Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 21:03 2020/6/16
 **/
public class Order297SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public final static String ORDER_SPLIT = "\\|";
    public final static String ORDER_IN_SPLIT = ",";


    /**
     * @Description : 序列化对象
     * @Date 21:16 2020/6/16
     * @param root :需要序列化的对象
     * @return java.lang.String
     **/
    public String serialize(TreeNode root) {
        // 先序遍历
        String preOrder = preOrder(root);
        // 中序遍历
        String inOrder = inOrder(root);
        return preOrder+"|"+inOrder;

    }

    private String preOrder(TreeNode root){
        if(root==null){
            return "";
        }
        return root.val+ORDER_IN_SPLIT+preOrder(root.left)+preOrder(root.right);
    }

    private String inOrder(TreeNode root){
        if(root==null){
            return "";
        }
        return inOrder(root.left)+root.val+ORDER_IN_SPLIT+inOrder(root.right);
    }



    /**
     * @Description :将字符串反序列化为对象
     * @Date 21:17 2020/6/16
     * @param data : 反序列化字符串
     * @return TreeNode
     **/
    public TreeNode deserialize(String data) {
        int orderNumber = 2;
        if(data==null || data.length()==0 || data.trim().length()==0 || data.split(ORDER_SPLIT).length!=orderNumber){
            return null;
        }

        String[] preorderArr = data.split(ORDER_SPLIT)[0].split(ORDER_IN_SPLIT);
        String[] inorderArr = data.split(ORDER_SPLIT)[1].split(ORDER_IN_SPLIT);
        int[] preorder = new int[preorderArr.length];
        int[] inorder = new int[inorderArr.length];
        for(int i=0;i<preorderArr.length;i++){
            preorder[i] = Integer.parseInt(preorderArr[i]);
            inorder[i] = Integer.parseInt(inorderArr[i]);
        }

        return  buildTree(preorder,inorder);
    }

    /**
     * @Description :通过前序遍历，中序遍历还原TreeNode
     * @Date 21:35 2020/6/16
     * @param preorder :前序遍历数组
     * @param inorder  ：中序遍历数组
     * @return ：TreeNode
     **/
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        if(preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        return buildTree(preorder,inorder,
                0,preorder.length-1,
                0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder,int[] inorder,
                               int pb,int pe,int ib,int ie){
        if(pb > pe || ib > ie){
            return null;
        }
        if(pb == pe || ib == ie){
            return new TreeNode(preorder[pb]);
        }
        TreeNode root = new TreeNode(preorder[pb]);

        /***
         * 中序遍历分割点：
         *  左子树：ib到inSplit-1
         *  右子树：inSplit+1到ie
         */
        int inSplit=-1;
        int preSplit = -1;
        Set<Integer> rightValSet = new HashSet<>();
        for(int i=ib;i<=ie;i++){
            if(inorder[i]==root.val){
                inSplit = i;
            }else if(inSplit!=-1){
                rightValSet.add(inorder[i]);
            }
        }
        // 判断右子树是否还存在节点,如果存在则需要分割前序遍历数组
        if(inSplit!=ie){
            for (int i=pb;i<=pe;i++){
                if(rightValSet.contains(preorder[i])){
                    preSplit = i;
                    break;
                }
            }
        }
        if(preSplit!=-1){
            root.left = buildTree(preorder,inorder,pb+1,preSplit-1,ib,inSplit-1);
            root.right = buildTree(preorder,inorder,preSplit,pe,inSplit+1,ie);
        }else{
            root.left = buildTree(preorder,inorder,pb+1,pe,ib,inSplit-1);
        }

        return root;
    }

    public static void main(String[] args){
        Order297SerializeAndDeserializeBinaryTree order297SerializeAndDeserializeBinaryTree = new Order297SerializeAndDeserializeBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        String serialize = order297SerializeAndDeserializeBinaryTree.serialize(treeNode);
        System.out.println(serialize);
        order297SerializeAndDeserializeBinaryTree.deserialize(serialize);
        return;
    }
}
