package algorithms.leecode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Order1163LastSubstringInLexicographicalOrder {
    public String lastSubstring(String s) {
        // 获取最大字符
        char maxChar = 'a';
        for(int i=0;i<s.length();i++){
            if(maxChar<s.charAt(i)){
                maxChar = s.charAt(i);
            }
        }

        int index = 0;
        String res = "";
        while((index = s.indexOf(maxChar,index))!=-1){
            String tmp = s.substring(index);
            if(tmp.compareTo(res)>=0){
                res = tmp;
            }
            // 前缀一直为最大字符，则index++
            for(int i=0;i<tmp.length();i++){
                if(tmp.charAt(i)==maxChar){
                    index++;
                }else{
                    break;
                }
            }
            if(index==s.length()){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Order1163LastSubstringInLexicographicalOrder order1163LastSubstringInLexicographicalOrder = new Order1163LastSubstringInLexicographicalOrder();
        System.out.println(order1163LastSubstringInLexicographicalOrder.lastSubstring("askloqz"));
    }
}
