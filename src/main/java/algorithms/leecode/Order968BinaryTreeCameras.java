package algorithms.leecode;

/**
 * @Author LynHB
 * @Description :
 *  给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 * @Date 19:56 2020/9/22
 **/
public class Order968BinaryTreeCameras {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int res = 0;

    private int dfs(TreeNode tree){
        /*
            [主程-dfs]规定dfs传出的三种状态：
                0:可以被观测，没有摄像机，上一层可有可无摄像机
                1:不可以被观测，上一层必须得有摄像机
                2:有摄像机，上一层允许没有摄像机
         */
        if(tree==null){
            return 0;
        }
        int left = dfs(tree.left);
        int right = dfs(tree.right);
        if(left==1 || right==1){
            res++;
            return 2;
        }else if(left==2 || right==2){
            return 0;
        }else{
            return 1;
        }
    }

    public int minCameraCover(TreeNode root) {
        if(dfs(root)==1){
            res++;
        }
        return res;
    }
}
