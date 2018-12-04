import java.util.ArrayList;

/**
 * PriorityQueue
 * 
 * IMPORTANT!! There is another implementation of a queue using a linked list in
 * Assignment 2
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
    }

    @Override
    public T min() {
        T min = priorityQueue.get(1);
        for (T part : priorityQueue) {
            if (part.compareTo(min) < 0) {
                min = part;
            }
        }
        return min;
    }

    @Override
    public T removeMin() {
        T min = priorityQueue.get(0);
        for (T part : priorityQueue) {
            if (part.compareTo(min) < 0) {
                min = part;
            }

        }
        int index = 0;
        for (T part : priorityQueue) {
            if (part.compareTo(min) == 0) {
                break;
            }
            index++;
        }
        priorityQueue.remove(index);
        return min;
    }

}
