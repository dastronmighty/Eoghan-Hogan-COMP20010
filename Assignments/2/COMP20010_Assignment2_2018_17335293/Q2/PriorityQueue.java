import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Priorityqueue
 * 
 * implementation of a priority queue using a list
 */
public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueFace<T> {

    private ArrayList<T> priorityQueue;

    public PriorityQueue() {
        priorityQueue = new ArrayList<T>();
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void insert(T value) {
        priorityQueue.add(value);
        Collections.sort(priorityQueue);
    }

    @Override
    public T min() {
        return priorityQueue.get(0);
    }

    @Override
    public T removeMin() {
        return priorityQueue.remove(0);
    }

    @Override
    public String toString() {
        return priorityQueue.toString();
    }

}
