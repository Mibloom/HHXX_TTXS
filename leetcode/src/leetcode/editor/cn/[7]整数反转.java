package leetcode.editor.cn;
import java.util.*;

class 整数反转{

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2227 👎 0

static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0){
            int temp = x % 10;
            res = res * 10 + temp;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
            x = x / 10;
        }
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public static void main(String[] args) {
    Solution solution = new Solution();
    int reverse = solution.reverse(1534236469);
    System.out.println(reverse);
}
}