class Solution {
    /***
    
    由于是循环数组，那么可能出现两种情况
    1. 这个subarray可能出现在头尾两端，那么可以通过 total - minSum得到
    2. 如果这个subarray出现在中间，那么按照非循环数组求解即得到答案
    
    综上两种情况，两个答案都算一下，返回较大值即可
    
    **/
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        //
        //
        int total = nums[0], sx = nums[0], sn = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i > 0) {
                total += num;
                sx += num;
                sn += num;
            }
            maxSum = Math.max(maxSum, sx);
            if (sx < 0) {
                sx = 0;
            }
            
            minSum = Math.min(minSum, sn);
            if (sn > 0) {
                sn = 0;
            }
        }
        //如果全部为负数，那么取最大的负数
        if (total == minSum) {
            return maxSum;
        }
        return Math.max(maxSum, total - minSum);
    }
}
