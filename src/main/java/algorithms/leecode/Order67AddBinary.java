package algorithms.leecode;

import java.util.Stack;

/**
 * @Author LynHB
 * @Description :
 *      Questions :
 *          Given two binary strings, return their sum (also a binary string).
 *          The input strings are both non-empty and contains only characters 1 or 0.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 20:58 2020/6/23
 **/
public class Order67AddBinary {

    public String addBinary(String a, String b) {
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();

        for(int i=0;i<a.length();i++){
            stackA.push(a.charAt(i));
        }
        for(int i=0;i<b.length();i++){
            stackB.push(b.charAt(i));
        }
        String res = "";
        boolean carry = false;
        while(!stackA.empty() || !stackB.empty()){
            boolean boolA = stackA.empty()||stackA.pop()=='0'?false:true;
            boolean boolB = stackB.empty()||stackB.pop()=='0'?false:true;
            if(boolA && boolB && carry){
                res = "1" + res;
            }else if(boolA && boolB && !carry){
                res = "0" + res;
                carry = true;
            }else if((boolA || boolB) && carry){
                res = "0" + res;
                carry = true;
            }else if(!(boolA||boolB) && carry){
                res = "1" + res;
                carry = false;
            }else if((boolA||boolB) && !carry){
                res = "1" + res;
                carry = false;
            } else {
                res = "0" + res;
                carry = false;
            }
        }
        return carry==true?"1"+res:res;
    }

    public static void main(String[] args){
        Order67AddBinary order67AddBinary = new Order67AddBinary();
        System.out.println(order67AddBinary.addBinary("11","1"));
    }
}