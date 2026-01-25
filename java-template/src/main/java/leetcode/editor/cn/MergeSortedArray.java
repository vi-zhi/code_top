package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class MergeSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int mm = m;
            int index = 0;

            while (mm < m + n) {
                nums1[mm++] = nums2[index++];
            }

            for (int i = 0; i < m + n -1; i++) {
                for (int j = 0; j < m + n - i - 1 ; j++) {
                    if(nums1[j] > nums1[j + 1]){
                        int tem = nums1[j + 1];
                        nums1[j + 1] = nums1[j];
                        nums1[j] = tem;
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        // put your test code here
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        // 调用合并方法
        solution.merge(nums1, m, nums2, n);

        // 打印合并后的结果
        System.out.print("合并后的 nums1: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}