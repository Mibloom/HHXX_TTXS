package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/13 10:51
 **/
public class 栈和队列用法 {

    public static void main(String[] args) {
        // 栈
        Stack<Object> stack = new Stack<>();

        // 判空
        stack.empty();
        // 判断栈顶元素，但是不出栈
        stack.peek();
        // 出栈
        stack.pop();
        // 入栈
        stack.push("");
        stack.add("");
//-----------------------------------------------------------------//
        // 队列
        Deque<Object> deque = new LinkedList<>();
        // 判断队头元素，但是不出队列
        deque.peek();

        // 获取队头元素,如果为空就返回null，不会抛出异常，pop会抛出异常
        deque.poll();

        // 添加元素
        deque.push("");

        LinkedList<Object> linkedList = new LinkedList<>();


    }
}
