package algorithms.leecode;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @Author LynHB
 * @Description :
 *      Question:
 *          You are building a diving board by placing a bunch of planks of wood end-to-end. There are two types of planks, one of length shorter and one of length longer. You must use exactly K planks of wood. Write a method to generate all possible lengths for the diving board.
 *
 *          return all lengths in non-decreasing order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 10:25 2020/7/8
 **/
public class Order1611DivingBoardLCCI {



    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[0];
        }
        if(longer==shorter){
            return new int[]{longer*k};
        }

        // 存放shorter木板数量，shorterNumber + longerNumber = k
        int[] memory = new int[k+1];
        for(int i=0;i<k+1;i++){
            memory[i] = i*longer+(k-i)*shorter;
        }
        return memory;
    }
}
