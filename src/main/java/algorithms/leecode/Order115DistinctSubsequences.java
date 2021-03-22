package algorithms.leecode;

/**
 * @Author LynHB
 * @Description :
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 21:46 2021/3/17
 **/
public class Order115DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) {
            return 0;
        }
        /*
         * 状态转移方程式：
         * 0 <= i <= s.len && j == t.len:
         *      dp[i][j] = 1 : 当t为空字符串，s中所有字符皆可匹配
         * i == s.len && j == t.len:
         * 0 <= i < s.len &&  0 <= j < s.len:
         *      dp[i][j] = 0 : 当s为空字符串时，t除了空字符串外其他皆不可匹配
         *     s[i]==t[j]: dp[i][j] = dp[i+1][j+1] + dp[i+1][j]
         *     s[i]!=t[j]: dp[i][j] = dp[i+1][j]
         */
        int[][] dp = new int[s.length()+1][t.length()+1];

        //  0 <= i < s.len && j == t.len
        for(int i=0;i<=s.length();i++){
            dp[i][t.length()] = 1;
        }
        // 0 <= i < s.len && 0 <= j<t.len
        for(int i=s.length()-1;i>0;i--){
            for(int j=t.length()-1;j>0;j--){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                }else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }

        return dp[0][0];
    }
}
