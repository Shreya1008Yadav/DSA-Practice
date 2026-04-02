/**
 * Problem: Diameter of Binary Tree
 * Platform: LeetCode
 * Approach: DFS (Recursion - Height Calculation)
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // h = height of tree
 */

class Solution {

    // Variable to store maximum diameter
    int diameter;

    // Main function
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    // Helper function to calculate height
    public int height(TreeNode node) {

        // Base case: if node is null
        if (node == null)
            return 0;

        // Recursively find height of left and right subtree
        int left = height(node.left);
        int right = height(node.right);

        // Diameter at current node = left height + right height
        int dia = left + right;

        // Update global diameter
        diameter = Math.max(dia, diameter);

        // Return height of current node
        return Math.max(left, right) + 1;
    }
}