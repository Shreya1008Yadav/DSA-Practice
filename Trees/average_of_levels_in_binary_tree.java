/**
 * Problem: Average of Levels in Binary Tree
 * Platform: LeetCode
 * Approach: BFS (Level Order Traversal)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    // Main function
    public List<Double> averageOfLevels(TreeNode root) {

        // List to store final result
        List<Double> result = new ArrayList<>();

        // If tree is empty
        if (root == null)
            return result;

        // Initialize queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level order traversal
        while (!queue.isEmpty()) {

            int size = queue.size();

            // Variable to store sum of current level
            double average = 0;

            // Traverse all nodes at current level
            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();

                // Add current node value
                average += curr.val;

                // Add left child if exists
                if (curr.left != null)
                    queue.offer(curr.left);

                // Add right child if exists
                if (curr.right != null)
                    queue.offer(curr.right);
            }

            // Calculate average of current level
            average = average / size;

            // Add to result
            result.add(average);
        }

        return result;
    }
}