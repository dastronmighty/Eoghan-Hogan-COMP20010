
/*
This is the generic version of the SinglyLinkedList

You need to change the signature from:

public class SinglyLinkedList {

to:

public class SinglyLinkedList<E> {

and update all the other cases where 'String' should be replaced with 'E'.

 */

import java.util.Iterator;

import sun.jvm.hotspot.opto.Node;

public class SinglyLinkedList<E> {

    private static class Node<E> {
        private E data;
        private Node next;

        public Node(E e, Node n) {
            this.data = e;
            this.next = n;
        }

        public E getData() {
            return data;
        }

        public Node getNode() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;
    private int size = 0;

    public SinglyLinkedListIterator(){
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
        return head;
    }

    public Node last() {
        if (isEmpty()) {
            return null;
        }
        Node last = head;
        while (last.getNode() != null) {

            last = last.getNode();
        }
        return last;
    }

    public void addFirst(E data) {
        if (isEmpty()) {
            head = new Node<E>(data, null);
        } else {
            Node newHead = new Node<E>(data, head);
            head = newHead;
        }
        size++;
    }

    public void addLast(E data) {
        if (isEmpty()) {
            head = new Node<E>(data, null);
        }
        Node last = head;
        while (last.getNode() != null) {
            last = last.getNode();
        }
        Node newLast = new Node<E>(data, null);
        last.setNext(newLast);
        size++;
    }

    public E removeFirst() {
        // TODO
    }

    public E removeLast() {
        // TODO
    }

    public E toString() {

    }

    public Iterator<E> iterator() {
        return new ListIterator<E>(); // create a new instance of the inner class
    }

    private class ListIterator<E> implements Iterator<E> {

        private Node iterator;

        ListIterator() {
            iterator = head;
        }

        @Override
        public boolean hasNext() {
            return (iterator.getNext() != null);
        }

        @Override
        public E next() {
            E data = iterator.getData();
            iterator = iterator.getNext();
            return data;
        }

        @Override
        public void remove() {
            // NOT IMPLEMENTED
        }

    }

    public static void main(String [] args) {
        SinglyLinkedListIterator<> ll = new SinglyLinkedListIterator<String>();
        ll.addLast("Java");
        ll.addLast("C++");
        ll.addLast("Python");
        ll.addLast("Scala");
        System.out.println(ll);

        Iterator it = ll.iterator():
        for(String data: it) {
            System.out.println(data);
        }
    }
}