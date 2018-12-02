/**
 * CircularlyLinkedList
 * 
 * Example implemented by Eoghan Hogan eoghan.hogan@ucdconnect.ie
 */
class CircularlyLinkedList<E> {

    // This class differs slightly from the original linked list class
    // instead of the tail in this class pointing to null it infavt points to

    // Nested Node Class Shared between all instances of parent
    private static class Node<E> {
        private E data; // Data stored in this node
        private Node<E> next; // reference to next node

        // node Constructor
        public Node(E data, Node<E> next) {
            this.next = next;
            this.data = data;
        }

        /**
         * @return the data
         */
        public E getData() {
            return data;
        }

        /**
         * @return the next
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> tail = null;

    private int size = 0;

    public CircularlyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getData();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getData();
    }

    public void rotate() {
        if (tail != null) {
            tail.getNext();
        }
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newNode = new Node<>(e, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.getNext());
        }
        size--;
        return head.getData();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "null";
        } else {
            int temp = tail.hashCode();
            String ret = "";

            Node<E> tempNode = tail;
            ret += tempNode.getData().toString() + " -> ";
            tempNode = tempNode.getNext();
            while (tempNode.hashCode() != temp) {
                ret += tempNode.getData().toString() + " -> ";
                tempNode = tempNode.getNext();
            }
            int retLen = ret.length();
            ret += "\n";
            ret += "^";
            for (int i = 0; i < retLen - 2; i++) {
                ret += "-";
            }
            ret += "^";

            return ret;

        }
    }
}

/**
 * CircularlyLinkedListExample
 */
public class CircularlyLinkedListExample {
    public static void main(String[] args) {
        System.out.println("running circularly linked list!");

        CircularlyLinkedList<String> cll = new CircularlyLinkedList<String>();
        System.out.println(cll.toString());
        cll.addFirst("LAX");
        System.out.println(cll.toString());
        cll.addFirst("MIA");
        System.out.println(cll.toString());
        cll.addFirst("JFK");
        System.out.println(cll.toString());
        cll.removeFirst();
        System.out.println(cll.toString());

    }

}