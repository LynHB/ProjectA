package algorithms.leecode;

/**
 * @Description
 * @Date 13:30 2021/4/19
 * @Author Huang Bing
 */
public class Order27RemoveElement {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int len = nums.length;
            int l = 0;
            for(int i=0;i<len;i++){
                if(nums[i]!=val){
                    nums[l] = nums[i];
                    l++;
                }
            }
            return l;
        }
    }
}
