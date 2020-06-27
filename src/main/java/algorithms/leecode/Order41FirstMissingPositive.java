package algorithms.leecode;

/**
 * @Author LynHB
 * @Description :
 *      Questions:
 *          Given an unsorted integer array, find the smallest missing positive integer.
 * @Date 20:13 2020/6/27
 **/
public class Order41FirstMissingPositive {
    /**
     * @Description :查找第一个缺失的正整数
     * @Date 20:14 2020/6/27
     * @param nums:输入数组
     * @return int
     **/
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        // 遍历数组，将负数替换成l+1;
        for(int i=0;i<l;i++){
            if(nums[i]<=0){
                nums[i] = l+1;
            }
        }

        for(int i=0;i<l;i++){
            if(Math.abs(nums[i])>l){
                continue;
            }
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);

        }
        // 查找不是为负数的数
        for(int i=0;i<l;i++){
            if(nums[i]>=0){
                return i+1;
            }
        }
        return l+1;
    }

}
