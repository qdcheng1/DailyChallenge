class Solution {
    private final long M = 1000000007;
    public int checkRecord(int n) {
        long[] dp = new long[n <= 3 ? 4 : n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((2 * dp[i - 1]) % M + (M - dp[i - 4])) % M;
        }
        long sum = dp[n];
        for (int i = 1; i <= n; i++) {
            sum += (dp[i - 1] * dp[n - i]) % M;
        }
        return (int)(sum % M);
    }
}

/**

DP
f[i] = number of possible award strings with length i, without considering character 'A'

dp[i] = total number of rewardable student records with i len
1. without A
1) end with P
dp[i] = dp[i - 1]
2) end with L
...PLLL
如果只有一个L，那应该是dp[i - 1],但是还包括了上面的三个L的不合法的情况，需要去掉，这个数量是dp[i - 4]
因为最长肯定是三个L，又因为我们不考虑A的情况，所以三个L前面是P，所以不合法的情况是PLLL结尾的，这种情况的数量是1 * dp[i - 4] = dp[i - 4]
dp[i] = dp[i - 1] - dp[i - 4];
2. with A
Assume A is in index i
[... i - 1] A [i + 1, ....n]
dp[i - 1] * dp[n - i]

class Solution {
    long M = 1000000007;
    public int checkRecord(int n) {
        long[] f = new long[n <= 3 ? 4 : n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;
        for (int i = 4; i <= n; i++)
            f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M;
        long sum = f[n]; // total number without 'A'
        // calculate the total with A present in each index
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return (int)(sum % M);
    }
}

**/
