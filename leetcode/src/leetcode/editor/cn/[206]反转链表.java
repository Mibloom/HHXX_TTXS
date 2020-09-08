package leetcode.editor.cn;
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


class 反转链表{

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
        public ListNode reverseList(ListNode head) {
            if (head == null){
                return head;
            }
            //ListNode current = head;
            //ListNode prev = null;
            //ListNode temp = null;
            //while (current != null){
            //    temp = current.next;
            //    current.next = prev;
            //    prev = current;
            //    current = temp;
            //}
            //
            //return prev;


            //递归
            ListNode curr = head;
            ListNode next = curr.next;
            if (head == null || next == null) {
                return curr;
            }
            // 1->2->3->4->5->NULL
            // 5->4->3->2->1->NULL
            ListNode node = reverseList(next);
            next.next = head;
            head.next = null;
            return node;

        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
