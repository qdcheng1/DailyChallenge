class Solution {
    //从两头开始匹配
    //遇到不匹配的字符，尝试删除左边或者右边的（因为最多只能删除一个字符，如果最多可以删除k个字符呢？）
    
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        int left = 0, right = len - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return check(s, left + 1, right) || check(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
    
    boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
