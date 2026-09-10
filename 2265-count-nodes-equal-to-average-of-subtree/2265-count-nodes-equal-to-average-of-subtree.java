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
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }

    private void helper(TreeNode root){
        if (root==null) return;

        int n=countNodes(root);
        int s=treeSum(root);

        if (Math.round(s/n)==root.val) count++;

        helper(root.left);
        helper(root.right);

        return;
    }

    private int countNodes(TreeNode root){
        if (root==null) return 0;

        int left=countNodes(root.left);
        int right=countNodes(root.right);

        return 1+left+right;
    }

    private int treeSum(TreeNode root){
        if (root==null) return 0;

        int left=treeSum(root.left);
        int right=treeSum(root.right);

        return root.val+left+right;
    }
}