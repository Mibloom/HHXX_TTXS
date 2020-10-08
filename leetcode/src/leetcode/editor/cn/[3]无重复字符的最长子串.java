package leetcode.editor.cn;
import java.util.*;

class 无重复字符的最长子串{

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4390 👎 0

static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null){
            return 0;
        }
        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            ArrayList<Character> list = new ArrayList<>();
//            for (int j = i; j < s.length(); j++) {
//                if (list.contains(s.charAt(j))){
//                    break;
//                }
//                list.add(s.charAt(j));
//                max = Math.max(max,list.size());
//            }
//        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)){
                start = Math.max(map.get(c) + 1,start); // 防止star左移
            }
            map.put(c,end);
            max = Math.max(max,end - start + 1);

        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//public static void main(String[] args) {
//    Solution solution = new Solution();
//}
}