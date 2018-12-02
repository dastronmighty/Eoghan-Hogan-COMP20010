/**
 * ArrayStack
 */
public class ArrayStack<T> implements StackFace<T> {

    T[] stack;

    /**
     * 
     * @param maxSize the maximum size of the Stack
     * 
     *                if you go outside of this size problems will occur
     */
    public ArrayStack(int maxSize) {

        stack = (T[]) new Object[maxSize + 1];
        for (int i = 0; i < maxSize; i++) {
            stack[i] = null;
        }
    }

    @Override
    public boolean empty() {
        return stack[0] == null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] == null) {
                break;
            }
            size++;
        }
        return size;
    }

    @Override
    public void push(T item) {
        if (size() + 1 == stack.length) {
            System.err.println("Could Not Add item to stack! Stack is at full capactity");
        } else {
            for (int i = size() + 1; i > 0; i--) {
                stack[i] = stack[i - 1];
            }
            stack[0] = item;
        }
    }

    @Override
    public T pop() {
        if (empty()) {
            return null;
        }
        int i = 0;
        T popped = stack[i];
        do {
            stack[i] = stack[++i];
        } while (stack[i] != null);
        stack[i - 1] = null;
        return popped;
    }

    @Override
    public T top() {
        return stack[0];
    }

    @Override
    public String toString() {
        if (empty()) {
            return "null";
        }
        String arrStackStr = "(top){";
        int i = 0;
        while (i < size() - 1) {
            arrStackStr += stack[i].toString() + " - ";
            i++;
        }
        arrStackStr += stack[i].toString() + "}(bottom)";
        return arrStackStr;
    }

}