package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ClimbingStairs {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] memory = new int[50];
        public int climbStairs(int n) {
           memory[1] = 1;
           memory[2] = 2;

            for(int i = 3; i <= n ;i++) {
                int x = memory[i - 1] + memory[i-2];
                memory[i] = x;
            }
            return memory[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        // put your test code here
        
    }
}