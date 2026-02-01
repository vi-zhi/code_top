package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class BinaryTreeLevelOrderTraversal {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            if(root == null){
                return ans;
            }

            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> path = new ArrayList<>();

                for(int i = 0 ; i < size ; i++){
                    TreeNode poll = queue.poll();
                    path.add(poll.val);

                    if(poll.left != null){
                        queue.offer(poll.left);
                    }
                    if(poll.right != null){
                        queue.offer(poll.right);
                    }
                }
                ans.add(new ArrayList<>(path));
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        // put your test code here
        TreeNode treeNode = new TreeNode(3 , new TreeNode(9 , null , null),new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7,null,null)));
        solution.levelOrder(treeNode);
    }
}