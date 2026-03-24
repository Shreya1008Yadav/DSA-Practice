/**
 * Problem: Minimum Depth of Binary Tree
 * Platform: LeetCode
 * Approach: BFS (Level Order Traversal)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    // Main function
    public int minDepth(TreeNode root) {

        // If tree is empty
        if (root == null) return 0;

        // Initialize queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;

        // Perform level order traversal
        while (!queue.isEmpty()) {

            int size = queue.size();

            // Traverse all nodes at current level
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                // If it's a leaf node, return current depth
                if (node.left == null && node.right == null) {
                    return depth;
                }

                // Add left child if exists
                if (node.left != null) queue.offer(node.left);

                // Add right child if exists
                if (node.right != null) queue.offer(node.right);
            }

            // Increment depth after finishing current level
            depth++;
        }

        return depth;
    }
}