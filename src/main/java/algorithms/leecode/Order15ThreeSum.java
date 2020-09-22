package algorithms.leecode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author LynHB
 * @Description :
 *      Question :
 *          Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 *          Find all unique triplets in the array which gives the sum of zero.
 *      Note :
 *         The solution set must not contain duplicate triplets.
 *      Example :
 *          Given array nums = [-1, 0, 1, 2, -1, -4],
 *          A solution set is:
 *              [
 *                  [-1, 0, 1],
 *                  [-1, -1, 2]
 *              ]
 * @Date 3:29 2020/6/12
 **/
public class Order15ThreeSum {

    public int quickSwap(int[] nums,int b,int e){
        // 异常判断：开始索引大于结束索引
        if(b>e){
            return Integer.MIN_VALUE;
        }
        int v = nums[b];
        int r = e;
        int l = b;
        while(true){
            if(l>=r){
                break;
            }
            // 从右往左判断：右边的元素必须大于v
            while(nums[r]>=v && r>l){
                r--;
            }
            if(l>=r){
                break;
            }else{
                nums[l] = nums[r];
                l++;
            }


            // 从左往右判断，左边的元素必须小于v
            while(nums[l]<v && r>l){
                l++;
            }
            if(l>=r){
                break;
            }else{
                nums[r] = nums[l];
                r--;
            }
        }
        nums[r] = v;
        return r;

    }

    /**
     * @Description : 快速排序入口
     * @Date 3:40 2020/6/12
     * @param nums: 快排数组
     * @param b: 快排索引开始位置
     * @param e: 快排索引结束位置
     * @return void
     **/
    public void quickSort(int[] nums,int b,int e){
        if(b>=e){
            return;
        }
        int middle = quickSwap(nums,b,e);
        quickSort(nums,b,middle-1);
        quickSort(nums,middle+1,e);
    }

    /**
     * @Description :
     * @Date 3:42 2020/6/12
     * @param nums: 输入的数组
     * @Exception
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 参数校验
        if(nums.length==0){
            return res;
        }

        // 数组快排
        quickSort(nums,0,nums.length-1);

        /*
            [主程序-滑动窗口]：
                Main Program：
                    固定一个数字，然后另外两个元素做滑动窗口，当总体值大于0时，右边的索引--，反之左边的索引++
                Note:
                    此时需要考虑数组重复元素的存在,需要变量进行辅助判断
         */
        for(int i=0;i<nums.length-2;i++){
            int b = i+1;
            int e = nums.length-1;
            while(true){
                // while true 跳出点
                if(b==e){
                    break;
                }

                int sum = nums[i] + nums[b] + nums[e];
                if(sum == 0){
                    // 该点符合我们的要求，加入到返回集合中
                    res.add(Arrays.asList(new Integer[]{nums[i], nums[b], nums[e]}));

                    // 滑动窗口：将b 右移动
                    while(true){
                        b++;
                        if(b==e){
                            break;
                        }

                        // 判断和上个节点是否一致，一致的话跳过该点
                        if(nums[b]==nums[b-1]){
                            continue;
                        }else{
                            break;
                        }
                    }
                }else if(sum < 0){
                    // sum < 0 :那么将b进行右移动
                    b++;
                }else {
                    // sum > 0 :将e进行左移动
                    e++;
                }

            }
        }
        return res;
    }
    


    public static void main(String[] args){
        Order15ThreeSum order15ThreeSum = new Order15ThreeSum();
        int[] nums = new int[]{3,1,23,19,32,91,9,3};
        order15ThreeSum.quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
