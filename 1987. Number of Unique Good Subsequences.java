class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int len = binary.length();
        int dp0 = 0, dp1 = 0, mod = 1000000007, has0 = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (binary.charAt(i) == '0') {
                has0 = 1;
                dp0 = (dp0 + dp1 + 1) % mod;
            } else {
                dp1 = (dp0 + dp1 + 1) % mod;
            }
        }
        return (dp1 + has0) % mod;
    }
}



/**


定义

因为我们关心子序列的 开头 是什么，所以我们这样定义：

dp[i][0]= 字符串 binary 的从 i 开始的子串中，以 0 开头的子序列的个数

dp[i][1]= 字符串 binary 的从 i 开始的子串中，以 1 开头的子序列的个数

状态转移

我们从后向前遍历字符串 binary 。

当 binary[i] == '0' 时，dp[i][0]的求解可以分成 3 个部分：(Qingdong's comment, 为何如此划分三个部分呢？似乎很显然第二部分是包括在第一部分里面的？)

第一部分：这个 '0' 可以添加到所有的子序列的前面，此部分共有 dp[i+1][0] + dp[i+1][1] 个不同的子序列；

第二部分：原有的 dp[i+1][1] 个以 00 开始的子序列，但是这部分不能增加到 dp[i][0] 中，因为这些序列肯定包含在第一部分和第三部分中，不能重复添加；

第三部分：单独的 1 个 0。

因此，dp[i][0]= 第一部分 + 第三部分 = dp[i+1][0] + dp[i+1][1] + 1。

然后，由于 binary[i] == '0'，故 dp[i][1] 不会发生变化，dp[i][1] = dp[i+1][1]。

当 binary[i] == '1' 时，同理可推

dp[i][1] = dp[i+1][0] + dp[i+1][1] + 1

dp[i][0] = dp[i+1][0]

最终答案

最终答案就是，全部以 1 开头的子序列的个数（也就是 dp[0][1]）+ 字符串 “0” （如果有）。

作者：newhar
链接：https://leetcode-cn.com/problems/number-of-unique-good-subsequences/solution/dong-tai-gui-hua-jing-dian-ti-mu-de-bian-n4h3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


**/
