package leetcode.editor.cn;
import java.util.*;

class 删除链表的倒数第N个节点{

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 984 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;
        ListNode start = prev;
        ListNode end = prev;
        // prev - 1 - 2 - 3 - 4 - 5
        for(int i = 0; i< n; i++){
            end = end.next;
        }
        while (end.next != null){
            start = start.next;
            prev = start;
            end = end.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)





}