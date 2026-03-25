/**
 * Problem: Binary Tree Inorder Traversal
 * Platform: LeetCode
 * Approach: DFS (Recursion - Inorder)
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // h = height of tree
 */

class Solution {

    // List to store traversal result
    List<Integer> result = new ArrayList<>();

    // Main function
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }

    // Helper function for inorder traversal
    public void inorder(TreeNode node) {

        // Base case: if node is null
        if (node == null)
            return;

        // Traverse left subtree
        inorder(node.left);

        // Visit current node
        result.add(node.val);

        // Traverse right subtree
        inorder(node.right);
    }
}