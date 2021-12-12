class Solution {
    class Node {
        char c;
        int count;
        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                Node top = stack.peekLast();
                if (top.c == c) {
                    top.count++;
                } else {
                    Node node = new Node(c, 1);
                    stack.offerLast(node);
                }
            } else {
                Node node = new Node(c, 1);
                stack.offerLast(node);
            }
            
            Node t = stack.peekLast();
            if (t.count == k) {
                stack.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node n = stack.pollFirst();
            for (int i = 0; i < n.count; i++) {
                sb.append(n.c);
            }
        }
        return sb.toString();
    }
}
