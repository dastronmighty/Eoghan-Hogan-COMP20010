
class StringSinglyLinkedList {

    // Nested Node Class Shared between all instances of parent
    private static class Node {
        private String data; // Data stored in this node
        private Node next; // reference to next node

        // node Constructor
        public Node(String data, Node next) {
            this.next = next;
            this.data = data;
        }

        /**
         * @return the data
         */
        public String getData() {
            return data;
        }

        /**
         * @return the next
         */
        public Node getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }

    private int size = 0; // the amount of elements in the list
    private Node head = null; // the head node of the list
    private Node tail = null; // the tail node of the list

    public StringSinglyLinkedList() {
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
    public Node first() {
        // if not empty return head
        if (isEmpty()) {
            return null;
        }
        return head;
    }

    /**
     * @return the tail
     */
    public Node last() {
        // if not empty return the tail
        if (isEmpty()) {
            return null;
        }
        return tail;
    }

    /**
     * @param data the new data to set
     */
    public void addFirst(String data) {
        head = new Node(data, head); // set class var head to a new node with head as its reference
        if (size == 0) {
            tail = head; // set tail to head
        }
        size++; // increase size;
    }

    /**
     * @param tail the tail to set
     */
    public void addLast(String data) {
        Node newNode = new Node(data, null); // create a new node with a reference to null
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode); // set current tail to reference newNode
        }
        tail = newNode; // set the class var tail to newNode
        size++; // increase size
    }

    public String removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node removed = head;
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return removed.getData();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return null;
        }
        String list = "";
        Node curr = head;
        while (curr.next != null) {
            list += "[ " + curr.data + " ] -> ";
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

        StringSinglyLinkedList myStringList = new StringSinglyLinkedList();
        System.out.println(myStringList.toString());
        myStringList.addFirst("LAX");
        System.out.println(myStringList.toString());
        myStringList.addFirst("MIA");
        System.out.println(myStringList.toString());
        myStringList.addLast("ILS");
        System.out.println(myStringList.toString());
        System.out.println("Removed : " + myStringList.removeFirst());
        System.out.println(myStringList.toString());
        System.out.println("Removed : " + myStringList.removeFirst());
        System.out.println(myStringList.toString());
        System.out.println("Removed : " + myStringList.removeFirst());
        System.out.println(myStringList.toString());
        System.out.println("Removed : " + myStringList.removeFirst());
        System.out.println(myStringList.toString());

    }
}