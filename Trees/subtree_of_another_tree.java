/**
 * Problem: Subtree of Another Tree
 * Platform: LeetCode
 * Approach: DFS (Recursion - Tree Comparison)
 * Time Complexity: O(n * m)  // n = nodes in root, m = nodes in subRoot
 * Space Complexity: O(h)     // h = height of tree
 */

class Solution {

    // Main function
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If root is null, subtree cannot exist
        if (root == null)
            return false;

        // If trees match at current node, return true
        if (helper(root, subRoot))
            return true;

        // Otherwise, check in left or right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper function to check if two trees are identical
    public boolean helper(TreeNode t, TreeNode st) {

        // If either is null, both must be null to be equal
        if (t == null || st == null)
            return t == st;

        // Check:
        // 1. Values are equal
        // 2. Left subtrees match
        // 3. Right subtrees match
        return (t.val == st.val)
                && helper(t.left, st.left)
                && helper(t.right, st.right);
    }
}