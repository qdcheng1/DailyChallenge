class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] fm = new int[26];
        for (char c : word1.toCharArray()) {
            fm[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            fm[c - 'a']--;
        }
        for (int cnt : fm) {
            //corner case: if the cnt is negative
            if (Math.abs(cnt) > 3) {
                return false;
            }
        }
        return true;
    }
}
