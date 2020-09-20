package leetcode.editor.cn;

import java.util.*;

class 买卖股票的最佳时机IV {

//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
// 
//
// 示例 2: 
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。
// 
// Related Topics 动态规划 
// 👍 298 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length < 2 || k < 1) {
                return 0;
            }
            if (k >= prices.length / 2) {
                return greedy(prices, prices.length);
            }
            int[][][] dp = new int[prices.length + 1][k + 1][3];
            System.out.println();
            for (int i = 0; i < prices.length + 1; i++) {
                for (int j = 0; j < k + 1; j++) {
                    dp[i][j][1] = -9999;
                    dp[i][j][2] = -9999;
                }
            }
            for (int i = 1; i < prices.length + 1; i++) {
                for (int j = 1; j < k + 1; j++) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Math.max(Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i - 1]), dp[i - 1][j - 1][2] - prices[i - 1]);
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j][1] + prices[i-1]);
                }
            }
            return Math.max(dp[prices.length][k][0], dp[prices.length][k][2]);

        }

        private int greedy(int[] prices, int len) {
            // 转换为股票系列的第 2 题，使用贪心算法完成，思路是只要有利润，就交易
            int res = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i - 1] < prices[i]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}