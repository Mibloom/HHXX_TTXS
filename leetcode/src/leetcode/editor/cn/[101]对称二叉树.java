package leetcode.editor.cn;

import java.util.*;

class 对称二叉树 {

//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1020 👎 0


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
        public boolean isSymmetric(TreeNode root) {
            // 迭代法
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            stack.push(root);
            while (!stack.empty()){
                TreeNode t1 = stack.pop();
                TreeNode t2 = stack.pop();
                if (t1 == null && t2 == null){
                    continue;
                }
                if (t1 == null || t2 == null){
                    return false;
                }
                if (t1.val != t2.val){
                    return false;
                }
                stack.push(t1.left);
                stack.push(t2.right);
                stack.push(t1.right);
                stack.push(t2.left);
            }

            return true;
            // 递归
           // return diff(root, root);
        }

        boolean diff(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            return diff(t1.left, t2.right) && diff(t1.right, t2.left);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}