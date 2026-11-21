package leetcode.editor;

import leetcode.editor.cn.LRUCache;
import leetcode.editor.cn.Solution;
import leetcode.editor.common.ListNode;

/**
 * @author vizhi
 * 描述 :
 * @create 2026-11-19 16:22
 */
public class main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

// 串起来：1 -> 2 -> 3 -> 4 -> 5
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

// head 就是第一个数据节点
        ListNode head = n1;

        Solution solution = new Solution();
        ListNode ans = solution.reverseKGroup(head,2);





    }
}
