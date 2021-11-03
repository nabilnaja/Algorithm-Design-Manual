package dt;

public class Node {

    public int data;
    public Node next;


    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this(data, null);
    }

    public static void printList(Node n) {
        int i = 0;
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println("NULL");
    }

    public static Node buildList(int[] a) {
        if (a == null || a.length == 0) return null;
        Node n = new Node(a[0]);
        Node head = n;
        for (int i = 1; i < a.length; ++i) {
            n.next = new Node(a[i]);
            n = n.next;
        }
        return head;
    }

    public static boolean compareLinkedList(Node n1, Node n2) {
        //Node.printList(n1);
        //Node.printList(n2);
        Node prev1 = n1;
        Node prev2 = n2;
        while (prev1.next != null && prev2.next != null) {
            if (n1.data != n2.data)
                return false;
            prev1 = prev1.next;
            prev2 = prev2.next;
        }
        return (prev1.next == null && prev2.next == null);
    }

    public String toString() {
        return String.valueOf(data);
    }

}
