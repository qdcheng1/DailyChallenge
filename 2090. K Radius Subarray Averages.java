class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        long sum = 0;
        if (k * 2 + 1 > n) {
            return res;
        }
        for (int i = 0; i < k * 2 + 1; i++) {
            sum += nums[i];
        }
        res[k] = (int)(sum / (k * 2 + 1));
        for (int i = k + 1; i + k < n; i++) {
            sum -= nums[i - k - 1];
            sum += nums[i + k];
            res[i] = (int)(sum / (k * 2 + 1));
        }
        return res;
    }
}
