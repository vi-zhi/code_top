package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class LinkedListCycle {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {

            while (null != head) {
                if (head.val == 100001) {
                    return true;
                }
                head.val = 100001;
                head = head.next;
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
        // put your test code here
        ListNode head = ListNode.createHead(new int[]{3, 2, 0, 4, 2});
        System.out.println(solution.hasCycle(head));
        ListNode.print(head);

    }
}