package chapter3.exercise3;

import dt.Node;

public class Exercise3 {

    public static Node reverseLinkedList(Node head){
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
}
