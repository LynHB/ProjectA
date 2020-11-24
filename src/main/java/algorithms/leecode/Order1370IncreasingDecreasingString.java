package algorithms.leecode;

import org.apache.commons.lang3.StringUtils;

public class Order1370IncreasingDecreasingString {
    public String sortString(String s) {
        if("".equals(s) || s.length()==1){
            return s;
        }

        int[] chars = new int[26];
        int sTotalSize = s.length();
        StringBuilder res = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            chars[ch-97]++;
        }

        while (sTotalSize != 0){
           for(int i=0;i<chars.length;i++){
               if(chars[i]!=0){
                   res.append((char)(i + 97));
                   chars[i]--;
                   sTotalSize--;
                   if(sTotalSize==0){
                       return res.toString();
                   }
               }
           }

            for(int i=chars.length-1;i>=0;i--){
                if(chars[i]!=0){
                    res.append((char)(i + 97));
                    chars[i]--;
                    sTotalSize--;
                    if(sTotalSize==0){
                        return res.toString();
                    }
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args){
        Order1370IncreasingDecreasingString order1370IncreasingDecreasingString = new Order1370IncreasingDecreasingString();
        order1370IncreasingDecreasingString.sortString("leetcode");
    }
}
