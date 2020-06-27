package algorithms.leecode;

import java.util.Stack;

/**
 * @Author LynHB
 * @Description :
 *      Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 17:51 2020/6/19
 **/
public class Order125ValidPalindrome {

    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z' ||
                    s.charAt(i)>='A' && s.charAt(i)<='Z' ||
                    s.charAt(i)>='0' && s.charAt(i)<='9'){
                System.out.println(s.charAt(i));
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        String tmp = sb.toString().toLowerCase();
        if(tmp.equals(sb.reverse().toString().toLowerCase())){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        Order125ValidPalindrome order125ValidPalindrome = new Order125ValidPalindrome();
        System.out.println(order125ValidPalindrome.isPalindrome("0P"));
    }
}
