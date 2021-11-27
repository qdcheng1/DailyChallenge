class Solution {
    long maxScore = 0;
    int count = 0;
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) { // skip 0, root has no parent
            tree.get(parents[i]).add(i);
        }
        dfs(0, tree, n);
        
        return count;
    }
    
    private int dfs(int node, List<List<Integer>> tree, int n) {
        int total = 0;
        long prod = 1l, rem, val;
        
        for (int nei : tree.get(node)) {
            val = dfs(nei, tree, n);
            total += val;
            prod *= val;
        }
        rem = n - total - 1;
        
        if (rem > 0) {
            prod *= rem;
        }
        
        if (prod > maxScore) {
            maxScore = prod;
            count = 1;
        } else if (prod == maxScore) {
            count++;
        }
        return total + 1;
    }
}
