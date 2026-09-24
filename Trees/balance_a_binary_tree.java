class Solution {

    public TreeNode balanceBST(TreeNode root) {

        // Store all nodes in sorted order using inorder traversal.
        // In a BST, inorder traversal gives nodes in ascending order.
        List<TreeNode> list = new ArrayList<>();

        inorder(root, list);

        // Build a balanced BST by choosing the middle node
        // as the root recursively.
        return build(list, 0, list.size() - 1);
    }

    // Inorder traversal: Left -> Root -> Right
    // This gives us the BST nodes in sorted order.
    private void inorder(TreeNode node, List<TreeNode> list) {

        // Base case: no node to process.
        if (node == null) {
            return;
        }

        // Visit left subtree.
        inorder(node.left, list);

        // Store the current node.
        list.add(node);

        // Visit right subtree.
        inorder(node.right, list);
    }

    // Builds a balanced BST from the nodes between
    // index 'left' and 'right'.
    private TreeNode build(List<TreeNode> list, int left, int right) {

        // No elements left in this range.
        if (left > right) {
            return null;
        }

        // Choose the middle element as the root.
        // This keeps the left and right subtrees approximately equal.
        int mid = left + (right - left) / 2;

        TreeNode root = list.get(mid);

        // Recursively build the left subtree
        // using elements before the middle.
        root.left = build(list, left, mid - 1);

        // Recursively build the right subtree
        // using elements after the middle.
        root.right = build(list, mid + 1, right);

        return root;
    }
}
```
