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


class 两两交换链表中的节点{

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

            // 1--> 2--> 3--> 4--> 5--> 6
            // 2--> 1--> 3--> 4--> 5--> 6
            // 1--> 3--> 4--> 5--> 6
            // 1-->4-->3-->5

            //ListNode temp = new ListNode(0);
            //temp.next = head;
            //ListNode prev = temp;
            //while (head != null && head.next != null) {
            //    ListNode first = head;
            //    ListNode sec = head.next;
            //
            //    prev.next = sec;
            //    first.next = sec.next;
            //    sec.next = first;
            //
            //    prev = first;
            //    head = first.next;
            //}
            //return temp.next;

            // 递归

            ListNode first = head;
            ListNode sec = head.next;

            first.next  = swapPairs(sec.next);
            sec.next = first;
            return sec;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

