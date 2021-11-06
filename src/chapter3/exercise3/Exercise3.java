package chapter3.exercise3;

import dt.Node;

public class Exercise3 {

    public static Node reverseLinkedListIterative(Node head){
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        Node current = head;
        Node past = null;
        Node next;
        while (current != null){
            next = current.next;
            current.next = past;
            past = current;
            current = next;
        }
        return past;
    }

    public static Node reverseLinkedListRecursive(Node node){
        // when the linked list is null
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        final Node second = node.next;
        node.next = null;
        final Node reversedHead = reverseLinkedListRecursive(second);
        second.next = node;
        return reversedHead;
    }
}
