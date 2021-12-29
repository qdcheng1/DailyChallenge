/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  
  /*
  
  单调栈问题，大体思想是保存一个单调递减栈，如果新来的元素比栈顶的元素大，那么就说明这个新来的元素是栈顶元素的next larger node，可以将栈顶元素出栈
  直到栈为空或者当前元素比栈顶元素 小或者相等
  
  
  */
  
    public int[] nextLargerNodes(ListNode head) {
        int n = getLen(head);
        int[] res = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        int index = 0;
        while (head != null) {
            while (!stack.isEmpty() && stack.peekLast()[0] < head.val) {
                int[] top = stack.pollLast();
                res[top[1]] = head.val;
            }
            stack.offerLast(new int[] {head.val, index});
            index++;
            head = head.next;
        }
        return res;
    }
    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
