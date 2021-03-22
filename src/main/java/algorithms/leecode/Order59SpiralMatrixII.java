package algorithms.leecode;

/**
 * @Author LynHB
 * @Description :
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @Date 22:49 2021/3/16
 **/
public class Order59SpiralMatrixII {
    private final int left = 0;
    private final int right = 1;
    private final int top = -1;
    private final int down = -2;

    private void recursion(int turn,int[][] res,int row,int column,int number){
        int n = res.length;
        if(number == n*n){
            res[row][column] = number;
            return;
        }
        if(turn==right){
            int i=column;
            for(;i<n-1 && res[row][i+1]==0;i++){
                res[row][i] = number++;
            }
            recursion(down,res,row,i,number);
        }else if(turn == down){
            int i = row;
            for(;i<n-1 && res[i+1][column]==0;i++){
                res[i][column] = number++;
            }
            recursion(left,res,i,column,number);
        }else if(turn == left){
            int i=column;
            for(;i>0 && res[row][i-1]==0;i--){
                res[row][i] = number++;
            }
            recursion(top,res,row,i,number);
        }else if(turn==top){
            int i = row;
            for(;i>0 && res[i-1][column]==0;i--){
                res[i][column] = number++;
            }
            recursion(right,res,i,column,number);
        }
    }


    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        recursion(right,res,0,0,1);
        return res;
    }

    public static void main(String[] args){
        Order59SpiralMatrixII order59SpiralMatrixII = new Order59SpiralMatrixII();
        order59SpiralMatrixII.generateMatrix(3);
    }
}
