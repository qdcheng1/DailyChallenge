class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n];
        int[] len = new int[n];
        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);
        int mx = 0;
        int res = 0;
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                if (len[i] == len[j] + 1) {
                    cnt[i] += cnt[j];
                } else if (len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    cnt[i] = cnt[j];
                }
            }
            if (len[i] == mx) {
                res += cnt[i];
            } else if (mx < len[i]) {
                mx = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}


/**
这个比求最长lis的题不一样，需要多一个数组来记录某个lis长度的组合数



**/
