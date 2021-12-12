/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

// solution 1, only return head

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node p = head;
        while (p != null) {
            if (p.child != null) {
                Node remain = p.next;
                Node childHead = flatten(p.child);
                Node ch = childHead;
                while (ch != null && ch.next != null) {
                    ch = ch.next;
                }
                p.next = childHead;
                childHead.prev = p;
                p.child = null;
                ch.next = remain;
                if (remain != null) {
                     remain.prev = ch;
                }
               
                p = remain;
            } else {
                p = p.next;
            }
        }
        
        return head;
    }
}

// solution 2, return head and tail

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node[] res = helper(head);
        return res[0];
    }
    
    private Node[] helper(Node head) {
        Node[] res = new Node[2];
        // if (head == null) {
        //     return res;
        // }
        Node p = head;
        Node prev = null;
        while (p != null) {
            prev = p;
            if (p.child != null) {
                Node remain = p.next;
                Node[] headtail = helper(p.child);
                Node ch= headtail[0];
                Node ct = headtail[1];
                p.next = ch;
                ch.prev = p;
                p.child = null;
                ct.next = remain;
                if (remain != null) {
                     remain.prev = ct;
                } else {
                    prev = ct;
                }
                p = remain;
            } else {
                p = p.next;
            }
        }
        res[0] = head;
        res[1] = prev;
        return res;
    }
}
