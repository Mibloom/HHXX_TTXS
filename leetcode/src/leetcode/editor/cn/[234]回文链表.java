package leetcode.editor.cn;
import java.util.*;

class 回文链表{

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 654 👎 0

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
//        ArrayList<ListNode> listNodes = new ArrayList<>();
//        ListNode node = head;
//        while (node != null){
//            listNodes.add(node);
//            node = node.next;
//        }
//        int left = 0;
//        int right = listNodes.size() - 1;
//        while (left < right){
//            if (listNodes.get(left).val != listNodes.get(right).val){
//                return false;
//            }
//            left++;
//            right--;
//        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null ){
            ListNode n = slow;
            fast = fast.next.next;
            slow = slow.next;
            n.next = prev;
            prev = n;

        }
        if (fast != null){
            slow = slow.next;
        }
        while (slow != null && prev != null){
            if (slow.val != prev.val){
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//public static void main(String[] args) {
//    Solution solution = new Solution();
//}
}