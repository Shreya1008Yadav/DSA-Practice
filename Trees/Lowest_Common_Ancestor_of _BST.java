class Solution {

    // Find LCA of p and q
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {

        // Empty tree
        if (root == null)
            return null;

        // Both nodes are in left subtree
        if (p.val < root.val && q.val < root.val)
            return find(root.left, p, q);

        // Both nodes are in right subtree
        if (p.val > root.val && q.val > root.val)
            return find(root.right, p, q);

        // Nodes are on different sides or one is root
        return root;
    }
}