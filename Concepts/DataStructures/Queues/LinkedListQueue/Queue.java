/**
 * queue
 */
public class Queue<T> implements QueueFace<T> {

    private static class Node<T> {
        T data;
        Node<T> behind;

        public Node(T data, Node<T> behind) {
            setData(data);
            setBehind(behind);
        }

        /**
         * @return the data
         */
        public T getData() {
            return data;
        }

        /**
         * @return the behind
         */
        public Node<T> getBehind() {
            return behind;
        }

        /**
         * @param data the data to set
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * @param behind the behind to set
         */
        public void setBehind(Node<T> behind) {
            this.behind = behind;
        }
    }

    Node<T> front;
    Node<T> back;
    int size;

    public Queue() {
        front = null;
        back = null;
        size = 0;
    }

    /***
     * @return wether the queue is empty or not
     */
    @Override
    public boolean empty() {
        return size == 0;
    }

    /**
     * @param element The element you want to add to the back of the queue
     */
    @Override
    public void enqueue(T element) {
        if (empty()) {
            back = new Node<T>(element, null);
            front = back;
        } else {
            Node<T> newBack = new Node<T>(element, null);
            back.setBehind(newBack);
            back = newBack;
        }
        size++;
    }

    /**
     * 
     */
    @Override
    public T dequeue() {
        if (empty()) {
            return null;
        }
        T data = front.getData();
        front = front.getBehind(); // set the front to whatever is behind it
        size--;
        return data;
    }

    @Override
    public T front() {
        if (empty()) {
            return null;
        }
        return front.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String queueString = "(front)";
        if (empty()) {
            return "null\n";
        }
        Node<T> temp = front;
        while (temp.getBehind() != null) {
            queueString += (temp.getData().toString() + " - ");
            temp = temp.getBehind();
        }
        queueString += (temp.getData().toString() + "(back)\n");
        return queueString;
    }

}