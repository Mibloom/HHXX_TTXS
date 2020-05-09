package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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
class Solution94 {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        //if (root != null) {
        //    inorderTraversal(root.left);
        //    list.add(root.val);
        //    inorderTraversal(root.right);
        //}

        //非递归
        ArrayDeque<TreeNode> deque = new ArrayDeque();
        while (root != null || !deque.isEmpty()) {
            if (root != null) {
                deque.push(root);
                root = root.left;
            } else {
                root = deque.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
