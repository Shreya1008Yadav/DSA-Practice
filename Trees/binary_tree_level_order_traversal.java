/**
 * Problem: Binary Tree Level Order Traversal
 * Platform: LeetCode
 * Approach: BFS (Level Order Traversal using Queue)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    // Main function
    public List<List<Integer>> levelOrder(TreeNode root) {

        // List to store final result
        List<List<Integer>> result = new ArrayList<>();

        // If tree is empty
        if (root == null)
            return result;

        // Initialize queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level order traversal
        while (!queue.isEmpty()) {

            int size = queue.size();

            // List to store current level nodes
            List<Integer> curr = new ArrayList<>();

            // Traverse all nodes at current level
            for (int i = 0; i < size; i++) {

                TreeNode currNode = queue.poll();

                // Add current node value
                curr.add(currNode.val);

                // Add left child if exists
                if (currNode.left != null)
                    queue.offer(currNode.left);

                // Add right child if exists
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }

            // Add current level to result
            result.add(curr);
        }

        return result;
    }
}