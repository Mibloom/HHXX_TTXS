package leetcode.editor.cn;

import java.util.*;

class 字符串的排列 {

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 109 👎 0

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Set<String> res = new HashSet<>();
        boolean[] mark;
        String s;

        public String[] permutation(String s) {
            if (s == null || s.length() == 0) {
                return new String[]{};
            }
            this.s = s;
            mark = new boolean[s.length()];
            StringBuilder s1 = new StringBuilder();
            solve(s1);
            return res.toArray(new String[0]);
        }

        void solve(StringBuilder s1) {
            if (s1.length() == s.length()) {
                res.add(s1.toString());
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if (mark[i]) {
                    continue;
                }
                mark[i] = true;
                StringBuilder builder = new StringBuilder(s1);
                solve(builder.append(s.charAt(i)));
                mark[i] = false;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


//public static void main(String[] args) {
//    Solution solution = new Solution();
//}
}