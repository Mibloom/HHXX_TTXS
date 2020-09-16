package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lipengke
 * @description:
 * @date 2020/3/18 22:05
 */
class ListNode {
    int val;
    ListNode next;
    private ListNode prev;

    ListNode(int x) {
        val = x;
    }

    ListNode() {
    }

    public static ListNode getInstance(int count) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        for (int c = 1; c <= count; c++) {
            prev.next = new ListNode(c);
            prev = prev.next;
        }
        return dummy.next;
    }

    public static ListNode getInstance(int... array) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        for (int i : array) {
            prev.next = new ListNode(i);
            prev = prev.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        HashMap<ListNode, Integer> map = new HashMap<>();
        String string = "ListNode:[";
        StringBuilder builder = new StringBuilder(string);
        ListNode curr = this;
        while (curr != null) {
            map.put(curr, map.size() + 1);
            if (curr.next != null && map.containsKey(curr.next)) {
                int currIndex = map.size();
                int cycIndex = map.get(curr.next);
                String format = String.format("链表出现环, 第%s位ListNode:[%s]的next指向第%s位ListNode:[%s])",
                        currIndex, curr.val, cycIndex, curr.next.val);
                System.err.println(format);
                curr.next = null;
            }
            builder.append(curr.val);
            curr = curr.next;
            if (curr != null) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
