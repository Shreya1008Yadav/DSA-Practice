/**
 * Problem: Binary Tree Preorder Traversal
 * Platform: LeetCode
 * Approach: DFS (Recursion - Preorder)
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // h = height of tree
 */

class Solution {

    // List to store traversal result
    List<Integer> list = new ArrayList<>();

    // Main function
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return list;
    }

    // Helper function for preorder traversal
    public void helper(TreeNode node) {

        // Base case: if node is null
        if (node == null)
            return;

        // Visit current node
        list.add(node.val);

        // Traverse left subtree
        helper(node.left);

        // Traverse right subtree
        helper(node.right);
    }
}