package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class ValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            int length = s.length();
            if (length % 2 != 0) {
                return false;
            }
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }
                if (c == ')' || c == ']' || c == '}') {
                    if(stack.isEmpty()){
                        return false;
                    }
                    Character pop = stack.pop();
                    if (pop == '(') {
                        if (c == '}' || c == ']') {
                            return false;
                        }
                    }
                    if (pop == '{') {
                        if (c == ')' || c == ']') {
                            return false;
                        }
                    }
                    if (pop == '[') {
                        if (c == '}' || c == ')') {
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // put your test code here

    }
}