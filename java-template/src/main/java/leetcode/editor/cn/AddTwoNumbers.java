package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class AddTwoNumbers {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode cur = new ListNode(0);
            ListNode per = cur;


            int carry = 0;
            int curnum = 0;
            int cnt = 0;
            while (l1 != null || l2 != null) {

                cnt++;

                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;

                int sum = carry + x + y;
                carry = sum / 10;
                curnum = sum % 10;

                if(cnt == 1){
                    cur.val = curnum;

                }else {
                    ListNode tem = new ListNode(0);
                    tem.val = curnum;
                    cur.next = tem;
                    cur = cur.next;
                }

                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry >= 1) {
                cur.next = new ListNode(carry);
            }
            return per;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        // put your test code here
        ListNode l1 = ListNode.createHead(new int[]{2, 4, 3});
        ListNode l2 = ListNode.createHead(new int[]{5, 6, 4});
        ListNode res = solution.addTwoNumbers(l1, l2);

    }
}