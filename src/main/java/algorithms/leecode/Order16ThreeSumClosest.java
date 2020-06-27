package algorithms.leecode;

import java.util.Arrays;

/**
 * @Author LynHB
 * @Description :
 *      Question :
 *           Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 16:23 2020/6/24
 **/
public class Order16ThreeSumClosest {

    /**
     * @Description :
     * @Date 16:26 2020/6/24
     * @param nums : 数组
     * @param target : 具体值
     * @return int
     **/
    public int threeSumClosest(int[] nums, int target) {
        // 数组排序不是当前题目要考察的点，直接调用库函数
        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;
        // 【主程序-双指针】
        for(int i=0;i<nums.length;i++){
            int b=i+1,e=nums.length-1;
            while(true){
                if(b>=e){
                    break;
                }
                int tmp = nums[i] + nums[b] + nums[e];
                if(res == Integer.MAX_VALUE){
                    res = tmp;
                }else if(Math.abs(tmp-target)<Math.abs(res-target)){
                    res = tmp;
                }

                if(tmp==target){
                    return target;
                }else if(tmp>target){
                    e--;
                }else {
                    b++;
                }
            }
        }
        return res;

    }
}
