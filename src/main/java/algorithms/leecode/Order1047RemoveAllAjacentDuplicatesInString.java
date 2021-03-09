package algorithms.leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author LynHB
 * @Description :
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 21:34 2021/3/9
 **/
public class Order1047RemoveAllAjacentDuplicatesInString {

    public String removeDuplicates(String S) {
        Deque<Character> stack = new LinkedList<>();
        char[] bytes = S.toCharArray();
        for (char aByte : bytes) {
            if (stack.isEmpty()) {
                stack.push(aByte);
                continue;
            }
            Character peek = stack.peek();
            if (peek == aByte) {
                stack.pop();
            } else {
                stack.push(aByte);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.removeLast());
        }
        return res.toString();

    }
}
