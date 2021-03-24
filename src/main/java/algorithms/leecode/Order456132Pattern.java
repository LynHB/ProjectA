package algorithms.leecode;

import java.util.TreeMap;

/**
 * @description:
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 *
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 *
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 10:05 2021/3/24
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order456132Pattern {
    public static class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            if (n < 3) {
                return false;
            }
            int first = nums[0];
            TreeMap<Integer,Integer> right = new TreeMap<>();
            for(int i=2;i<n;i++){
                right.put(nums[i],right.getOrDefault(nums[i],0)+1);
            }
            // 寻找132中的3
            for(int i=1;i<n-1;i++){
                int third = nums[i];
                if(third>first){
                    Integer second = right.ceilingKey(first+1);
                    if(second != null && second<third){
                        return true;
                    }
                }
                first = Math.min(first,third);
                right.put(nums[i+1],right.get(nums[i+1])-1);
                if(right.get(nums[i+1])==0){
                    right.remove(nums[i+1]);
                }
            }
            return false;
        }
    }
}
