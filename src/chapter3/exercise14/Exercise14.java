package chapter3.exercise14;

import dt.DoubleLinkedListNode;
import dt.TreeNode;

public class Exercise14 {

    private static DoubleLinkedListNode doubleLinkedList;
    private static DoubleLinkedListNode prev;
    private static DoubleLinkedListNode head;

    public Exercise14() {


    }

    public static DoubleLinkedListNode toLinkedList(TreeNode root) {
        doubleLinkedList = new DoubleLinkedListNode(0, null, null);
        head = doubleLinkedList;
        prev = null;
        if (root == null)
            return null;
        toLinkedListHelper(root);
        return doubleLinkedList.next;
    }

    public static void toLinkedListHelper(TreeNode root) {
        if (root == null)
            return;
        toLinkedListHelper(root.left);
        final DoubleLinkedListNode node = new DoubleLinkedListNode(root.val, prev, null);
        head.next = node;
        head = head.next;
        prev = node;
        toLinkedListHelper(root.right);
    }

    // todo to refactor and clean
    public static DoubleLinkedListNode mergeLinkedList(DoubleLinkedListNode first, DoubleLinkedListNode second) {
        doubleLinkedList = new DoubleLinkedListNode(0, null, null);
        DoubleLinkedListNode head = doubleLinkedList;
        DoubleLinkedListNode prev = null;

        if (first == null && second == null) {
            return null;
        }
        if (first == null)
            return second;
        if (second == null)
            return first;

        while (first != null && second != null) {
            final DoubleLinkedListNode node = new DoubleLinkedListNode(0, prev, null);
            if (first.val < second.val){
                node.val = first.val;
                head.next = node;
                head = head.next;
                first = first.next;
                prev = node;

            }
            else{
                node.val = second.val;
                head.next = node;
                head = head.next;
                second = second.next;
                prev = node;
            }
        }
        if (second != null){
            second.prev = head;
            head.next = second;
        }
        if (first != null){
            first.prev = head;
            head.next = first;
        }
        return doubleLinkedList.next;
    }
}
