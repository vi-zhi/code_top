package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TwoSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            for(int i = 0 ; i < nums.length ; i++){  
                for(int j = 1 ; j < nums.length ; j++){
                    if(nums[i] + nums[j] == target && i != j){

                        ans[0] = i;
                        ans[1] = j;
                        return ans;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // put your test code here
        int[] nums = {3, 3};
        int target = 6;

        // 调用twoSum方法并接收结果
        int[] result = solution.twoSum(nums, target);

    }
}