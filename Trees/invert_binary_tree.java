/**
 * Problem: Invert Binary Tree
 * Platform: LeetCode
 * Approach: DFS (Recursion)
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // h = height of tree
 */

class Solution {

    // Main function
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    // Helper function using DFS
    public void helper(TreeNode node) {

        // Base case: if node is null
        if (node == null) {
            return;
        }

        // Swap left and right child
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively invert left and right subtrees
        helper(node.left);
        helper(node.right);
    }
}