class Solution {
    
    /*
    
    找规律
    
    f(i) = f(i - 1) + sum(nums) - n * nums[n - i]
    
    */
    public int maxRotateFunction(int[] nums) {
        
        
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        int f0 = 0;
        for (int i = 0; i < n; i++) {
            f0 += nums[i] * i;
        }
        int res = f0;
        for (int i = 1; i < n; i++) {
            int fi = f0 + sum - n * nums[n - i];
            f0 = fi;
            res = Math.max(res, fi);
        }
        return res;
    }
}
