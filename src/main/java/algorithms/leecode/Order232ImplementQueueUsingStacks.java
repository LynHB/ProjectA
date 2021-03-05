package algorithms.leecode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * @date: 13:33 2021/3/5
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order232ImplementQueueUsingStacks {
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    /** Initialize your data structure here. */
    public Order232ImplementQueueUsingStacks() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }



    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }


}
