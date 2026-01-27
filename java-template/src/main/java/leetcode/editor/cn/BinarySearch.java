package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BinarySearch {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isTrue(int num , int target){
            return num < target;
        }

        public int search(int[] nums, int target) {
            int left = -1;
            int right = nums.length;
            while(left + 1 != right){
                int mid = (left + right) / 2;
                if(isTrue(nums[mid] , target)){
                    left = mid;
                }else{
                    right = mid;
                }
            }
            if(right == nums.length){
                return -1;
            }
            return nums[right] == target ? right : -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        // put your test code here
        int[] nums = {-1,0,3,5,9,12 };
        int target = 13;
        int search = solution.search(nums, target);


    }
}