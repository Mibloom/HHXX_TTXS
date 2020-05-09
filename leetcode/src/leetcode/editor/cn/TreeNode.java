package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/26 13:49
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    static TreeNode initTree(Integer[] array) {
        if (array == null || array[0] == null) {
            throw new IllegalStateException("树头节点不能为空");
        }
        TreeNode root = new TreeNode(array[0]);
        TreeNode head = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        for (int i = 1; i < array.length ; i++) {
            if (i % 2 == 1){
                if (array[i] != null){
                    root.left = new TreeNode(array[i]);
                    queue.add(root.left);
                }
            }else {
                if (array[i] != null){
                    root.right = new TreeNode(array[i]);
                    queue.add(root.right);
                }
                root = queue.remove();
            }
        }
        return head;
    }

    static TreeNode initTree(String arrayString){
        String array = arrayString.replaceAll(" ","")
                .replace("[", "")
                .replace("]", "");
        String[] split = array.split(",");
        Integer[] arrayInt = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("null")){
                arrayInt[i] = null;
            }else {
                arrayInt[i] = Integer.valueOf(split[i]);
            }
        }
        return initTree(arrayInt);
    }

    public static void main(String[] args) {
        initTree("[3,9,20,null,18,15,7,]");
    }
}
