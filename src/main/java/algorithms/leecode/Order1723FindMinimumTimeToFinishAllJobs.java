package algorithms.leecode;

import java.util.Arrays;

/**
 * @Description
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * 示例 2：
 *
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 13:26 2021/5/8
 * @Author Huang Bing
 */
public class Order1723FindMinimumTimeToFinishAllJobs {
    static class Solution {
        public int minimumTimeRequired(int[] jobs, int k) {
            Arrays.sort(jobs);
            int low = 0, high = jobs.length - 1;
            while (low < high) {
                int temp = jobs[low];
                jobs[low] = jobs[high];
                jobs[high] = temp;
                low++;
                high--;
            }
            int l = jobs[0], r = Arrays.stream(jobs).sum();
            while (l < r) {
                int mid = (l + r) >> 1;
                if (check(jobs, k, mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        public boolean check(int[] jobs, int k, int limit) {
            int[] workloads = new int[k];
            return backtrack(jobs, workloads, 0, limit);
        }

        public boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
            if (i >= jobs.length) {
                return true;
            }
            int cur = jobs[i];
            for (int j = 0; j < workloads.length; ++j) {
                if (workloads[j] + cur <= limit) {
                    workloads[j] += cur;
                    if (backtrack(jobs, workloads, i + 1, limit)) {
                        return true;
                    }
                    workloads[j] -= cur;
                }
                // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
                // 或者当前工作恰能使该工人的工作量达到了上限
                // 这两种情况下我们无需尝试继续分配工作
                if (workloads[j] == 0 || workloads[j] + cur == limit) {
                    break;
                }
            }
            return false;
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.minimumTimeRequired(new int[]{1, 2, 4, 7, 8},2));
    }
}
