package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BinaryTreeInorderTraversal {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        List<Integer> ans = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {


            if(root == null){
                return ans;
            }

            inorderTraversal(root.left);
            ans.add(root.val);
            inorderTraversal(root.right);

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        // put your test code here
        TreeNode tree = new TreeNode();
        solution.inorderTraversal(tree);

        
    }
}