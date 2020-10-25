package leetcode.editor.cn;

import java.util.*;

class 两数相加 {

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4992 👎 0

    static
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummy = new ListNode(-1);
            ListNode prev = dummy;
            prev.next = l1;
            int sum = 0;
            while (l1 != null && l2 != null) {
                //sum = l1.val + l2.val + sum / 10;
                sum = sum > 9 ? l1.val + l2.val + 1 : l1.val + l2.val;
                prev.next.val = sum % 10;
                prev = prev.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (l1 == null) {
                while (l2 != null) {
                    prev.next = l2;
                    sum = l2.val + sum / 10;
                    prev.next.val = sum % 10;
                    prev = prev.next;
                    l2 = l2.next;
                }
            } else {
                while (l1 != null) {
                    sum = l1.val + sum / 10;
                    prev.next.val = sum % 10;
                    prev = prev.next;
                    l1 = l1.next;
                }
            }
            if (sum / 10 > 0) {
                prev.next = new ListNode(sum / 10);
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


//public static void main(String[] args) {
//    Solution solution = new Solution();
//}
}