/**
 * Problem: Maximum Depth of Binary Tree
 * Platform: LeetCode
 * Approach: DFS (Recursion)
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // h = height of tree
 */

class Solution {

    // Main function
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    // Helper function using DFS
    public int helper(TreeNode node) {

        // Base case: if node is null
        if (node == null) {
            return 0;
        }

        // Recursively find depth of left and right subtree
        int left = helper(node.left);
        int right = helper(node.right);

        // Return max depth
        return 1 + Math.max(left, right);
    }
}