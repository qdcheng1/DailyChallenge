class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //null check
        
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[stack.peekLast()] < nums2[i]) {
                stack.pollLast();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peekLast()]);
            stack.offerLast(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
        
    }
}
