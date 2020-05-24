/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 * The values of preorder are distinct.
 */
class TreeNode {
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

class Index {
    int index = 0;
}

public class Day24_BSTFromPreOrderTraversal {

    Index index = new Index();
    
    public TreeNode bstFromPreorder(int[] pre) {
        return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, pre.length);
    }
    
    public TreeNode constructTreeUtil(int[] pre, Index preIndex, int key, int min, int max, int size) {
    
        if (preIndex.index >=size)
            return null;
        
        TreeNode root = null;
        
        if (key > min  && key < max) {
    
            root = new TreeNode(key);
            preIndex.index = preIndex.index + 1;
            
            if (preIndex.index < size) {
                root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
            }
            
            if (preIndex.index < size) {
                root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
            }
        }
        
        return root;
    }
}