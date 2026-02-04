package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class LongestCommonPrefix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            if (Objects.equals(strs[0], "")) {
                return "";
            }
            int min = 201;

            int ans = 0;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < min) {
                    min = strs[i].length();
                }
            }

            for (int i = 0; i < min; i++) {
                int flag = 0;
                for (int j = 0; j < strs.length - 1; j++) {
                    if (strs[j].charAt(i) == strs[j + 1].charAt(i)) {
                        flag++;
                    } else {
                        flag = -1;
                        break;
                    }
                }
                if(flag == -1){
                    break;
                }
                if (flag == strs.length - 1) {
                    ans++;
                }
            }
            //构造字符串
            String ansStr = "";
            if (ans == 0) {
                return ansStr;
            }
            for (int i = 0; i < ans; i++) {
                ansStr += strs[0].charAt(i);
            }
            return ansStr;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        // put your test code here
        String[] strs = {"flower","flower","flower","flower"};
        solution.longestCommonPrefix(strs);
    }
}