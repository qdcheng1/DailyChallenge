class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        /***
        
        dp[i][j] min # of ops with j operations from nums[0...i]
        
        **/
        
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE/2;
            }
        }
        
        int mx = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            sum += nums[i];
            dp[i][0] = mx * (i + 1) - sum;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                int max = 0;
                int intervalSum = 0;
                //如果s...i直接只调整了一次size，那么可能是在i或者之前就调整了的，这个坐标是s
                for (int s = i; (s >= j - 1) && (s >= 1); s--) {
                    max = Math.max(max, nums[s]);
                    intervalSum += nums[s];
                    dp[i][j] = Math.min(dp[i][j], dp[s-1][j-1] + max * (i - s + 1) - intervalSum);
                }
            }
        }
        
        return dp[n - 1][Math.min(k, n)];
    }
}
