package leetcode.editor.cn;

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

    public static ListNode getInstance() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        return listNode;
    }

    @Override
    public String toString() {
        HashSet<ListNode> set = new HashSet<>();
        set.add(this);
        String string = "ListNode:[";
        StringBuilder builder = new StringBuilder(string);
        ListNode info = this;
        builder.append(this.val);
        while (info.next != null) {
            set.add(info);
            if (set.contains(info.next)) {
                System.out.println("出现循环节点:" + this.val + "-->" + this.next.val);
                builder.append("-->(");
                builder.append(this.next);
                builder.append(")");
                builder.append("]");
                return builder.toString();
            }
            info.next.prev = info;
            builder.append(",");
            info = info.next;
            builder.append(info.val);
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        ListNode.getInstance();
    }
}
