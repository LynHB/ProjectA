package algorithms.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 *      给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * @date: 13:10 2020/9/28
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order117PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    private void bfs(List<Node> tree){
        if(tree.size()==0){
            return;
        }
        List<Node> res = new ArrayList<>();
        if(tree.get(0).left!=null){
            res.add(tree.get(0).left);
        }
        if(tree.get(0).right!=null){
            res.add(tree.get(0).right);
        }

        for(int i=1;i<tree.size();i++){
            tree.get(i-1).next = tree.get(i);
            if(tree.get(i).left!=null){
                res.add(tree.get(i).left);
            }
            if(tree.get(i).right!=null){
                res.add(tree.get(i).right);
            }
        }
        bfs(res);
    }

    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        root.next = null;
        List<Node> trees = new ArrayList<>();
        if(root.left!=null){
            trees.add(root.left);
        }
        if(root.right!=null){
            trees.add(root.right);
        }
        bfs(trees);
        return root;
    }
}
