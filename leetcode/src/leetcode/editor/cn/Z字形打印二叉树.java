package leetcode.editor.cn;

import java.util.Stack;

/**
 * @author lipengke
 * @description:
 * @date 2020/5/6 20:59
 */
class Z字形打印二叉树 {

    // https://blog.csdn.net/p812438109/article/details/101225262

    public void printTree(TreeNode treeNode) {
        if (treeNode != null) {
            Stack<TreeNode> oddStack = new Stack<TreeNode>(); // 奇数栈
            Stack<TreeNode> evenStack = new Stack<TreeNode>(); // 偶数栈

            int line = 1; // 表示第一行

            oddStack.push(treeNode); // 根节点算奇数行, 先把根节点入奇数栈

            TreeNode tempTreeNode = null; // 临时节点

            while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
                if (line % 2 == 1) { // 奇数行

                    while (!oddStack.isEmpty()) { // 判断奇数栈是否为空
                        tempTreeNode = oddStack.pop(); // 奇数栈栈顶元素出栈
                        System.out.print(tempTreeNode.val + ", ");

                        if (tempTreeNode.left != null) {
                            evenStack.push(tempTreeNode.left); // 偶数行左子节点先进栈
                        }
                        if (tempTreeNode.right != null) {
                            evenStack.push(tempTreeNode.right); // 偶数行右子节点后进栈
                        }
                    }
                } else { // 偶数行

                    while (!evenStack.isEmpty()) { // 判断偶数栈是否为空
                        tempTreeNode = evenStack.pop(); // 偶数栈栈顶元素出栈
                        System.out.print(tempTreeNode.val + ", ");

                        if (tempTreeNode.right != null) {
                            oddStack.push(tempTreeNode.right); // 奇数行右子节点先进栈
                        }
                        if (tempTreeNode.left != null) {
                            oddStack.push(tempTreeNode.left); // 奇数行左子节点后进栈
                        }
                    }
                }
                line++; // 二叉树行加1
            }
        }
    }
}
