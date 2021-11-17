class Solution {
    public int jump(int[] nums) {
      
        int step = 0;
        int n = nums.length;
        int mx = 0;
        int cur = 0;
        //greedy方法，注意结束条件，因为题目说明一定会有解，所以最后一个下标不需要遍历
        for (int i = 0; i < n - 1; i++) {
            mx = Math.max(mx, i + nums[i]);
            if (i == cur) { //当i等于cur的时候，说明上一步走的最远的地方已经到了，需要再走一步
                cur = mx;
                step++;
            }
        }
        
        return step;
        /*
        动态规划需要n^2时间复杂度
        dp[i] = Math.min(dp[j] + 1, dp[i]) 
        
        **/
//         int[] dp = new int[n];
//         Arrays.fill(dp, n + 1);
//         dp[0] = 0;
        
//         for (int i = 1; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (j + nums[j] < i) {
//                     continue;
//                 }
//                 dp[i] = Math.min(dp[i], dp[j] + 1);
//             }
//         }
//         return dp[n - 1];
    }
}
