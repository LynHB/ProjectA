package algorithms.leecode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author LynHB
 * @Description :
 *      Questions :
 *          Given an integer array arr and a target value target, return the integer value such that when we change all the integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.
 *          In case of a tie, return the minimum such integer.
 *          Notice that the answer is not neccesarilly a number from arr.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 10:44 2020/6/14
 **/
public class Order1300SumOfMutatedArrayClosestToTarget {
    /**
     * @Description :
     * @Date 10:46 2020/6/14
     * @param arr : 传入数组
     * @param target :目标总和
     * @return int
     **/
    public int findBestValue(int[] arr, int target) {
        int l = arr.length;

        // 临界值处理
        if(l==1){
            return target;
        }

        // 平均值：让每个元素都趋向于该平均值
        int averageVal = target/l;

        // 统计出超过该平均值的个数和总和情况
        int largerNumber = 0;
        int largerSum = 0;
        int sum = 0;
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<l;i++){
            if(arr[i]>averageVal){
                largerNumber++;
                largerSum+=arr[i];
            }
            sum += arr[i];
            largest = Math.max(largest,arr[i]);
        }

        // 当数组总和和目标值相等时，直接返回数组中最大的值
        if(sum==target){
            return largest;
        }


        int removeLargeAverageVal;
        // 当没有一个值是大于平均值（averageVal）时或者全部都大于averageVal，averageVal为最小接近解，原因在于int型向下取整
        if(largerNumber==0 || largerNumber==l){
            removeLargeAverageVal =  averageVal;
        }else{
            // 小于averageVal的的平均值即为最终的解的最小接近解，原因在于int型是向下取整
            removeLargeAverageVal = (sum - largerSum)/(l-largerNumber);
        }

        int diff = Integer.MAX_VALUE;
        while(true){
            int ns = 0;
            for(int i:arr){
                ns +=Math.min(i,removeLargeAverageVal);
            }

            if(ns>target){
                // 第一次while true 就已经大于target 此时直接返回removeLargeAverageVal
                if(diff==Integer.MAX_VALUE){
                    return removeLargeAverageVal;
                }else{
                    // 比较ns < target 和ns > target的diff差值
                   if(Math.abs(diff)<=Math.abs(target-ns)){
                       return removeLargeAverageVal-1;
                   }else{
                       return removeLargeAverageVal;
                   }
                }

            }else if(ns == target){
                return removeLargeAverageVal;
            }
            diff = target - ns;
            removeLargeAverageVal++;
            // 如果已经超过了最大值，那么实际上无论如何增加removeLargeAverageVal,ns都无法改变，始终小于targe，此时返回largest
            if(removeLargeAverageVal>largest){
                return largest;
            }
        }

    }

    public static void main(String[] args){
        Order1300SumOfMutatedArrayClosestToTarget order1300SumOfMutatedArrayClosestToTarget = new Order1300SumOfMutatedArrayClosestToTarget();
        System.out.println(order1300SumOfMutatedArrayClosestToTarget.findBestValue(new int[]{4,9,3},10));
    }
}
