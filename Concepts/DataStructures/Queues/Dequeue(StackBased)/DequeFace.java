/**
 * DequeFace
 */
public interface DequeFace<T> {

    public void insertFront(T e);

    public void insertBack(T e);

    public void eraseFront();

    public void eraseBack();

    public T front();

    public T back();

    public int size();

    public boolean empty();

}