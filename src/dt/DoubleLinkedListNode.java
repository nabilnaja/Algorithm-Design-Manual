package dt;

public class DoubleLinkedListNode {
    public int val;
    public DoubleLinkedListNode prev;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode() {
    }
    public DoubleLinkedListNode(int val, DoubleLinkedListNode prev, DoubleLinkedListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
