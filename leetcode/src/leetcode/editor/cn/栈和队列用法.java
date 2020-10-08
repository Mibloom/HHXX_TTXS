package leetcode.editor.cn;

import java.util.*;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/13 10:51
 **/
public class 栈和队列用法 {

    public static void main(String[] args) {
//------------------------- 栈 ----------------------------------------//
        String[] split = "dfsfasdf".split("");
        // 栈
        // Stack<Object> stack = new Stack<>();

        ArrayDeque<Object> stack = new ArrayDeque<>();
        // 判空
        stack.isEmpty();
        // 入栈，不允许为null
        stack.push("");
        // 出栈, 如果是null,抛异常
        stack.pop();
        // 出栈, 如果是null,不抛异常，返回null
        stack.poll();
        // 判断栈顶元素，但是不出栈
        stack.peek();

//--------------------------- 队列 --------------------------------------//
        // 队列
        //Queue<Object> queue = new ArrayDeque<>(); //(频繁的随机访问操作 或者 可以确定容量)
        Queue<Object> queue = new LinkedList<>(); // (频繁的插入、删除操作)
        // 获取队头元素，但是不出队列
        queue.peek();
        // 获取队头元素,如果为空就返回null，不会抛出异常，pop会抛出异常
        queue.poll();
        // 队尾添加元素,越界返回false.
        queue.offer("");
        // 队尾添加元素,越界抛异常
        queue.add("");
    }
}
