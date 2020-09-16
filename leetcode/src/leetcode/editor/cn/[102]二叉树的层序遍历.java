package leetcode.editor.cn;
import java.util.*;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


class 二叉树的层序遍历{

//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            if (root == null){
                return lists;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                ArrayList<Integer> integers = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = queue.poll();
                    integers.add(pop.val);
                    if (pop.left != null){
                        queue.add(pop.left);
                    }
                    if (pop.right != null){
                        queue.add(pop.right);
                    }
                }
                lists.add(integers);
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
