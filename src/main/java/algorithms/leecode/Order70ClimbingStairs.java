package algorithms.leecode;

/**
 * @author LynHB
 * @description :
 *      Question :
 *          You are climbing a stair case. It takes n steps to reach to the top.
 *          Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *      Note :
 *          Given n will be a positive integer.
 *      Examples :
 *          Example 1:
 *              Input: 2
 *              Output: 2
 *              Explanation: There are two ways to climb to the top.
 *                  1. 1 step + 1 step
 *                  2. 2 steps
 *          Example 2:
 *              Input: 3
 *              Output: 3
 *              Explanation: There are three ways to climb to the top.
 *                  1. 1 step + 1 step + 1 step
 *                  2. 1 step + 2 steps
 *                  3. 2 steps + 1 step
 *
 *      来源：力扣（LeetCode）
 *      链接：https://leetcode-cn.com/problems/climbing-stairs
 *      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出
 * @Date 10:37 2020/6/13
 **/
public class Order70ClimbingStairs {
    /**
     * @Description : 主程序入口
     * @Date: 10:58 2020/6/13
     * @param n : 需要爬的楼梯数
     * @return int
     **/
    public int climbStairs(int n) {
        // 临界值判断
        int critical = 2;
        if(critical>=n){
            return n;
        }

        /*
            [主程序-动态规划(dynamic programs)]:标准的dp,不存在任何难度
                i==1 :  dp[i] = 1
                i==2 :  dp[i] = 2
                i > 2:  dp[i] = dp[i-1] + dp[i-2]
         */
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] agrs){
        Order70ClimbingStairs order70ClimbingStairs = new Order70ClimbingStairs();
        System.out.println(order70ClimbingStairs.climbStairs(10));
    }
}
