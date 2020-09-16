package leetcode.editor.cn;
import java.util.*;

class 从前序与中序遍历序列构造二叉树{

//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 669 👎 0


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null){
            return null;
        }
        return buildTree(preorder,0,preorder.length,inorder,0,inorder.length);

    }
    TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){
        if (p_start == p_end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        int root_index = 0;
        for (int i = 0; i < i_end; i++) {
            if (inorder[i] == root.val){
                root_index = i;
                break;
            }
        }
        int leftNum = root_index - i_start;
        root.left = buildTree(preorder, p_start + 1, p_start + 1 + leftNum, inorder, i_start, root_index);
        root.right = buildTree(preorder, p_start + 1 + leftNum, p_end, inorder, root_index + 1, i_end);
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)





}