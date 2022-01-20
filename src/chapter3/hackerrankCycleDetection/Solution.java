package chapter3.hackerrankCycleDetection;

import dt.Node;

public class Solution {
    Node fast;
    Node slow;
    public boolean hasCycle(Node head) {
        slow = head;
        fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;

    }
}