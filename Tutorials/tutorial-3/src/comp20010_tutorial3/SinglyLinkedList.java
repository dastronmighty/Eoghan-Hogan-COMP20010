/*
This is the generic version of the SinglyLinkedList

You need to change the signature from:

public class SinglyLinkedList {

to:

public class SinglyLinkedList<E> {

and update all the other cases where 'String' should be replaced with 'E'.

 */

public class SinglyLinkedList<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            data = e;
            next = n;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNode() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node first() {
        if (isEmpty()) {
            return null;
        }
        return head.getNode();
    }

    public Node last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNode();
    }

    public void addFirst(E data) {
        head = new Node<>(data, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E returned = head.getData();
        head = head.getNode();
        size--;
        if (size == 0) {
            tail = null;
        }
        return returned;
    }

    // public String removeLast() {
    // }

    public String toString() {
        if (isEmpty()) {
            return "null";
        }
        String stringified = "";
        Node<E> curr = head;
        while (curr.getNode() != null) {
            stringified += curr.getData().toString() + " -> ";
            curr = curr.getNode();
        }
        stringified += curr.getData().toString() + " -> null";
        return stringified;
    }

    public static void main(String[] args) {
        try {
            SinglyLinkedList<String> ll = new SinglyLinkedList<String>();
            System.out.println(ll.toString());
            ll.addLast("Java");
            System.out.println(ll.toString());
            ll.addLast("C++");
            System.out.println(ll.toString());
            ll.addLast("Python");
            System.out.println(ll.toString());
            ll.addLast("Scala");
            System.out.println(ll.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}