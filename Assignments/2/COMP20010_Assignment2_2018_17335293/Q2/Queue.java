public class Queue<E extends Comparable<? super E>> extends DoublyLinkedList<E> {

    private int size;

    public Queue() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(E elem) {
        this.addLast(elem);
        this.size++;
    }

    public E dequeue() {
        this.size--;
        return this.removeFirst();
    }
}
