package algorithms.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
 * 是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 *  你可以按任意顺序返回答案。
 *  示例 1：
 * 	输入：["bella","label","roller"]
 * 	输出：["e","l","l"]
 *
 *  示例 2：
 * 	输入：["cool","lock","cook"]
 * 	输出：["c","o"]
 * @date: 9:35 2020/10/14
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order1002FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();

        if(A.length == 0){
            return res;
        }

        /*
            [主程-木桶记录]：
                1.创建map存放对应的字母和数量
                2.循环体内也创建对应的innerMap存放对应的字符和数量
                3-1. i=0 : 该map为最终map
                3-2. i>0 : 比对map和循环内的map，取字符的最小值
                4.将map和对应的数量转换成最终返回格式
         */

        // 1. 创建map存放对应的字母和数量
        Map<Character,Integer> map = new HashMap<>(16);
        boolean first = true;
        for(String str : A){
            // 2. 循环体内也创建对应的innerMap存放对应的字符和数量
            Map<Character,Integer> innerMap = new HashMap<>(16);
            for(int i=0;i<str.length();i++){
                Character character = str.charAt(i);
                Integer num = innerMap.putIfAbsent(character,1);
                if(num!=null){
                    innerMap.put(character,innerMap.get(character)+1);
                }
            }

            //  3-1. i=0 : 该map为最终map
            if(first){
                map = innerMap;
                first = false;
                continue;
            }
            // 3-2. i>0 : 比对map和循环内的map，取字符的最小值
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                Integer integer = innerMap.get(entry.getKey());
                if(integer!=null){
                    entry.setValue(Math.min(integer,entry.getValue()));
                }else{
                    entry.setValue(0);
                }
            }
        }

        // 4.将map和对应的数量转换成最终返回格式
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            for(int i=0;i<entry.getValue();i++){
                res.add(String.valueOf(entry.getKey()));
            }
        }
        return res;
    }

    public static void main(String[] args){
        Order1002FindCommonCharacters order1002FindCommonCharacters = new Order1002FindCommonCharacters();
        order1002FindCommonCharacters.commonChars(new String[]{"acdd", "cdaw"});
    }
}
