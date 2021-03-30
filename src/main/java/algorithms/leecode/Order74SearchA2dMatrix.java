package algorithms.leecode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author LynHB
 * @Description :
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 23:23 2021/3/30
 **/
public class Order74SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> list = Arrays.stream(matrix).flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
        int half = list.size()/2;
        int low = 0;
        int high = list.size()-1;
        if(high==low){
            return list.get(0)==target;
        }
        while(low<=high){
            if(low==high){
                return list.get(low)==target;
            }
            if(target==list.get(half)){
                return true;
            }else if(target<list.get(half)){
                high = half-1;
                half = (half-low)/2+low;
            }else{
                low = half+1;
                half = (high-half)/2+half;
            }
        }
        return false;
    }
}
