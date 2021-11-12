class Solution {
  //这种匹配括号的，都首先考虑stack
  
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = '?';
                }
            }
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = '?';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') continue;
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
