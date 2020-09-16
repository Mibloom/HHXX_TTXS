package leetcode.editor.cn;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/26 13:49
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static TreeNode initTree(Integer[] array) {
        if (array == null || array[0] == null) {
            throw new IllegalStateException("树头节点不能为空");
        }
        TreeNode root = new TreeNode(array[0]);
        TreeNode head = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        for (int i = 1; i < array.length; i++) {
            if (i % 2 == 1) {
                if (array[i] != null) {
                    root.left = new TreeNode(array[i]);
                    queue.add(root.left);
                }
            } else {
                if (array[i] != null) {
                    root.right = new TreeNode(array[i]);
                    queue.add(root.right);
                }
                root = queue.remove();
            }
        }
        return head;
    }

    static TreeNode initTree(String arrayString) {
        String array = arrayString.replaceAll(" ", "")
                .replace("[", "")
                .replace("]", "");
        String[] split = array.split(",");
        Integer[] arrayInt = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("null")) {
                arrayInt[i] = null;
            } else {
                arrayInt[i] = Integer.valueOf(split[i]);
            }
        }
        return initTree(arrayInt);
    }

    void printTree(TreeNode root) {
        List<List<Integer>> levelLists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levelLists.add(list);
        }
        int level = levelLists.size();
        int width = 4 * level - 3;
        int leftStart = width / 2;
        for (int i = 0; i < levelLists.size(); i++) {
            List<Integer> arrNode = levelLists.get(i);
            for (int j = 0; j < width; j++) {
                if (j != leftStart){
                    System.out.print(" ");
                }else {
                    break;
                }
            }
            for (Integer val : arrNode) {
                System.out.print(val);
                System.out.print(" ");
            }
        }
    }
}
