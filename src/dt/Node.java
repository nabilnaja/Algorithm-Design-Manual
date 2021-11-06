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

    public static Node getNodeAt(Node head, int position) {
        Node node = head;
        for (int i = 0; i < position; i++) {
            if (node != null)
                node = node.next;
            else
                return null;
        }
        return node;
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
        Node.printList(n1);
        Node.printList(n2);
        Node a = n1, b = n2;
        while (a != null && b != null)
        {
            if (a.data != b.data)
                return false;
            a = a.next;
            b = b.next;
        }
        return (a == null && b == null);
    }

    public String toString() {
        return String.valueOf(data);
    }

}
