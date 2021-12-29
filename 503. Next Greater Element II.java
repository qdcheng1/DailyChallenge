class Solution {
    /*
    
    循环数组的处理方式，把下标乘以2，比如n - 1 变成 n * 2 - 1, 取数据的时候取余 => %n
    
    */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i % n]) {
                stack.pollLast();
            }
            res[i % n] = stack.isEmpty() ? -1 : nums[stack.peekLast()];
            stack.offerLast(i % n);
        }
        return res;
    }
}
