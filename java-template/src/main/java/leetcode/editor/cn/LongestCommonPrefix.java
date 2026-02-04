package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class LongestCommonPrefix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            int min = 201;

            int ans = 0;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < min) {
                    min = strs[i].length();
                }
            }

            for (int i = 0; i < strs.length; i++) {
                int flag = 0;
                for (int j = 0; j < min; j++) {

                    flag++;
                    char c = strs[i].charAt()

                }
                if(flag == strs.length){
                    ans++;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        // put your test code here

    }
}