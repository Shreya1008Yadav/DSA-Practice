/**
 * Problem: Binary Tree Postorder Traversal
 * Platform: LeetCode
 * Approach: DFS (Recursion - Postorder)
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // h = height of tree
 */

class Solution {

    // List to store traversal result
    List<Integer> list = new ArrayList<>();

    // Main function
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return list;
    }

    // Helper function for postorder traversal
    public void helper(TreeNode node) {

        // Base case: if node is null
        if (node == null)
            return;

        // Traverse left subtree
        helper(node.left);

        // Traverse right subtree
        helper(node.right);

        // Visit current node
        list.add(node.val);
    }
}