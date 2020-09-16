package leetcode.editor.cn;
import java.util.*;

class 二叉树展开为链表{

//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 551 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode right = root.right;
        if (root.left != null){
            root.right = root.left;
            root.left = null;
            TreeNode temp = root;
            while (temp.right != null){
                temp = temp.right;
            }
            temp.right = right;
        }
        flatten(root.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)





}