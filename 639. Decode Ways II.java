class Solution {
    private final long MOD = 1000000007;
    public int numDecodings(String s) {
        int len = s.length();
        long[] dp = new long[len + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        for (int i = 2; i <= len; i++) {
            char cur = s.charAt(i - 1);
            char pre = s.charAt(i - 2);
            if (cur == '0') {
                if (pre == '1' || pre == '2') {
                    dp[i] = dp[i - 2];
                } else if (pre == '*') { //如果前面是星，可以是两倍，组成10或者20
                    dp[i] = 2 * dp[i - 2];
                } else {
                    return 0;
                }
            } else if (cur >= '1' && cur <= '9') { //如果当前是1 - 9，至少和前的相等
                dp[i] = dp[i - 1];
                //如果可以联合起来组成两位数，那么再加上前面的可能性
                if (pre == '1' || (pre == '2' && cur <= '6')) {
                    dp[i] += dp[i - 2];
                } else if (pre == '*') { //如果前面是*，现在是小于等于6，再加两倍（前面可以是1或2）,否则前面只能是1，则再加1倍
                    dp[i] += (cur <= '6') ? (2 * dp[i - 2]) : dp[i - 2];
                }
            } else { // cur is '*'
                //无论前面是什么，当前的cur就有九种变化
                dp[i] = 9 * dp[i - 1];
                //如果还可以和前面的组合在一起就会有更多的变化，
                if (pre == '1') { //如果前面的是1，再多9倍
                    dp[i] += 9 * dp[i - 2];
                } else if (pre == '2') { //如果前面的2，再多6倍
                    dp[i] += 6 * dp[i - 2];
                } else if (pre == '*') { //如果前面也是*，再来15倍
                    dp[i] += 15 * dp[i - 2];
                }
            }
            dp[i] %= MOD;
        }
        
        return (int)dp[len];
    }
}
