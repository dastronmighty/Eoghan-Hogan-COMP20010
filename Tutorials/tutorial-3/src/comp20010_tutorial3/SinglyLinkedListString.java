
public class SinglyLinkedListString {

    private static class Node {
        private String data;
        private Node next;

        public Node(String e, Node n) {
            this.data = e;
            this.next = n;
        }

        public String getData() {
            return data;
        }

        public Node getNode() {
            return next;
        }
    }

    private Node head = null;
    private int size = 0;

    public SinglyLinkedListString() {

    }

    public int size() {
        // TODO
    }

    public boolean isEmpty() {
        // TODO
    }

    public Node first() {
        // TODO
    }

    public Node last() {
        // TODO
    }

    public void addFirst(String data) {
        // TODO
    }

    public void addLast(String data) {
        // TODO
    }

    public String removeFirst() {
        // TODO
    }

    public String removeLast() {
        // TODO
    }

    public String toString() {

    }

    public static void main(String[] args) {
        SinglyLinkedListString ll = new SinglyLinkedListString();
        ll.addLast("Java");
        ll.addLast("C++");
        ll.addLast("Python");
        ll.addLast("Scala");
        System.out.println(ll);
    }
}