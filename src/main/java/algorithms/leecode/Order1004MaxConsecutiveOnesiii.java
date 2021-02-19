package algorithms.leecode;

import java.util.Map;

/**
 * @description:
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * @date: 9:52 2021/2/19
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order1004MaxConsecutiveOnesiii {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int windowsZero =0;
        int res  = 0;
        for(int right = 0;right<A.length;right++){
            if(A[right]==0){
                windowsZero++;
            }
            while(windowsZero>K){
                if(A[left]==0){
                    left++;
                    windowsZero--;
                    break;
                }
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
        
    }
}
