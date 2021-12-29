/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            //当前节点是要被删除的节点
            
            //如果右边为空，返回左子树
            if (root.right == null) {
                return root.left;
            }
            //右边不为空，找到右边的最左节点
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            //把root的左子树接在root右子树最左节点的左边
            //返回root的右子树
            cur.left = root.left;
            return root.right;
        }
        return root;
    }
}
