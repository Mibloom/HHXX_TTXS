package leetcode.editor.cn;
//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class 二叉树的前序遍历{

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

        private List<Integer> list = new ArrayList<>();


        public List<Integer> preorderTraversal(TreeNode root) {
            //if (root != null){
            //    list.add(root.val);
            //    preorderTraversal(root.left);
            //    preorderTraversal(root.right);
            //}

            // 非递归方法做，使用栈
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            while (root != null || !deque.isEmpty()){
                if (root != null){
                    list.add(root.val);
                    deque.push(root);
                    root = root.left;
                }else {
                    root = deque.pop().right;
                }
            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

