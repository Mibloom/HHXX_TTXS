package leetcode.editor.cn;
import java.util.*;

class 最长回文子串{

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2750 👎 0

static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2){
            return s;
        }
        int start = 0;
        int max = 1;
//        for (int i = 0; i < s.length() - 1; i++) {
//            for (int j = i + 1; j < s.length(); j++) {
//                if (j - i + 1 > max && helper(i,j,s)){
//                    start = i;
//                    max = j - i + 1;
//                }
//            }
//        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i <= 2){
                        dp[i][j] = true;
                    }else {
                        // i 和 j 转态变化，保证之前的状态值以及被计算出来了。
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start,start + max);

    }
    boolean helper(int i, int j, String s){
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public static void main(String[] args) {
    Solution solution = new Solution();
    String aaaa = solution.longestPalindrome("aaaa");
}
}