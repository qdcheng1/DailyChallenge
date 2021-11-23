class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
        /**
        如果n是偶数，那么中间的下标（右半边的开始位置）是n / 2 
        如n = 4，下标2是右半边的起始位置
        如n = 5, 下标3是右半边开始的位置（也就是前面小的部位多占一个位置，因为先排小的，所以小的多占一个是合理的）
        0 1 2 3 4
        */
        int left = (n + 1) / 2, right = n;
        Arrays.sort(copy);
        for (int i = 0; i < n; i++) {
            if ( i % 2 == 0) {
                nums[i] = copy[--left];
            } else {
                nums[i] = copy[--right];
            }
        }
    }
}
