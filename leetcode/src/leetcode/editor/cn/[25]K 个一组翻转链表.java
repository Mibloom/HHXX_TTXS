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



class K个一组翻转链表 {

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1){
                return head;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prev = dummy; // prev 两个子链之间的纽带，把2个子链关联起来
            ListNode end = head;
            ListNode start = head;
            while (end != null){
                for (int i = 0; i < k - 1; i++) {
                    end = end.next;
                    if (end == null){
                      return dummy.next;
                    }
                }
                ListNode temp = end.next;
                ListNode reverse = reverse(start,end);
                prev.next = reverse;
                prev = start;
                start.next = temp;
                start = temp;
                end = temp;
            }
            return dummy.next;

        }
        private ListNode reverse(ListNode start, ListNode end){
            if (start == null || start == end){
                return start;
            }
            ListNode reverse = reverse(start.next, end);
            // 1-2-3   3-2 1
            ListNode temp = start.next;
            temp.next = start;
            start.next = null;
            return reverse;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

