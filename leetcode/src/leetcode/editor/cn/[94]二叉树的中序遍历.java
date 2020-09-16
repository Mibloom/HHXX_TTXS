package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


class 二叉树的中序遍历 {


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private List<Integer> list = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return list;
            }
//                inorderTraversal(root.left);
//                list.add(root.val);
//                inorderTraversal(root.right);
//                return list;

            //非递归
           Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.empty()){
                if (root != null){
                    stack.push(root);
                    root = root.left;
                }else {
                    TreeNode pop = stack.pop();
                    list.add(pop.val);
                    root = root.right;
                }
            }
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
