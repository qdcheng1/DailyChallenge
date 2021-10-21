class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp = new long[201][101];
        dp[fuel][start] = 1;
        int n = locations.length;
        long M = 1000000007;
        for (int f = fuel; f >= 0; f--) {
            for (int c = 0; c < n; c++) {
                for (int d = 0; d < n; d++) {
                    if (d == c) continue;
                    int gas = Math.abs(locations[d] - locations[c]);
                    if (f + gas <= fuel) {
                        dp[f][c] = (dp[f][c] + dp[f + gas][d]) % M;
                    }
                }
            }
        }
        long res = 0;
        for (int f = 0; f <= fuel; f++) {
            res = (res + dp[f][finish]) % M;
        }
        return (int)res;
    }
}


/**

Time complexity: O(f * n * n), where f is amount of fuel, and n is length of locations
Space complexity: O(f * n)


There is a better solution with time complexity O(f*n)


**/
