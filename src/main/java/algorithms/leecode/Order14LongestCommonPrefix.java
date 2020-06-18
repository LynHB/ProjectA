package algorithms.leecode;

/**
 * @Author LynHB
 * @Description :
 *      Questions :
 *          Write a function to find the longest common prefix string amongst an array of strings.
 *          If there is no common prefix, return an empty string "".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 23:19 2020/6/15
 **/
public class Order14LongestCommonPrefix {
    /**
     * @Description : 获取最长前缀
     * @Date 23:21 2020/6/15
     * @param str : 判断的字符串数组
     * @return java.lang.String
     **/
    public String longestCommonPrefix(String[] str) {
        // 临界值判断
        if (str == null || str.length == 0) {
            return "";
        }
        if(str.length == 1){
            return str[0];
        }

        int length = str[0].length();
        int count = str.length;
        for (int i = 0; i < length; i++) {
            char c = str[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == str[j].length() || str[j].charAt(i) != c) {
                    return str[0].substring(0, i);
                }
            }
        }
        return str[0];
    }

    public static void main(String[] args){
        Order14LongestCommonPrefix order14LongestCommonPrefix = new Order14LongestCommonPrefix();
        System.out.println(order14LongestCommonPrefix.longestCommonPrefix(new String[]{"a","b"}));
    }
}
