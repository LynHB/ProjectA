package algorithms.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 9:36 2021/2/20
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order697DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int max=0,min=0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (max < arr[0]) {
                max = arr[0];
                min = arr[2] - arr[1] + 1;
            } else if (max == arr[0]) {
                min = Math.min(min,arr[2] - arr[1] + 1);
            }
        }
        return min;
    }
}
