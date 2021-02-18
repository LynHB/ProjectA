package algorithms.leecode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 10:04 2021/2/1
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order888FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        B = Arrays.stream(B).sorted().toArray();
        int aTotal = Arrays.stream(A).sum();
        int bTotal = Arrays.stream(B).sum();
        int average = (aTotal - bTotal)/2;
        Set<Integer> rec = new HashSet<>();
        for(int num : A){
            rec.add(num);
        }
        int[] res = new int[2];
        for(int y : B){
            int x = y + average;
            if(rec.contains(x)) {
                res[0] = x;
                res[1] = y;
                break;
            }
        }
        return res;
    }
}
