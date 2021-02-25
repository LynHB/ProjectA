package algorithms.leecode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author LynHB
 * @Description :
 *  给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 13:43 2021/2/24
 **/
public class Order832FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A.length==0){
            return new int[0][];
        }
        int[][] res = new int[A.length][A[0].length];
        for(int i=0;i<A.length;i++){
            Stack<Integer> stack = new Stack<Integer>();
            for(int j=0;j<A[i].length;j++){
                stack.push(A[i][j]);
            }
            for(int j=0;j<A[i].length;j++){
                res[i][j] = 1- stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args){
        Order832FlippingAnImage order832FlippingAnImage = new Order832FlippingAnImage();
        System.out.println(Arrays.deepToString(order832FlippingAnImage.flipAndInvertImage(new int[][]{{1, 0, 0}, {0, 1, 1}})));
    }
}
