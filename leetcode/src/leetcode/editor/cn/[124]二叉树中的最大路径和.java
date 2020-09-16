package leetcode.editor.cn;
import java.util.*;

class 二叉树中的最大路径和{

//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 701 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       help(root);
       return max;
    }
    int help(TreeNode root){
        if(root == null){
            return 0;
        }
        // 左，右子树路径和有可能是负数，反而使路径和变小，如果是负数则不选择
        int left = Math.max(help(root.left),0);
        int right = Math.max(help(root.right),0);
        max = Math.max(max,left + right + root.val);
        return Math.max(left,right) + root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)





}