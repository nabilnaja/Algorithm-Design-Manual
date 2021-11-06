package chapter3.exercise7;

import dt.Node;

public class Exercise7 {

    public static void deleteNode(Node node){
        if (node == null)
            return;
        if (node.next == null){
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
