/**
 * Problem: Symmetric Tree
 * Platform: LeetCode
 * Approach: DFS (Recursion - Mirror Comparison)
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // h = height of tree
 */

class Solution {

    // Main function
    public boolean isSymmetric(TreeNode root) {

        // If tree is empty, it is symmetric
        if (root == null)
            return true;

        // Check symmetry between left and right subtree
        return helper(root.left, root.right);
    }

    // Helper function to compare two subtrees
    public boolean helper(TreeNode t1, TreeNode t2) {

        // Case 1: both nodes are null
        if (t1 == null && t2 == null)
            return true;

        // Case 2: one is null, the other is not
        if (t1 == null || t2 == null)
            return false;

        // Check:
        // 1. Values are equal
        // 2. Left of t1 matches right of t2
        // 3. Right of t1 matches left of t2
        return t1.val == t2.val && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}