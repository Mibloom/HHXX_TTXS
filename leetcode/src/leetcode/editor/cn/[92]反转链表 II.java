package leetcode.editor.cn;

import java.util.*;

class 反转链表II {

//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 523 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null || m == n) {
                return head;
            }
            //1->2->3->4->5->NULL, m = 2, n = 4

            ListNode dummy = new ListNode(-1);
            ListNode prev = dummy;
            prev.next = head;
            ListNode end  = null;
            ListNode curr = head;
            for (int i = 1; i <= n; i++) {
                if (i == m - 1){
                    prev = curr;
                }
                if (i == n){
                    end = curr;
                }
                curr = curr.next;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode node = reverse(prev.next);
            //1-> 4->3->2 ->5

            prev.next.next = next;
            prev.next = node;
            return dummy.next;
        }

        ListNode reverse(ListNode head){
            if (head.next == null){
                return head;
            }
            //1->4->3->2->5
            //1-> 4-3-2-5
            ListNode node = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}