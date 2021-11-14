class Solution {
    //  0  1  2  3
    // [1, 3, 5, 6]
    // left = 3
    // right = 3
    // mid = 3
    // target = 7
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        //如果插入的位置在数组的后面，即所有的数的后面，需要特别处理
        if (nums[left] >= target) {
            return left;
        }
        return left + 1;
    }
}
