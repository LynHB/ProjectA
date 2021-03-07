package algorithms.leecode;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @Author LynHB
 * @Description :
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 13:39 2021/3/7
 **/
public class Order131PalindromePartitioning {

    /**
     * 缓存回文字符串
     */
    private Set<String> palindrome = new HashSet<>();

    /**
     * 字符串是否为回文
     * @param s: 原始字符串
     * @return
     */
    private boolean isPalindrome(String s){
        if(s.length()==1){
            return true;
        }
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        palindrome.add(s);
        return true;

    }

    /**
     * 深度遍历
     * @param res: 结果集存放
     * @param str： 拆解字符串
     * @param tmp： 临时结果集
     */
    private void dfs(List<List<String>> res,String str,List<String> tmp){
        if("".equals(str)){
            // 深拷贝，赋值结果集
            List<String> copy = new ArrayList<>(tmp);
            res.add(copy);
        }

        for(int i=0;i<str.length();i++){
            String left = str.substring(0,i+1);
            String right = str.substring(i+1);
            if(palindrome.contains(left) || isPalindrome(left)){
                tmp.add(left);
                dfs(res,right,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res,s,new ArrayList<>());
        return res;
    }



    public static void main(String[] args){
        Order131PalindromePartitioning order131PalindromePartitioning = new Order131PalindromePartitioning();
        order131PalindromePartitioning.partition("abcdefg");
    }

}
