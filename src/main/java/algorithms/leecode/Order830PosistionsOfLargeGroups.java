package algorithms.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @date: 9:44 2021/1/5
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order830PosistionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        Character lastChar = null;
        int lastPosition = 0;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(lastChar==null){
                lastChar = s.charAt(i);
                continue;
            }
            if(lastChar == s.charAt(i)){
                continue;
            }else{
                if(i-lastPosition>=3){
                    List<Integer> answer = new ArrayList<>();
                    answer.add(lastPosition);
                    answer.add(i-1);
                    res.add(answer);
                }
                lastChar = s.charAt(i);
                lastPosition = i;
            }

        }
        if(lastChar==s.charAt(s.length()-1)){
            if(s.length()-1-lastPosition>=2){
                List<Integer> answer = new ArrayList<>();
                answer.add(lastPosition);
                answer.add(s.length()-1);
                res.add(answer);
            }
        }

        return res;
    }
}
