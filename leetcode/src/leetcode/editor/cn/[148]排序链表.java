package leetcode.editor.cn;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

class 排序链表 {

//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 731 👎 0


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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 两组两组排序合并,链表如果长为8
            // 第一次，每组1个
            // 第二次，每组2个
            // 第三次，每组4个，共排序完后8个已经成有序
            // 第四次，每组8个
            // 第五次，每组16个
            int level = 1;
            int length = 0;
            ListNode n = head;
            while (n != null) {
                n = n.next;
                length++;
            }
            ListNode dummy = new ListNode(-1);
            ListNode prev = dummy;
            dummy.next = head;
            while (level < length) {
                prev = dummy;
                n = dummy.next;
                while (n != null) {
                    int i = level;
                    ListNode h1 = n;
                    while (i > 0 && n != null) {
                        n = n.next;
                        i--;
                    }
                    if (i > 0) {
                        break;
                    }
                    ListNode h2 = n;
                    i = level;
                    while (i > 0 && n != null) {
                        n = n.next;
                        i--;
                    }
                    int i1 = level;
                    int i2 = level - i;
                    while (i1 > 0 && i2 > 0) {
                        if (h1.val <= h2.val) {
                            prev.next = h1;
                            h1 = h1.next;
                            i1--;
                        } else {
                            prev.next = h2;
                            h2 = h2.next;
                            i2--;
                        }
                        prev = prev.next;
                    }
                    prev.next = i1 == 0 ? h2 : h1;
                    while (i1 > 0 || i2 > 0) {
                        prev = prev.next;
                        i1--;
                        i2--;
                    }
                    prev.next = n;
                }
                level = 2 * level;
            }
            return dummy.next;




//            if (head == null || head.next == null) {
//                return head;
//            }
//            // 二分
//            ListNode fast = head.next;
//            ListNode slow = head;
//            while (fast != null && fast.next != null) {
//                fast = fast.next.next;
//                slow = slow.next;
//            }
//            ListNode temp = slow.next;
//            slow.next = null;
//            // 递归 空间复杂度是O(logn)
//            ListNode left = sortList(head);
//            ListNode right = sortList(temp);
//            ListNode dummy = new ListNode(-1);
//            ListNode prev = dummy;
//            while (left != null && right != null) {
//                if (left.val <= right.val) {
//                    prev.next = left;
//                    left = left.next;
//                } else {
//                    prev.next = right;
//                    right = right.next;
//                }
//                prev = prev.next;
//            }
//            prev.next = left == null ? right : left;
//            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}