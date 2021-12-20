class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        int i = 0, len = prices.length;
        // 3 2 1, 3 + 2 + 1
        while (i < len) {
            int j = i + 1;
            while (j < len && prices[j] - prices[j - 1] == -1) {
                j++;
            }
            res += ((long)j - (long)i + 1) * ((long)j - (long)i) / 2l;
            i = j;
        }
        return res;
    }
}
