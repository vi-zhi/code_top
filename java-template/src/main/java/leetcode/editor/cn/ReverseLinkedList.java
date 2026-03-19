package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseLinkedList {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {

            if(head == null) return null;

            Stack<Integer> stack = new Stack<Integer>();
            while(null != head){
                stack.push(head.val);
                head = head.next;
            }

            ListNode pre = new ListNode(stack.peek());
            ListNode ans  = pre;


            Integer pop = stack.pop();
            pre.val = pop;
            while(!stack.empty()){

                pre.next = new ListNode(stack.pop() );
                pre = pre.next;


            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // put your test code here
        ListNode head = ListNode.createHead(new int[]{1,2,3,4,5});
        ListNode.print(solution.reverseList(head));
        
    }
}