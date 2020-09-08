package leetcode.editor.cn;
//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计


class 最小栈{

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private class Node {
            Node(int value, int min) {
                this.value = value;
                this.min = min;
                this.next = null;
            }

            int value;
            int min;
            Node next;
        }

        private Node head;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x);
            } else if (head.min <= x) {
                Node node = new Node(x, head.min);
                node.next = head;
                head = node;
            }else {
                Node node = new Node(x, x);
                node.next = head;
                head = node;
            }
        }

        public void pop() {
            if (head != null){
                head = head.next;
            }
        }

        public int top() {
            if (head != null){
                return head.value;
            }
            return -1;
        }

        public int getMin() {
            if (head != null){
                return head.min;
            }
            return -1;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
