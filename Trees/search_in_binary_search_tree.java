/**
 * Problem: Search in a Binary Search Tree
 * Platform: LeetCode
 * Approach: DFS (Recursion using BST property)
 * Time Complexity: O(h)  // h = height of tree
 * Space Complexity: O(h)
 */

class Solution {

    // Main function
    public TreeNode searchBST(TreeNode root, int val) {

        // Base case: if node is null
        if (root == null)
            return null;

        // If value is found, return the node
        if (root.val == val)
            return root;

        // If target is smaller, search in left subtree
        else if (root.val > val)
            return searchBST(root.left, val);

        // If target is greater, search in right subtree
        else
            return searchBST(root.right, val);
    }
}