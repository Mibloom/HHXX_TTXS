package leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class 有效的括号{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public  boolean isValid(String s) {
//            Stack<Character> stack = new Stack<>();
//            Map<Character,Character> map = new HashMap<>();
//            map.put('}','{');
//            map.put(')','(');
//            map.put(']','[');
//            for(Character chara : s.toCharArray()){
//                if (!map.containsKey(chara)){
//                    stack.push(chara);
//                }else {
//                    if (stack.empty() || !stack.pop().equals(map.get(chara))){
//                        return false;
//                    }
//                }
//            }
//            return stack.empty();

            Stack<Character> stack = new Stack<>();
            for(Character c : s.toCharArray()){
                if (c.equals('{')){
                    stack.push('}');
                }else if (c.equals('(')){
                    stack.push(')');
                }else if (c.equals('[')){
                    stack.push(']');
                }else {
                    if (stack.empty() || !stack.pop().equals(c)){
                        return false;
                    }
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

