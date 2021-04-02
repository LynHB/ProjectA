package algorithms.leecode;

/**
 * @Description
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1
 * @Date 10:04 2021/4/2
 * @Author Huang Bing
 */
public class Order1721VolumeOfHistogramLcci {
    static class Solution {
        public int trap(int[] height) {
            int res = 0;

            int high = 0;
            int highIndex = -1;
            for(int i=0;i<height.length;i++){
                if(high<height[i]){
                    high = height[i];
                    highIndex = i;
                }
            }
            // 从左到最高点
            int lh = 0;
            for(int i=0;i<highIndex;i++){
                if(height[i]>lh){
                    lh = height[i];
                    continue;
                }
                res +=lh-height[i];
            }

            // 从右到左最高点
            int rh = 0;
            for(int i=height.length-1;i>highIndex;i--){
                if(height[i]>rh){
                    rh = height[i];
                    continue;
                }
                res +=rh-height[i];
            }
            return res;
        }
    }
}
