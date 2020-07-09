package algorithms.leecode;

/**
 * @Author LynHB
 * @Description :
 *      Question :
 *          Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 22:35 2020/6/28
 **/
public class Order209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0) {
            return 0;
        }
        if(s == 1){
            return 1;
        }
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int tmp = 0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            tmp ++;

            boolean bigger = false;
            while(sum >= s){
                   sum -= nums[i-tmp+1];
                   tmp --;
                   bigger = true;
            }
            if(bigger){
                res = Math.min(res,tmp+1);
            }
        }
        return res==Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args){
        Order209MinimumSizeSubarraySum order209MinimumSizeSubarraySum = new Order209MinimumSizeSubarraySum();
        System.out.println(order209MinimumSizeSubarraySum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
