class Solution {
    private final int M = 1000000007;
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        Map<Integer, Integer> dp = new HashMap<>();
        
        return helper(s, 0, k, dp);
    }
    
    private int helper(String s, int start, int k, Map<Integer, Integer> dp) {
        if (start == s.length()) {
            return 1;
        }
   
        if (s.charAt(start) == '0') {
            return 0;
        }
        if (dp.containsKey(start)) {
            return dp.get(start);
        }
        long num = 0;
        int ans = 0;
        for (int j = start + 1; j <= s.length(); j++) {
            num = num * 10 + (s.charAt(j - 1) - '0');
            if (num > k) break;
            ans = (ans + (helper(s, j, k, dp)) % M) % M;
        }
        dp.put(start, ans);
        return ans;
    }
}
