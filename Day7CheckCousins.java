/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
 */
public class Day7CheckCousins {

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

    int lD = -1, rD = -1;
    TreeNode lP, rP, prev;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.lD = 0;
        this.rD = 0;
        
        dfs(root, x, y, 0);
        
        return ((lD == rD) && (lP != rP));
    }
    
    public void dfs(TreeNode root, int x, int y, int depth) {
        if (root==null)
            return;
        if (root.val == x) {
            lP = prev;
            lD = depth;
            return;
        } else if (root.val == y) {
            rP = prev;
            rD = depth;
            return;
        }
        
        prev = root;
        dfs(root.left, x, y, depth + 1);
        dfs(root.right, x, y, depth + 1);
        
    }
}