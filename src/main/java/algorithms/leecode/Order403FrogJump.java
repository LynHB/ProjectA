package algorithms.leecode;

/**
 * @Description
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 *
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 *
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 *
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 12:19 2021/4/29
 * @Author Huang Bing
 */
public class Order403FrogJump {
    static class Solution {
        private int[][] memory;
        private boolean dfs(int[] stones,int index,int jump){
            int len = stones.length;
            if(index == len-1){
                return true;
            }
            boolean res;
            int nextIndex = index+1;
            while(true){
                if(nextIndex<len && stones[nextIndex]<=jump+1+stones[index] && stones[nextIndex]>=jump-1+stones[index]){
                    if(memory[index][jump]==-1){
                        return false;
                    }
                    res = dfs(stones,nextIndex,stones[nextIndex]-stones[index]);
                    if(res){
                        return true;
                    }
                }
                if(nextIndex==len){
                    break;
                }

                nextIndex++;
            }
            memory[index][jump]=-1;
            return false;
        }

        public boolean canCross(int[] stones) {
            int len = stones.length;
            if(len==1){
                return true;
            }
            if(stones[1]>1){
                return false;
            }
            memory = new int[len][len];
            return dfs(stones,1,stones[1]-stones[0]);
        }
    }

    static class Solution2 {
        public boolean canCross(int[] stones) {
            int n = stones.length;
            boolean[][] dp = new boolean[n][n];
            dp[0][0] = true;
            for (int i = 1; i < n; ++i) {
                if (stones[i] - stones[i - 1] > i) {
                    return false;
                }
            }
            for (int i = 1; i < n; ++i) {
                for (int j = i - 1; j >= 0; --j) {
                    int k = stones[i] - stones[j];
                    if (k > j + 1) {
                        break;
                    }
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                    if (i == n - 1 && dp[i][k]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.canCross(
                new int[]{0,1,3,6,10,15,16,21}));
    }
}
