package leetcode.editor.cn;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


class 两两交换链表中的节点 {

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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(-1);
            ListNode prev = dummy;
            prev.next = head;
            ListNode l1 = head;
            while (l1 != null && l1.next != null) {
                ListNode l2 = l1.next;
                ListNode temp = l2.next;
                l1.next = temp;
                l2.next = l1;
                prev.next = l2;
                prev = l1;
                l1 = l1.next;
            }
            return dummy.next;

// Your IntelliJ IDEA subscription expired on 2020/9/10. If you don't renew it before 2020/9/17, you will no longer be able to use the product
//            // 递归
//            ListNode l1 = head;
//            ListNode l2 = l1.next;
//            ListNode node = swapPairs(l2.next);
//            l2.next = l1;
//            l1.next = node;
//            return l2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

