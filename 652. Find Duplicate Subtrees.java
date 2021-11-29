class Solution {
  
    //it is similar to serialize the binary tree
  
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> serMap = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        dfs(root, serMap, res);
        return res;
    }
    
    private String dfs(TreeNode root, Map<String, Integer> serMap, List<TreeNode> res) {
        if (root == null) {
            return "#";
        }
        //
        String cur = dfs(root.left, serMap, res) + "," + dfs(root.right, serMap, res) + "," + root.val;
        
        if (serMap.getOrDefault(cur, 0) == 1) {
            res.add(root);
        }
        
        serMap.put(cur, serMap.getOrDefault(cur, 0) + 1);
        
        return cur;
    }
}
