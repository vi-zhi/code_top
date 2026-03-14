package leetcode.editor.cn;

import java.sql.Array;
import java.util.*;

import leetcode.editor.common.*;

public class ThreeSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            Arrays.sort(nums);

            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {

                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == 0) {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[right- 1] == nums[right]) {
                            right--;
                        }
                        while (left < right && nums[left+1] == nums[left]) {
                            left++;
                        }

                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // put your test code here
        List<List<Integer>> ans = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}