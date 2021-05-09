package algorithms.leecode;

/**
 * @Description
 * @Date 12:20 2021/4/21
 * @Author Huang Bing
 */
public class Order91DecodeWays {
    public static class Solution {
        public int numDecodings(String s) {
            int len = s.length();
            if(len==0 || s.charAt(0)=='0'){
                return 0;
            }
            int[] dp = new int[len];
            dp[0] = 1;
            for(int i=1;i<len;i++){
                if(s.charAt(i)=='0'){
                    if(s.charAt(i-1) <='2' && s.charAt(i-1)>'0'){
                        if(i-2>=0){
                            dp[i] = dp[i-2];
                        }else{
                            dp[i] = dp[i-1];
                        }
                    }else{
                        return 0;
                    }
                }else if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)>='0' && s.charAt(i)<='6')){
                    if(i-2>=0){
                        dp[i] = dp[i-1] + dp[i-2];
                    }else{
                        dp[i] = dp[i-1];
                    }
                }
            }
            return dp[len-1];

        }
    }
}
