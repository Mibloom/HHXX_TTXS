package leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.*;

class 把二叉搜索树转换为累加树 {

//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。 
//
// 
//
// 例如： 
//
// 输入: 原始二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
//
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
// Related Topics 树 
// 👍 326 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return root;
            }
            // 迭代法
//            Stack<TreeNode> stack = new Stack<>();
//            int sum = 0;
//            TreeNode node = root;
//            while (!stack.empty() || node != null) {
//                while (node != null) {
//                    stack.push(node);
//                    node = node.right;
//                }
//                node = stack.pop();
//                sum += node.val;
//                node.val = sum;
//                // 遍历左子树
//                node = node.left;
//            }
            // 递归做法
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}