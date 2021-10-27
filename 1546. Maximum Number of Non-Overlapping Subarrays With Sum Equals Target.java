class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        //presum
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] dp = new int[n + 1];
        //key is presum of i (sum of (0 ... i)), value is index i
        Map<Integer, Integer> presumIdx = new HashMap<>();
        presumIdx.put(0, 0);
        
        for (int i = 1; i <= n; i++) {
            //nums[i] not included in the subarray
            dp[i] = dp[i - 1];
            // if there is a key == sum[i] - target, its value is j
            // means that sum[i] - sum[j] = target
            if (presumIdx.containsKey(sum[i] - target)) {
                int j = presumIdx.get(sum[i] - target);
                //get bigger dp
                dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
           presumIdx.put(sum[i], i);
        }
        return dp[n];
    }
}
