package leetcode.editor.cn;
import java.util.*;

class 二叉树寻路{

//在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。 
//
// 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记； 
//
// 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。 
//
// 
//
// 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。 
//
// 
//
// 示例 1： 
//
// 输入：label = 14
//输出：[1,3,4,14]
// 
//
// 示例 2： 
//
// 输入：label = 26
//输出：[1,2,6,10,26]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= label <= 10^6 
// 
// Related Topics 树 数学 
// 👍 48 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        // 每一层 最小值 2^(n-1)
        // 每一层 最大值 2^n - 1
        // 每一层 最大值 和 最小值 和
        // 当前节点的上一层根 = 上一层 （最大节点 + 最小节点）- 当前节点/2
        List<Integer> list = new ArrayList<>();
        if (label < 1){
            return list;
        }
        int level = 1;
        int max = 1;
        int min = 1;
        list.add(1);
        while (max < label){
            level++;
            max = (int) Math.pow(2,level) - 1;
            list.add(-1);
        }
        while (label > 1){
            list.set(level - 1,label);
            level--;
            max = (int) Math.pow(2,level) - 1;
            min = (int) Math.pow(2,level - 1);
            label = (max + min) - label/2;
        }
        return list;

    }
}
//leetcode submit region end(Prohibit modification and deletion)





}