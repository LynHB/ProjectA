package algorithms.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LynHB
 * @Description :
 *      给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @Date 20:11 2020/12/6
 **/
public class Order118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows<=0){
            return res;
        }
        // first line
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);

        for(int i=1;i<numRows;i++){
            List<Integer> line = new ArrayList<>();
            // last line
            List<Integer> lastLine = res.get(i-1);

            // first element
            line.add(1);

            for(int j=1;j<=i-1;j++){
               line.add(lastLine.get(j-1)+lastLine.get(j));
            }

            // end element
            line.add(1);
            res.add(line);
        }
        return res;
    }



}
;