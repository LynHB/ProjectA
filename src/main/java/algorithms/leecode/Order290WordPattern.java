package algorithms.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * @date: 10:02 2020/12/16
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order290WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split("\\s+");
        Map<Character,String> characterStringMap = new HashMap<>();
        Map<String,Character> stringCharacterMap = new HashMap<>();
        if(split.length!=pattern.length()){
            return false;
        }

        for(int i=0;i<split.length;i++){
            Character character = pattern.charAt(i);
            String patternStr = characterStringMap.get(character);
            if(patternStr == null){
                characterStringMap.put(character,split[i]);
                if(stringCharacterMap.get(split[i])!=null){
                    return false;
                }
                stringCharacterMap.put(split[i],character);
            }else if(!patternStr.equals(split[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Order290WordPattern order290WordPattern = new Order290WordPattern();
        System.out.println(order290WordPattern.wordPattern("abba","dog dog dog dog"));
    }
}
