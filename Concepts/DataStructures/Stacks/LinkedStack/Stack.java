/**
 * Stack
 */
public class Stack<T> implements StackFace<T>, Cloneable {

    private static class Node<T> {
        private T data;
        private Node<T> under;

        public Node(T data, Node<T> under) {
            setData(data);
            setUnder(under);
        }

        /**
         * @param data the data to set
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * @param under the under to set
         */
        public void setUnder(Node<T> under) {
            this.under = under;
        }

        /**
         * @return the data
         */
        public T getData() {
            return data;
        }

        /**
         * @return the under
         */
        public Node<T> getUnder() {
            return under;
        }
    }

    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(T item) {
        if (empty()) {
            top = new Node<T>(item, null);
            size++;
        } else {
            Node<T> newTop = new Node<T>(item, top);
            top = newTop;
            size++;
        }
    }

    public T pop() {
        if (empty()) {
            return null;
        }
        T popped = top.getData();
        top = top.getUnder(); // set the top to whatever is underneath the top
        size--;
        return popped;
    }

    @Override
    public T top() {
        return top.getData();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String stackString = "";
        if (empty()) {
            return "null\n";
        }
        Node<T> temp = top;
        while (temp.getUnder() != null) {
            stackString += (temp.getData().toString() + "\n\\/\n");
            temp = temp.getUnder();
        }
        stackString += (temp.getData().toString() + "\n\\/\nnull\n\n");
        return stackString;
    }

    public Stack<T> clone() {
        if (empty()) {
            return null;
        }
        Stack<T> clone = new Stack<T>();
        Stack<T> tempStack = new Stack<T>();

        Node<T> tempNode = top;
        while (tempNode.getUnder() != null) {
            tempStack.push(tempNode.getData());
            tempNode = tempNode.getUnder();
        }
        tempStack.push(tempNode.getData());

        while (!tempStack.empty()) {
            clone.push(tempStack.pop());
        }

        return clone;

    }
}