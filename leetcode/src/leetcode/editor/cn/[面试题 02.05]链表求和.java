package leetcode.editor.cn;
import java.util.*;

class 链表求和{

//给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 链表 数学 
// 👍 32 👎 0


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode prev= dummy;
        prev.next = n1;
        int sum = 0;
        while (n1 != null && n2 != null){
            sum = (n1.val + n2.val + sum / 10);
            prev.next.val = sum % 10;
            prev = prev.next;
            n1 = n1.next;
            n2 = n2.next;
        }
        if (n1 == null){
            while (n2 != null){
                prev.next = n2;
                sum = sum / 10 + n2.val;
                prev.next.val = sum % 10;
                prev = prev.next;
                n2 = n2.next;
            }
        }else {
            while (n1 != null){
                sum = sum / 10 + n1.val;
                prev.next.val = sum % 10;
                prev = prev.next;
                n1 = n1.next;
            }
        }
        if (sum / 10 > 0){
            prev.next = new ListNode(sum / 10);
        }
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)





}