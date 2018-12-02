/***
 * This is an implementation of a doubly linked list in java. this example
 * closely follows the book, Data Structures and Algorithms in java. However I
 * have changed variable names
 * 
 * @param <E>
 */

public class DoublyLinkedList<E> {

    private static class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data, Node<E> p, Node<E> n) {
            this.data = data;
            this.next = n;
            this.prev = p;
        }

        /**
         * @return the data
         */
        public E getData() {
            return data;
        }

        /**
         * @return the prev
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * @param prev the prev to set
         */
        public void setPrev(Node<E> prev) {
            this.prev = prev;
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

    private int size = 0;

    private Node<E> header;
    private Node<E> trailer;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
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
    public int getSize() {
        return size;
    }

    /**
     * @return the header
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getData();
    }

    /**
     * @return the trailer
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getData();
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    private void addBetween(E e, Node<E> prevNode, Node<E> nextNode) {
        Node<E> newNode = new Node<>(e, prevNode, nextNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> prevNode = node.getPrev();
        Node<E> nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;
        return node.getData();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "null";
        }
        String stringified = "";
        Node temp = header.getNext();
        stringified += "<Header> <--> ";
        while (temp.getNext() != null) {
            stringified += temp.getData() + " <--> ";
            temp = temp.getNext();
        }
        stringified += "<Trailer>";
        return stringified;
    }

}
