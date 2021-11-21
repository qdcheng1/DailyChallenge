class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int frequency = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, frequency);
        }
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        int[] res = new int[k];
        for (int i = buckets.length - 1, j = 0; i >= 0 && j < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res[j++] = num;
                }
            }
        }
        return res;
    }
}
