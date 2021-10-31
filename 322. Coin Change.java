class Solution {
    public int coinChange(int[] coins, int amount) {
        /* dp[amount] = Math.min(dp[amount - coin] + 1); */
         if (amount == 0) {
             return 0;
         }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
         for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
         }
         return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
