package algorithms.leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @date: 17:33 2021/2/18
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order995MinimumNumberOfKConsecutiveBitFlips {
    public static int minKBitFlips(int[] A, int K) {
        int res = 0;
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (que.size() > 0 && i > que.peek() + K - 1) {
                que.removeFirst();
            }
            //1.本来是1，翻转奇数次变为0，所以需要再次翻转，放入队列
            //2.本来是0，翻转偶数次还是0，所以需要再次翻转，放入队列
            if (que.size() % 2 == A[i]) {
                if (i + K > A.length) return -1;
                que.add(i);
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(minKBitFlips(new int[]{0,0,0,1,0,1,1,0},3));
    }
}
