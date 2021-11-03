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

    public String toString() {
        return String.valueOf(data);
    }

}
