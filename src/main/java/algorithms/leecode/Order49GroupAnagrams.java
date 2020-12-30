package algorithms.leecode;

import java.util.*;

/**
 * @Author LynHB
 * @Description :
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * @Date 20:13 2020/12/14
 **/
public class Order49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            String toLowerArrayStr = toLowerArrayStr(str);
            map.putIfAbsent(toLowerArrayStr, new ArrayList<>());
            map.get(toLowerArrayStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String toLowerArrayStr(String str){
        int[] chs = new int[27];
        for(int i=0;i<str.length();i++){
            chs[str.charAt(i)-97] ++;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<chs.length;i++){
            for(int j=0;j<chs[i];j++){
                res.append((char)i+97);
            }
        }
        return res.toString();
    }

}
