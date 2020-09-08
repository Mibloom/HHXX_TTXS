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


import java.util.Stack;

class 有效的括号{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public  boolean isValid(String s) {
            //HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            //        //    put(')', '(');
            //        //    put('}', '{');
            //        //    put(']', '[');
            //        //}};
            //        //char[] chars = s.toCharArray();
            //        //Stack<Character> stack = new Stack<>();
            //        //stack.push('?');
            //        //for (char aChar : chars) {
            //        //    if (map.containsKey(aChar)){
            //        //        if (!stack.pop().equals(map.get(aChar))){
            //        //            return false;
            //        //        }
            //        //    }else {
            //        //        stack.push(aChar);
            //        //    }
            //        //}
            //        //return stack.size() == 1;

            if (s.isEmpty()) {
                return true;
            }

            Stack<Character> stack = new Stack<>();
            for (Character a : s.toCharArray()){
                if (a.equals('(')){
                    stack.push(')');
                }else if (a.equals('[')){
                    stack.push(']');
                }else if (a.equals('{')){
                    stack.push('}');
                }else if (stack.empty() || !a.equals(stack.pop())){
                    return false;
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

