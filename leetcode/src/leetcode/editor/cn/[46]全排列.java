package leetcode.editor.cn;

import java.util.*;

class 全排列 {

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 931 👎 0

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) {
                return new ArrayList<>();
            }
            int len = nums.length;
            boolean[] mark = new boolean[len];
            ArrayList<List<Integer>> res = new ArrayList<>();
            ArrayList<Integer> ele = new ArrayList<>();
            helper(nums, res, ele, mark, len);
            return res;
        }

        void helper(int[] nums, List<List<Integer>> res, List<Integer> ele, boolean[] mark, int len) {
            if (ele.size() == len) {
                res.add(new ArrayList<>(ele));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (mark[i]) {
                    continue;
                }
                mark[i] = true;
                ele.add(nums[i]);
                helper(nums, res, ele, mark, len);
                ele.remove(ele.size() - 1);
                mark[i] = false;

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permute(new int[]{1, 2, 3});
    }
}