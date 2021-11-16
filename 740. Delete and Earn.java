class Solution {
    //This question is quite similar to house robber question
    //you can not take two consecutive numbers at the same time, it is like you cannot robber two houses that are next to each other
    
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];
        for (int num : nums) {
            sum[num] += num;
        }
        int[][] dp = new int[10001][2];
        // 0 take
        int take = 0, skip = 0;
        for (int i = 1; i <= 10000; i++) {
            dp[i][0] = dp[i - 1][1] + sum[i];
            //int takei = skip + sum[i];
            //int skipi = Math.max(skip, take);
            //take = takei;
            //skip = skipi;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        
        return Math.max(dp[10000][0], dp[10000][1]);
    }
}
