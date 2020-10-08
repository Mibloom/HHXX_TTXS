package leetcode.editor.cn;
import java.util.*;
import java.util.concurrent.DelayQueue;

class 最长上升子序列{

//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 1008 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        int[] dp = new int[nums.length]; //dp[i] 是以第i个元素为上升序列的最后一个元素，表示的长度
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)





}