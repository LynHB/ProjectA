package algorithms.leecode;

/**
 * @description:
 * @date: 19:32 2020/12/23
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] chs = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            chs[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(chs[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
