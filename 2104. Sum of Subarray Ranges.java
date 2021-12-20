class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long[][][] dp = new long[n][n][2];
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long mx = -1000000001l, mn = 1000000001l;
                if (j == i + 1) {
                    mx = Math.max(nums[j], nums[i]);
                    mn = Math.min(nums[i], nums[j]);
                } else {
                    mx = Math.max(dp[i][j - 1][0], nums[j]);
                    mn = Math.min(dp[i][j - 1][1], nums[j]);
                }
                //System.out.println(mx + " " + mn);
                dp[i][j][0] = mx;
                dp[i][j][1] = mn;
                res += mx - mn;
            }
        }
        return res;
    }
}
