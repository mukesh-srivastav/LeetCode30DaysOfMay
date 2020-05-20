/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class Day20_KthSmallestElementinBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans, n;
    public int kthSmallest(TreeNode root, int k) {
        n = k;
        traverse(root);
        return ans;
    }
    
    void traverse(TreeNode root) {
        if (root == null)
            return;
        
        if (root.left != null)
            traverse(root.left);
        
        if (--n == 0) {
            ans = root.val;
            return;
        }
        
        if (root.right != null)
            traverse(root.right);
    }
}