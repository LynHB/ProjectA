package algorithms.leecode;

/**
 * @description:
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 12:35 2020/12/7
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order861ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int res = m * (1<<(n-1));

        for(int j=1;j<n;j++){
            int nOnes = 0;
            for(int i=0;i<m;i++){
                if(A[i][0]==1){
                    nOnes += A[i][j];
                }else{
                    nOnes += (1 - A[i][j]);
                }
            }
            int k = Math.max(nOnes,m - nOnes);
            res += k * (1 << (n - j - 1));

        }

        return res;
    }
}
