
class SinglyLinkedList<E> {

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

    private int size = 0; // the amount of elements in the list
    private Node<E> head = null; // the head node of the list
    private Node<E> tail = null; // the tail node of the list

    public SinglyLinkedList() {
    }

    /**
     * @return a boolean value
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the size
     */
    public int size() {
        return size;
    }

    /**
     * @return the head
     */
    public Node<E> first() {
        // if not empty return head
        if (isEmpty()) {
            return null;
        }
        return head;
    }

    /**
     * @return the tail
     */
    public Node<E> last() {
        // if not empty return the tail
        if (isEmpty()) {
            return null;
        }
        return tail;
    }

    /**
     * @param data the new data to set
     */
    public void addFirst(E data) {
        head = new Node<E>(data, head); // set class var head to a new node with head as its reference
        if (size == 0) {
            tail = head; // set tail to head
        }
        size++; // increase size;
    }

    /**
     * @param tail the tail to set
     */
    public void addLast(E data) {
        Node<E> newNode = new Node<E>(data, null); // create a new node with a reference to null
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode); // set current tail to reference newNode
        }
        tail = newNode; // set the class var tail to newNode
        size++; // increase size
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E removed = head.getData();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return removed;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size() == 1) {
            removeFirst();
        }
        Node<E> temp = head;

        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }

        E removed = temp.getNext().getData();

        temp.setNext(null);

        return removed;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "null";
        }
        String list = "";
        Node curr = head;
        while (curr.next != null) {
            list += "[ " + curr.getData().toString() + " ] -> ";
            curr = curr.next;
        }
        list += "[ " + curr.data + " ] -> null";
        return list;
    }

}

/**
 * LinkedLists
 */
public class LinkedLists {

    public static void main(String[] args) {

        SinglyLinkedList<String> myStringList = new SinglyLinkedList<String>();
        System.out.println(myStringList.toString());
        myStringList.addFirst("LAX");
        System.out.println(myStringList.toString());
        myStringList.addFirst("MIA");
        System.out.println(myStringList.toString());
        myStringList.addLast("ILS");
        System.out.println(myStringList.toString());
        System.out.println("Removed : " + myStringList.removeLast());
        System.out.println(myStringList.toString());
        System.out.println("Removed : " + myStringList.removeFirst());
        System.out.println(myStringList.toString());

    }
}