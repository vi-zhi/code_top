package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author vizhi
 * 描述 :
 * @create 2026-11-20 22:12
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}