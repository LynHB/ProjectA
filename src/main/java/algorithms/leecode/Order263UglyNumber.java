package algorithms.leecode;

/**
 * @Author LynHB
 * @Description :
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 8:41 2021/4/10
 **/
public class Order263UglyNumber {
    static class Solution {
        public boolean isUgly(int n) {
            if(n<=0) {
                return false;
            }
            if(n==1 || n==2 || n==3 || n==5){
                return true;
            }
            if(n%2==0){
                return isUgly(n/2);
            }
            if(n%3==0){
                return isUgly(n/3);
            }
            if(n%5==0){
                return isUgly(n/5);
            }
            return false;
        }
    }
}
