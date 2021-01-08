package algorithms.leecode;

/**
 * @description:
 *  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @date: 9:55 2021/1/8
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order189RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int rotate = k % len;
        int[] rotateNum = new int[len];
        for(int i=0;i<len;i++){
            rotateNum[(i+rotate)%len] = nums[i];
        }
        System.arraycopy(rotateNum, 0, nums, 0, len);
    }
}
