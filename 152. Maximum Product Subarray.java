class Solution {
    public int maxProduct(int[] nums) {
        int mx = nums[0], mn = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            //注意保存中间状态，在下面的计算的过程中mx会更新，在计算mn的时候需要用更新前的值
            int max = mx;
            int min = mn;
            mx = Math.max(max * cur, Math.max(cur, min * cur));
            mn = Math.min(max * cur, Math.min(cur, min * cur));
            res = Math.max(res, mx);
        }
        return res;
    }
}
