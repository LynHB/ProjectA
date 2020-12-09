package algorithms.leecode;

/**
 * @description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 9:39 2020/12/9
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class Order62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] maze = new int[m][n];

        for(int i=0;i<n;i++){
            maze[m-1][i] = 1;
        }

        for(int i=0;i<m;i++){
            maze[i][n-1] = 1;
        }
        transform(maze,0,0);
        return maze[0][0];
    }

    private void transform(int[][] maz,int x,int y){
        if(maz[x][y]==0){
            transform(maz,x,y+1);
            transform(maz,x+1,y);
            maz[x][y] = maz[x][y+1] + maz[x+1][y];
        }

    }

    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

}
