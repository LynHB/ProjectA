package algorithms.leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 10:28 2021/3/10
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order224BasicCalculator {
    public int calculate(String s) {
        Deque<Character> stack = new LinkedList<>();
        Deque<Integer> numberStack = new LinkedList<>();

        // 负数转换成-1 =>0-1
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(i == s.length()-1){
                stringBuilder.append(ch);
                continue;
            }
            if(i==0){
                if(ch=='-'){
                    stringBuilder.append("0");
                }
                stringBuilder.append(ch);
                continue;
            }
            char lastCh = s.charAt(i-1);
            if(ch == '-' && lastCh =='('){
                stringBuilder.append("0");
            }
            stringBuilder.append(ch);

        }

        int num = -1;
        s = stringBuilder.toString();
        for(int i=0;i<s.length();i++){
            char character = s.charAt(i);
            if(character>='0' && character<='9'){
                if(num==-1){
                    num =  (character - 48);
                }else{
                    num = num*10 + (character-48);
                }
                continue;
            }

            if(num!=-1){
                if(!stack.isEmpty()){
                    if(stack.peek()=='+'){
                        stack.pop();
                        numberStack.push(numberStack.pop()+num);
                    }else if(stack.peek()=='-'){
                        stack.pop();
                        numberStack.push(numberStack.pop()-num);
                    }else{
                        numberStack.push(num);
                    }
                }else{
                    numberStack.push(num);
                }
                num = -1;
            }

            if(character == '+' || character == '-' || character=='('){
                stack.push(character);
                continue;
            }
            if(character == ' '){
                continue;
            }

            if(character==')'){
                char operation = stack.pop();
                if(operation=='('){
                    if(!stack.isEmpty() && stack.peek()!='('){
                       operation = stack.pop();
                       int number = numberStack.pop();
                       int backNumber = numberStack.pop();
                       if(operation=='+'){
                           numberStack.push(backNumber+number);
                       }else if(operation=='-'){
                           numberStack.push(backNumber-number);
                       }
                    }
                    continue;
                }
                int number = numberStack.pop();
                int backNumber = numberStack.pop();
                if(operation=='+'){
                    numberStack.push(backNumber+number);
                }else if(operation=='-'){
                    numberStack.push(backNumber-number);
                }
                stack.pop();
            }
        }
        if(num!=-1 && !stack.isEmpty()){
            if(stack.peek()=='+'){
                return num+numberStack.pop();
            }else if(stack.peek()=='-'){
                return numberStack.pop()-num;
            }
        }else if(num!=-1){
            return num;
        }
        return numberStack.pop();
    }

    public static void main(String[] args){
        Order224BasicCalculator order224BasicCalculator = new Order224BasicCalculator();
        System.out.println(order224BasicCalculator.calculate("-2+ 1"));
    }
}
