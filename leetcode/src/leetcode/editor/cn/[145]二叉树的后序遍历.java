package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


class 二叉树的后序遍历{

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

        public List<Integer> postorderTraversal(TreeNode root) {
            //if (root != null){
            //    postorderTraversal(root.left);
            //    postorderTraversal(root.right);
            //    list.add(root.val);
            //}

            // 非递归遍历

            //二叉树的后序遍历为顺序为左孩子->右孩子->根节点，
            //其难点在于每输出一个节点都要保证其左孩子和右孩子都已经被输出，
            //在解决这个重要步骤时，我们使用两个辅助栈，当前节点入栈1，然后出栈1入栈2，
            //然后将该节点的以左->右的顺序压入栈1，只有以这样的顺序入栈1，
            //才能保证这三部分如栈2的顺序是根->右->左，
            //这样在从栈2弹出的时候就符合了后序遍历左->右->根的顺序。

            LinkedList<TreeNode> stack1 = new LinkedList<>();

            // 左 右 根
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            stack1.push(root);
            while (!stack1.isEmpty()) {
                if (!stack1.isEmpty()) {
                    root = stack1.pop();
                    list.push(root.val);
                    if (root.left != null) {
                        stack1.push(root.left);
                    }
                    if (root.right != null) {
                        stack1.push(root.right);
                    }
                }
            }
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
