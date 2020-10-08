package leetcode.editor.cn;
import java.util.*;

class 删除排序链表中的重复元素II{

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 375 👎 0

static
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        if (head.val  != head.next.val){
            head.next = deleteDuplicates(head.next);
        }else {
            while (head != null && head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
        return head;
//        ListNode slow = head;
//        ListNode fast = head.next;
//        ListNode dummy = new ListNode(-1);
//        ListNode prev = dummy;
//        prev.next = head;
//        while (fast != null){
//            if (slow.val != fast.val){
//                prev = slow;
//                slow = slow.next;
//                fast = fast.next;
//            }else {
//                while (fast != null && fast.val == slow.val){
//                    fast = fast.next;
//                }
//                prev.next = fast;
//                if (fast != null) {
//                    slow = prev.next;
//                    fast = fast.next;
//                }
//            }
//
//        }
//        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//public static void main(String[] args) {
//    Solution solution = new Solution();
//}
}