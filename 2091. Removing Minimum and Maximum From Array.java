class Solution {
    public int minimumDeletions(int[] nums) {
        int mx = Integer.MIN_VALUE, mxIdx = 0, mn = 100001, mnIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > mx) {
                mx = num;
                mxIdx = i;
            }
            if (num < mn) {
                mn = num;
                mnIdx = i;
            }
        }
        if (mx == mn) {
            return 1;
        }
        int n = nums.length;
        int left = 0, right = 0;
        if (mnIdx < mxIdx) {
            left = mnIdx;
            right = mxIdx;
        } else {
            left = mxIdx;
            right = mnIdx;
        }
        int res = 0;
        if (left < (n - right)) {
            res += left + 1;
            if (right - left < n - right) {
                res += (right - left);
            } else {
                res += (n - right);
            }
            
        } else {
            res += (n - right);
            if (left < right - 1 - left) {
                res += left + 1;
            } else {
                res += right - left ;
            }
            
        }
//         // xxxabxxxxxxxxxxxxxxx
//         if ( mxIdx < n - 1 - mxIdx && mnIdx < n - 1 - mnIdx) {
//             return Math.max(mnIdx, mxIdx) + 1;
//         }
//         if ( mxIdx > n - 1 - mxIdx && mnIdx > n - 1 - mnIdx) {
//             return n - Math.min(mxIdx, mnIdx);
//         }
        
//         return Math.min(mxIdx, mnIdx) + 1 + n - Math.max(mxIdx, mnIdx);
        
        return res;
    }
}
