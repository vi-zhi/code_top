package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class Permutations {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> permute(int[] nums) {
            //答案
            List<List<Integer>> ans = new ArrayList<>();
            int length = nums.length;
            boolean[] st = new boolean[length];
            List<Integer> path = Arrays.asList(new Integer[length]);


            dfs(0, nums, st, ans, path);

            return ans;
        }

        public void dfs(int index, int[] nums, boolean[] st, List<List<Integer>> ans, List<Integer> path) {
            if (index == nums.length) {
                List<Integer> tem = new ArrayList<>(path);

                ans.add(tem);
                return ;
            }
            for (int i = 0; i < nums.length; i++) {
                if(!st[i]) {
                    st[i] = true;
                    path.set(index , nums[i]);
                    dfs(index + 1, nums, st, ans, path);
                    st[i] = false;
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        // put your test code here
        int[] nums = {1,2,3};
        solution.permute(nums);

    }
}