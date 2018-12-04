import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Priorityqueue
 * 
 * implementation of a priority queue using a list
 */
public class PriorityQueue<E extends Comparable<E>> implements PriorityQueueFace<E> {

    private Queue<E> container;

    public PriorityQueue() {
        this.container = new Queue<>();
    }

    @Override
    public int size() {
        return this.container.size();
    }

    @Override
    public E min() {
        return (E) this.container.first();
    }

    @Override
    public E removeMin() {
        return this.container.dequeue();
    }

    @Override
    public void insert(E elem) {
        this.container.enqueue(elem);
        MergeSort.sort(this.container); // TODO It'd be way more efficient to just insert it in the right place but this
                                        // is the way that the TA said to do it
    }

    @Override
    public boolean isEmpty() {
        return this.container.isEmpty();
    }

}
