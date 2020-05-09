package leetcode.editor.cn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索


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
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return lists;
        }
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            lists.add(new ArrayList<>());
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.remove();
                lists.get(level).add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            level++;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = lists.size() - 1; i >= 0; i--) {
            System.out.println(Arrays.toString(lists.get(i).toArray()));
            list.add(lists.get(i));
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
