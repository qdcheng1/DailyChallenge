class Solution {
    
    int max = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max == 0 ? 0 : max - 1;
    }
    
    private int[] helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        int[] l = helper(root.left);
        int[] r = helper(root.right);
        
        int cur = 1, mx = 0;
        if (l != null && l[0] == root.val) {
            cur += l[1];
            mx = Math.max(mx, l[1]);
        }
        if (r != null && r[0] == root.val) {
            cur += r[1];
            mx = Math.max(mx, r[1]);
        }
        
        if (cur > max) {
            max = cur;
        }
        return new int[]{root.val, mx + 1};
    }
}
