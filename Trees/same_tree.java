/**
 * Problem: Same Tree
 * Platform: LeetCode
 * Approach: DFS (Recursion)
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // h = height of tree
 */

class Solution {

    // Main function
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }

    // Helper function using DFS
    public boolean helper(TreeNode p, TreeNode q) {

        // Case 1: if both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // Case 2: if one is null and the other is not
        if (p == null || q == null) {
            return false;
        }

        // Case 3: if values don't match
        if (p.val != q.val) {
            return false;
        }

        // Recursively check left and right subtrees
        boolean left = helper(p.left, q.left);
        boolean right = helper(p.right, q.right);

        return left && right;
    }
}