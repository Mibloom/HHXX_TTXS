package leetcode.editor.cn;
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表


class K个一组翻转链表{

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1) {
                return head;
            }
            //ListNode dummy = new ListNode(0);
            //dummy.next = head;
            //ListNode prev = dummy;
            //ListNode end = dummy;
            //while (end.next != null) {
            //    for (int i = 0; i < k  && end != null; i++) {
            //        end = end.next;
            //    }
            //    if (end == null) {
            //        break;
            //    }
            //    ListNode start = prev.next;
            //    ListNode next_head = end.next;
            //    ListNode reverse = reverse(start, next_head);
            //    // 0-3-2-1-4-5-6
            //    prev.next = reverse;
            //    start.next = next_head;
            //    prev = start;
            //    end = prev;
            //}
            //return dummy.next;

            // 递归 每次返回调转之后的头节点
            ListNode end = head;
            for (int i = 0; i < k; i++) {
                // [1,2] k = 2
                if (end == null){
                    return head;
                }
                end = end.next;
            }
            ListNode reverse = reverse(head, end);
            ListNode listNode = reverseKGroup(end, k);
            head.next = listNode;
            return reverse;

        }

        private ListNode reverse(ListNode head, ListNode next_head) {
            ListNode curr = head;
            ListNode prev = null;
            while (curr != next_head) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

