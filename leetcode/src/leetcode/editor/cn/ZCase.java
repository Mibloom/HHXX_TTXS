package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/16 14:47
 **/
public class ZCase {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null){
                builder.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }else {
                builder.append("null");
            }
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (!data.startsWith("[") || !data.endsWith("]")) {
            return null;
        } else {
            data = data.replace("[", "").replace("]", "");
        }
        String[] split = data.split(",");
        if (split[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(split[index])) {
                node.left = new TreeNode(Integer.valueOf(split[index]));
                queue.add(node.left);
            }
            index++;
            if (!"null".equals(split[index])) {
                node.right = new TreeNode(Integer.valueOf(split[index]));
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        ZCase zCase = new ZCase();
        String serialize = zCase.serialize(TreeNode.initTree("[1,2,3,null,null,4,5]"));
        TreeNode deserialize = zCase.deserialize(serialize);
        System.out.println(deserialize);
    }
}
