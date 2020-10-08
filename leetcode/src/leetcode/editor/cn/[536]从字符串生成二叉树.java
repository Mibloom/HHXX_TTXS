package leetcode.editor.cn;

import java.util.*;

class 从字符串生成二叉树 {

//你需要从一个包括括号和整数的字符串构建一棵二叉树。 
//
// 输入的字符串代表一棵二叉树。它包括整数和随后的 0 ，1 或 2 对括号。整数代表根的值，一对括号内表示同样结构的子树。 
//
// 若存在左子结点，则从左子结点开始构建。 
//
// 
//
// 示例： 
//
// 输入："4(2(3)(1))(6(5))"
//输出：返回代表下列二叉树的根节点:
//
//       4
//     /   \
//    2     6
//   / \   / 
//  3   1 5   
// 
//
// 
//
// 提示： 
//
// 
// 输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9' 
// 空树由 "" 而非"()"表示。 
// 
//
// 
// Related Topics 树 字符串 
// 👍 35 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode str2tree(String s) {
            // 输入："4(2(3)(1))(6(5))"
            // 根节点开始，遇到数字创建节,查看栈顶元素，左子树为null，则为左子树，否则右子树。然后入栈，遇到）出栈
            if (s == null || s.length() == 0) {
                return null;
            }
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '('){
                    continue;
                }else if (s.charAt(i) == ')'){
                    stack.poll();
                    continue;
                }else {
                    String val = "";
                    while (i < s.length() && s.charAt(i) != ')' && s.charAt(i) != '('){
                        val = val+s.charAt(i++);
                    }
                    i--;
                    TreeNode node = new TreeNode(Integer.valueOf(val));
                    if (!stack.isEmpty()){
                        TreeNode root = stack.peek();
                        if (root.left == null){
                            root.left = node;
                        }else {
                            root.right = node;
                        }
                    }
                    stack.push(node);
                }
            }

            return stack.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}