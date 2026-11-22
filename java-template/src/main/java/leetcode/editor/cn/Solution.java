package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

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

    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        int flag = 0;
        int count = 0;

        while (true) {

            for (int i = k; i > 0; i--) {

                if (head == null) {
                    flag = 1;
                    break;
                }
                ListNode tem = new ListNode(head.val);
                head = head.next;


                stack.push(tem);
                if (head == null && i != 1) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                while (!stack.isEmpty()) {
                    p.next = stack.pollLast();
                    p = p.next;
                }
                break;
            }

            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }

        }
        return newHead.next;
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i - 1];
            } else {
                dp[i] = dp[i - 1] + nums[i-1 ];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}