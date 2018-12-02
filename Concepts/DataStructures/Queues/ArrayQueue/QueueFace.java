/**
 * StackFace
 * 
 * An interface for the Link-Based Queue datatype
 */
public interface QueueFace<T> {

    public void enqueue(T element);

    public T dequeue();

    public T front();

    public int size();

    public boolean empty();

}