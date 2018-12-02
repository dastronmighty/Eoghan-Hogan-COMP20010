
/**
 * ArrayQueue
 */

import java.lang.reflect.Array;

public class ArrayQueue<T> implements QueueFace<T> {

    private T[] queue;

    /**
     * 
     * @param maxSize the maximum size of this queue
     * 
     * 
     *                if you go outside of this size problems can occur
     */
    public ArrayQueue(int maxSize) {
        queue = (T[]) new Object[maxSize];
        for (int i = 0; i < maxSize; i++) {
            queue[i] = null;
        }
    }

    @Override
    public int size() {
        int length = 0;

        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == null) {
                break;
            }
            length += 1;
        }

        return length;
    }

    @Override
    public boolean empty() {
        return queue[0] == null;
    }

    @Override
    public void enqueue(T element) {
        queue[size()] = element;
    }

    @Override
    public T dequeue() {
        if (empty()) {
            return null;
        }
        int i = 0;
        T dequed = queue[i];
        do {
            queue[i] = queue[++i];
        } while (queue[i] != null);
        queue[i - 1] = null;
        return dequed;
    }

    @Override
    public T front() {
        return queue[0];
    }

    @Override
    public String toString() {
        if (empty()) {
            return "null";
        }
        String arrQueueStr = "(front){";
        int i = 0;
        while (i < size() - 1) {
            arrQueueStr += queue[i].toString() + " - ";
            i++;
        }
        arrQueueStr += queue[i].toString() + "}(back)";
        return arrQueueStr;
    }

}