package algorithms.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 11:35 2020/10/15
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order116PopulatingNextRightPointersInEachNode {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val1, Node left1, Node right1, Node next1) {
            val = val1;
            left = left1;
            right = right1;
            next = next1;
        }
    };

    private void bfsRecursion(List<Node> nodes){
        if(nodes.size()==0){
            return;
        }

        List<Node> recursion = new ArrayList<>();
        for(int i=0;i<nodes.size();i++){
            Node node = nodes.get(i);
            if(i+1<nodes.size()){
                node.next = nodes.get(i+1);
            }
            if(node.left!=null){
                recursion.add(node.left);
            }
            if(node.right!=null){
                recursion.add(node.right);
            }
        }
        bfsRecursion(recursion);

    }


    public Node connect(Node root) {
        if(root==null || root.left==null && root.right==null){
            return root;
        }

        List<Node> nodes = Collections.singletonList(root);
        bfsRecursion(nodes);
        return root;
    }
}
